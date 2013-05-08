package com.preserve.core.utils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.commons.lang.StringUtils;

import com.preserve.blog.model.Posts;
import com.preserve.core.annotation.Column;
import com.preserve.core.annotation.IDStrategy;
import com.preserve.core.annotation.Id;
import com.preserve.core.annotation.Table;
import com.preserve.core.vo.IDEntry;
import com.preserve.core.vo.ModelInfo;

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

			sql = sql.replace("!{tb}", tb)
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

				if (!(f.isAnnotationPresent(Column.class) || f
						.isAnnotationPresent(Id.class))) {
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

	/**
	 * 简单创建表sql
	 * 
	 * @param mf
	 * @return
	 */
	public static String createTableSQL(ModelInfo mf) {

		StringBuffer buffer_total = new StringBuffer(
				"DROP TABLE IF EXISTS `%s`;"
						+ "CREATE TABLE `%s` (\n %s) ENGINE=InnoDB DEFAULT CHARSET=utf8;");

		Map<String, String> fields = mf.getFieldMappings();

		String value = mf.getIdEntry().getValue();
		String idKey = mf.getIdEntry().getKey();

		StringBuffer buffer = new StringBuffer("");

		boolean first = true;
		for (String key : fields.keySet()) {
			if (!key.equals(idKey)) {
				if (first) {
					first = false;
				} else {
					buffer.append(" ,\n ");
				}

				String attr = "`!{field}` varchar(50) NOT NULL".replace(
						"!{field}", fields.get(key));
				buffer.append(attr);
			}
		}
		if (StringUtils.isNotEmpty(value)) {
			String idAttr = String
					.format(",\n `%s` int(11) NOT NULL auto_increment ,PRIMARY KEY  (`%s`)",
							value, value);
			buffer.append(idAttr);
		}

		return String.format(buffer_total.toString(), mf.getTableName(),
				mf.getTableName(), buffer.toString());
	}
	
	/**
	 * 从包package中获取所有的Class
	 * 
	 * @param pack
	 * @return
	 */
	public static Set<Class<?>> getClasses(String pack) {

		// 第一个class类的集合
		Set<Class<?>> classes = new LinkedHashSet<Class<?>>();
		// 是否循环迭代
		boolean recursive = true;
		// 获取包的名字 并进行替换
		String packageName = pack;
		String packageDirName = packageName.replace('.', '/');
		// 定义一个枚举的集合 并进行循环来处理这个目录下的things
		Enumeration<URL> dirs;
		try {
			dirs = Thread.currentThread().getContextClassLoader().getResources(
					packageDirName);
			// 循环迭代下去
			while (dirs.hasMoreElements()) {
				// 获取下一个元素
				URL url = dirs.nextElement();
				// 得到协议的名称
				String protocol = url.getProtocol();
				// 如果是以文件的形式保存在服务器上
				if ("file".equals(protocol)) {
					System.err.println("file类型的扫描");
					// 获取包的物理路径
					String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
					// 以文件的方式扫描整个包下的文件 并添加到集合中
					findAndAddClassesInPackageByFile(packageName, filePath,
							recursive, classes);
				} else if ("jar".equals(protocol)) {
					// 如果是jar包文件
					// 定义一个JarFile
					System.err.println("jar类型的扫描");
					JarFile jar;
					try {
						// 获取jar
						jar = ((JarURLConnection) url.openConnection())
								.getJarFile();
						// 从此jar包 得到一个枚举类
						Enumeration<JarEntry> entries = jar.entries();
						// 同样的进行循环迭代
						while (entries.hasMoreElements()) {
							// 获取jar里的一个实体 可以是目录 和一些jar包里的其他文件 如META-INF等文件
							JarEntry entry = entries.nextElement();
							String name = entry.getName();
							// 如果是以/开头的
							if (name.charAt(0) == '/') {
								// 获取后面的字符串
								name = name.substring(1);
							}
							// 如果前半部分和定义的包名相同
							if (name.startsWith(packageDirName)) {
								int idx = name.lastIndexOf('/');
								// 如果以"/"结尾 是一个包
								if (idx != -1) {
									// 获取包名 把"/"替换成"."
									packageName = name.substring(0, idx)
											.replace('/', '.');
								}
								// 如果可以迭代下去 并且是一个包
								if ((idx != -1) || recursive) {
									// 如果是一个.class文件 而且不是目录
									if (name.endsWith(".class")
											&& !entry.isDirectory()) {
										// 去掉后面的".class" 获取真正的类名
										String className = name.substring(
												packageName.length() + 1, name
														.length() - 6);
										try {
											// 添加到classes
											classes.add(Class
													.forName(packageName + '.'
															+ className));
										} catch (ClassNotFoundException e) {
											// log
											// .error("添加用户自定义视图类错误 找不到此类的.class文件");
											e.printStackTrace();
										}
									}
								}
							}
						}
					} catch (IOException e) {
						// log.error("在扫描用户定义视图时从jar包获取文件出错");
						e.printStackTrace();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return classes;
	}
	
	/**
	 * 以文件的形式来获取包下的所有Class
	 * 
	 * @param packageName
	 * @param packagePath
	 * @param recursive
	 * @param classes
	 */
	public static void findAndAddClassesInPackageByFile(String packageName,
			String packagePath, final boolean recursive, Set<Class<?>> classes) {
		// 获取此包的目录 建立一个File
		File dir = new File(packagePath);
		// 如果不存在或者 也不是目录就直接返回
		if (!dir.exists() || !dir.isDirectory()) {
			// log.warn("用户定义包名 " + packageName + " 下没有任何文件");
			return;
		}
		// 如果存在 就获取包下的所有文件 包括目录
		File[] dirfiles = dir.listFiles(new FileFilter() {
			// 自定义过滤规则 如果可以循环(包含子目录) 或则是以.class结尾的文件(编译好的java类文件)
			public boolean accept(File file) {
				return (recursive && file.isDirectory())
						|| (file.getName().endsWith(".class"));
			}
		});
		// 循环所有文件
		for (File file : dirfiles) {
			// 如果是目录 则继续扫描
			if (file.isDirectory()) {
				findAndAddClassesInPackageByFile(packageName + "."
						+ file.getName(), file.getAbsolutePath(), recursive,
						classes);
			} else {
				// 如果是java类文件 去掉后面的.class 只留下类名
				String className = file.getName().substring(0,
						file.getName().length() - 6);
				try {
					// 添加到集合中去
					//classes.add(Class.forName(packageName + '.' + className));
                                         //经过回复同学的提醒，这里用forName有一些不好，会触发static方法，没有使用classLoader的load干净
                                        classes.add(Thread.currentThread().getContextClassLoader().loadClass(packageName + '.' + className));  
                               } catch (ClassNotFoundException e) {
					// log.error("添加用户自定义视图类错误 找不到此类的.class文件");
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
			double s=808.27+23.95+40;
			System.out.println(s);
		
		Set<Class<?>> clazzs=	getClasses("com.preserve.blog.model");
		StringBuffer buffer=new StringBuffer();
		for(Class clazz:clazzs){
			
			ModelInfo mf = parseModelInfo(clazz);
			String sql =createTableSQL(mf);
			buffer.append(sql);
			buffer.append("\n\n");
		}

		System.out.println(buffer.toString());
	}

}
