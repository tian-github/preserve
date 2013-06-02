package com.preserve.core.utils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.BeanProcessor;

import com.preserve.core.vo.ModelInfo;

/**
 * 根据注解解析成对象的转换器
 */
public class BeanRowProcessor extends BeanProcessor {

	private static final Map primitiveDefaults;

	@Override
	public <T> T toBean(ResultSet resultset, Class<T> class1)
			throws SQLException {

		//有必要做cache ~
		ModelInfo mf = GeneralSQLBuilder.parseModelInfo(class1);
		Map<String, String> s_map = mf.toSimpleMap();

		Map<String, PropertyDescriptor> mpd = getPropertyDescriptors(class1,
				s_map);

		return (T) createBean(resultset, class1, mpd);
	}

	@Override
	public <T> List<T> toBeanList(ResultSet resultset, Class<T> class1)
			throws SQLException {
		// TODO Auto-generated method stub

		List<T> results = new ArrayList<T>();
		if (!resultset.next()) {
			return results;
		}
		ModelInfo mf = GeneralSQLBuilder.parseModelInfo(class1);
		Map<String, String> s_map = mf.toSimpleMap();
		Map<String, PropertyDescriptor> mpd = getPropertyDescriptors(class1,
				s_map);
		do {
			Object rBean = createBean(resultset, class1, mpd);
			results.add((T) rBean);
		} while (resultset.next());
		return results;
	}

	//	找到数据库字段跟class字段对应关系
	private Map<String, PropertyDescriptor> getPropertyDescriptors(Class c,
			Map<String, String> map) throws SQLException {

		Map<String, PropertyDescriptor> mp = new HashMap<String, PropertyDescriptor>();
		try {
			for (String key : map.keySet()) {
				mp.put(map.get(key), new PropertyDescriptor(key, c));
			}
			return mp;
		} catch (IntrospectionException e) {
			// TODO: handle exception
			throw new SQLException("bean model mapping error~! ");

		}
	}

	private Object createBean(ResultSet rs, Class type,
			Map<String, PropertyDescriptor> mp) throws SQLException {
		Object bean = newInstance(type);

		for (String key : mp.keySet()) {

			PropertyDescriptor prop = mp.get(key);
			Class propType = prop.getPropertyType();
			Object value = processColumnByName(rs, key, propType);
			if (propType != null && value == null && propType.isPrimitive())
				value = primitiveDefaults.get(propType);
			callSetter(bean, prop, value);
		}
		return bean;
	}

	/**
	 * 根据列名找数据
	 * @description TODO
	 * @param rs
	 * @param index
	 * @param propType
	 * @return
	 * @throws SQLException
	 */
	protected Object processColumnByName(ResultSet rs, String index,
			Class<?> propType) throws SQLException {
		// TODO Auto-generated method stub
		{
			if (!propType.isPrimitive() && rs.getObject(index) == null)
				return null;
			if (propType.equals(java.lang.String.class))
				return rs.getString(index);
			if (propType.equals(Integer.TYPE)
					|| propType.equals(java.lang.Integer.class))
				return Integer.valueOf(rs.getInt(index));
			if (propType.equals(Boolean.TYPE)
					|| propType.equals(java.lang.Boolean.class))
				return Boolean.valueOf(rs.getBoolean(index));
			if (propType.equals(Long.TYPE)
					|| propType.equals(java.lang.Long.class))
				return Long.valueOf(rs.getLong(index));
			if (propType.equals(Double.TYPE)
					|| propType.equals(java.lang.Double.class))
				return Double.valueOf(rs.getDouble(index));
			if (propType.equals(Float.TYPE)
					|| propType.equals(java.lang.Float.class))
				return Float.valueOf(rs.getFloat(index));
			if (propType.equals(Short.TYPE)
					|| propType.equals(java.lang.Short.class))
				return Short.valueOf(rs.getShort(index));
			if (propType.equals(Byte.TYPE)
					|| propType.equals(java.lang.Byte.class))
				return Byte.valueOf(rs.getByte(index));
			if (propType.equals(java.sql.Timestamp.class))
				return rs.getTimestamp(index);
			if (propType.equals(java.sql.SQLXML.class))
				return rs.getSQLXML(index);
			else
				return rs.getObject(index);
		}

	}

