package com.preserve.core.utils;

import java.lang.reflect.Field;

import org.apache.commons.lang.StringUtils;

import com.preserve.blog.model.Posts;
import com.preserve.core.annotation.Column;
import com.preserve.core.annotation.IDStrategy;
import com.preserve.core.annotation.Id;
import com.preserve.core.annotation.Table;
import com.preserve.core.vo.IDEntry;
import com.preserve.core.vo.ModelInfo;
import com.preserve.test.model.User;

public class GeneralSQLBuilder {

	public static String getInsertSQL(Class<?> model) {

		String sql = " INSERT INTO !{tb} (!{field}) VALUES(!{m_field}) ";
		ModelInfo mf = parseModelInfo(model);

		String tb = mf.getTableName();
		// 是否过滤ID字段
		boolean filter = mf.getIdStrategy() != IDStrategy.IN_CREMENT ? false
				: true;
		String key = null;
		if (mf.hasIdColumn()) {
			key = mf.getIdEntry().getKey();
		}

		StringBuffer f_buffer = new StringBuffer();
		StringBuffer m_buffer = new StringBuffer();

		boolean first = true;
		for (String f_key : mf.getFieldMappings().keySet()) {

			if (!(filter && f_key.equals(key))) {
				if (first) {
					first = false;
				} else {
					f_buffer.append(" , ");
					m_buffer.append(" , ");
				}
				f_buffer.append(mf.getFieldMappings().get(f_key));
				m_buffer.append(":" + f_key);
			}
		}

		sql = sql.replace("!{tb}", tb).replace("!{field}", f_buffer.toString())
				.replace("!{m_field}", m_buffer.toString());

		return sql;
	}

	public static String getUpdateSQL(Class<?> model) {

		String sql = " UPDATE TABLE !{tb} SET !{fieldBlock} where !{whereBlock} ";

		ModelInfo mf = parseModelInfo(model);
		String tb = mf.getTableName();

		String key = null;
		if (mf.hasIdColumn()) {
			key = mf.getIdEntry().getKey();
		} else {
			// 空主键update需要额外写
			return null;
		}

		StringBuffer fieldBlock = new StringBuffer();
		StringBuffer whereBlock = new StringBuffer(" "
				+ mf.getIdEntry().getValue() + " = :" + key);

		boolean first = true;
		for (String f_key : mf.getFieldMappings().keySet()) {

			String f_value = mf.getFieldMappings().get(f_key);

			if (!f_key.equals(key)) {
				if (first) {
					first = false;
				} else {
					fieldBlock.append(" , ");
				}
				fieldBlock.append(" " + f_value + " = :" + f_key);
			}
		}

		sql = sql.replace("!{tb}", tb)
				.replace("!{fieldBlock}", fieldBlock.toString())
				.replace("!{whereBlock}", whereBlock.toString());
		return sql;
	}

	public static String getDeleteSQL(Class<?> model) {
		String sql = " DELETE !{tb} where !{key}=:!{value} ";
		ModelInfo mf = parseModelInfo(model);
		String tb = mf.getTableName();

		String key = null;
		if (mf.hasIdColumn()) {
			key = mf.getIdEntry().getKey();

			sql=sql.replace("!{tb}", tb)
					.replace("!{key}", mf.getIdEntry().getValue())
					.replace("!{value}", key);
			return sql;
		} else {
			// 空主键update需要额外写
			return null;
		}

	}

	/**
	 * 分析注解
	 * 
	 * @param model
	 * @return
	 */
	public static ModelInfo parseModelInfo(Class<?> model) {

		ModelInfo mf = new ModelInfo();

		String tbName = null;
		String className = model.getSimpleName();

		if (model.isAnnotationPresent(Table.class)) {
			Table tb = (Table) model.getAnnotation(Table.class);
			tbName = tb.name();
		}

		if (StringUtils.isEmpty(tbName)) {
			tbName = parseHump(className);
		}

		mf.setClassName(className);
		mf.setTableName(tbName);
		// 字段注解分析
		getAllDeclaredFieldsInfo(model, mf);

		return mf;
	}

	/**
	 * 解析注解,包括extends关系字段
	 * 
	 * @param clazz
	 * @param mf
	 * @return
	 */
	private static ModelInfo getAllDeclaredFieldsInfo(Class<?> clazz,
			ModelInfo mf) {
		do {
			if (clazz == Object.class) {
				break;
			}
			Field[] fields = clazz.getDeclaredFields();
			for (int i = 0, len = fields.length; i < len; i++) {
				Field f = fields[i];
				String f_name = f.getName();
				if (f.isAnnotationPresent(Id.class)) {
					Id id = f.getAnnotation(Id.class);
					int sty = id.IDStrategy();
					String name = id.name();

					if (StringUtils.isEmpty(name)) {
						name = parseHump(f_name);
					}
					IDEntry entry = new IDEntry(f_name, name);
					// 子类优先
					if (mf.getIdEntry() == null) {
						mf.setIdEntry(entry);
						mf.setIdStrategy(sty);
					}
					// 子类优先
					if (!mf.getFieldMappings().containsKey(f_name)) {
						mf.addFieldMapping(f_name, name);
					}

				}
				if (f.isAnnotationPresent(Column.class)) {
					Column column = f.getAnnotation(Column.class);
					String name = column.name();
					if (StringUtils.isEmpty(name)) {
						name = parseHump(f_name);
					}
					if (!mf.getFieldMappings().containsKey(f_name)) {
						mf.addFieldMapping(f_name, name);
					}
				}
				
				if(!(f.isAnnotationPresent(Column.class)||f.isAnnotationPresent(Id.class)))
				{
					String name = parseHump(f_name);
					if (!mf.getFieldMappings().containsKey(f_name)) {
						mf.addFieldMapping(f_name, name);
					}
				}
				
			}
			clazz = clazz.getSuperclass();

		} while (clazz != Object.class);

		return mf;

	}

	/**
	 * 驼峰命名转化，UserId -->user_id
	 * 
	 * @param name
	 * @return
	 */
	public static String parseHump(String name) {
		StringBuffer buffer = new StringBuffer("");
		for (int i = 0, len = name.length(); i < len; i++) {
			char data = name.charAt(i);
			// 首字母小写
			if (i == 0) {
				data = Character.toLowerCase(data);
			}
			if (Character.isUpperCase(data)) {
				buffer.append("_");
				data = Character.toLowerCase(data);
			}
			buffer.append(data);
		}
		return buffer.toString();
	}

	public static void main(String[] args) {

		System.out.println(parseHump("GeneralSql"));

		ModelInfo mf = parseModelInfo(Posts.class);
		System.out.println(mf);

		System.out.println(getInsertSQL(Posts.class));

		// System.out.println(Character.toLowerCase('1'));
		// System.out.println((int)'a');
		// System.out.println((int)'A');
		// System.out.println((int)'z');
		// System.out.println((int)'Z');
	}

}
