package com.preserve.core.utils;

import java.lang.reflect.Field;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

public class SQLTypeMapper {

	private static Map<Integer, String> MySQLMapper = new HashMap<Integer, String>();
	
	private static void initMySQLMapper() {
		//MySQLMapper.put(Types., value)
		MySQLMapper.put(Types.BIT, "bit");
		MySQLMapper.put(Types.TINYINT, "tinyint");
		MySQLMapper.put(Types.SMALLINT, "smallint");
		MySQLMapper.put(Types.INTEGER, "int");
		MySQLMapper.put(Types.BIGINT, "bigint");
		MySQLMapper.put(Types.FLOAT, "float");
		MySQLMapper.put(Types.REAL, "real");
		MySQLMapper.put(Types.DOUBLE, "double");
		MySQLMapper.put(Types.NUMERIC, "numeric");
		MySQLMapper.put(Types.DECIMAL, "decimal");
		MySQLMapper.put(Types.CHAR, "char");
		MySQLMapper.put(Types.VARCHAR, "varchar");
		MySQLMapper.put(Types.LONGVARCHAR, "longvarchar");
		MySQLMapper.put(Types.DATE, "date");
		MySQLMapper.put(Types.TIME, "time");
		MySQLMapper.put(Types.TIMESTAMP, "timestamp");
		MySQLMapper.put(Types.BINARY, "tinyblob");
		MySQLMapper.put(Types.VARBINARY, "varbinary");
//		MySQLMapper.put(Types.LONGVARBINARY, "longvarbinary");
		MySQLMapper.put(Types.NULL, "null");
//		MySQLMapper.put(Types.OTHER, "other");
//		MySQLMapper.put(Types.JAVA_OBJECT, "java_object");
//		MySQLMapper.put(Types.DISTINCT, "distinct");
//		MySQLMapper.put(Types.STRUCT, "struct");
//		MySQLMapper.put(Types.ARRAY, "array");
		MySQLMapper.put(Types.BLOB, "blob");
		MySQLMapper.put(Types.CLOB, "clob");
		MySQLMapper.put(Types.REF, "ref");
//		MySQLMapper.put(Types.DATALINK, "datalink");
		MySQLMapper.put(Types.BOOLEAN, "boolean");
//		MySQLMapper.put(Types.ROWID, "rowid");
		MySQLMapper.put(Types.NCHAR, "nchar");
		MySQLMapper.put(Types.NVARCHAR, "nvarchar");
		MySQLMapper.put(Types.LONGNVARCHAR, "text");
		MySQLMapper.put(Types.NCLOB, "nclob");
//		MySQLMapper.put(Types.SQLXML, "sqlxml");
	}

	public static String getMySqlMapper(int type) {
		if (MySQLMapper.isEmpty()) {
			initMySQLMapper();
		}
		return MySQLMapper.get(type);
	}
	
	
	public static void main(String[] args) {
		buildType();
	}
	
	public static void buildType(){
		
		Class clazz=Types.class;
		Field[] fields=clazz.getFields();
		for(Field f: fields){
//			System.out.println(f.getName());
			System.out.println("MySQLMapper.put(Types."+f.getName()+", \""+f.getName().toLowerCase()+"\");");
			
		}
	}
	

}