	private void callSetter(Object target, PropertyDescriptor prop, Object value)
			throws SQLException {
		Method setter = prop.getWriteMethod();
		if (setter == null)
			return;
		Class params[] = setter.getParameterTypes();
		try {
			if (value instanceof Date) {
				String targetType = params[0].getName();
				if ("java.sql.Date".equals(targetType))
					value = new java.sql.Date(((Date) value).getTime());
				else if ("java.sql.Time".equals(targetType))
					value = new Time(((Date) value).getTime());
				else if ("java.sql.Timestamp".equals(targetType))
					value = new Timestamp(((Date) value).getTime());
			}
			if (isCompatibleType(value, params[0]))
				setter.invoke(target, new Object[] { value });
			else
				throw new SQLException((new StringBuilder())
						.append("Cannot set ").append(prop.getName())
						.append(": incompatible types, cannot convert ")
						.append(value.getClass().getName()).append(" to ")
						.append(params[0].getName()).toString());
		} catch (IllegalArgumentException e) {
			throw new SQLException((new StringBuilder()).append("Cannot set ")
					.append(prop.getName()).append(": ").append(e.getMessage())
					.toString());
		} catch (IllegalAccessException e) {
			throw new SQLException((new StringBuilder()).append("Cannot set ")
					.append(prop.getName()).append(": ").append(e.getMessage())
					.toString());
		} catch (InvocationTargetException e) {
			throw new SQLException((new StringBuilder()).append("Cannot set ")
					.append(prop.getName()).append(": ").append(e.getMessage())
					.toString());
		}
	}

	private boolean isCompatibleType(Object value, Class type) {
		if (value == null || type.isInstance(value))
			return true;
		if (type.equals(Integer.TYPE) && Integer.class.isInstance(value))
			return true;
		if (type.equals(Long.TYPE) && Long.class.isInstance(value))
			return true;
		if (type.equals(Double.TYPE) && Double.class.isInstance(value))
			return true;
		if (type.equals(Float.TYPE) && Float.class.isInstance(value))
			return true;
		if (type.equals(Short.TYPE) && Short.class.isInstance(value))
			return true;
		if (type.equals(Byte.TYPE) && Byte.class.isInstance(value))
			return true;
		if (type.equals(Character.TYPE) && Character.class.isInstance(value))
			return true;
		return type.equals(Boolean.TYPE) && Boolean.class.isInstance(value);
	}

	//	创建对象
	protected Object newInstance(Class c) throws SQLException {
		try {
			return c.newInstance();
		} catch (InstantiationException e) {
			throw new SQLException((new StringBuilder())
					.append("Cannot create ").append(c.getName()).append(": ")
					.append(e.getMessage()).toString());
		} catch (IllegalAccessException e) {
			throw new SQLException((new StringBuilder())
					.append("Cannot create ").append(c.getName()).append(": ")
					.append(e.getMessage()).toString());
		}
	}

	//记录原始数据类型
	static {
		primitiveDefaults = new HashMap();
		primitiveDefaults.put(Integer.TYPE, Integer.valueOf(0));
		primitiveDefaults.put(Short.TYPE, Short.valueOf((short) 0));
		primitiveDefaults.put(Byte.TYPE, Byte.valueOf((byte) 0));
		primitiveDefaults.put(Float.TYPE, Float.valueOf(0.0F));
		primitiveDefaults.put(Double.TYPE, Double.valueOf(0.0D));
		primitiveDefaults.put(Long.TYPE, Long.valueOf(0L));
		primitiveDefaults.put(Boolean.TYPE, Boolean.FALSE);
		primitiveDefaults.put(Character.TYPE, Character.valueOf('\0'));
	}

}
