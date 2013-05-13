package com.preserve.core.vo;

public class ModelFieldVo {
	
	private String name ;
	private boolean notNull;
	private Integer length ;
	private int dataType ;
	
	public ModelFieldVo(String name, boolean notNull, Integer length,
			int dataType) {
		super();
		this.name = name;
		this.notNull = notNull;
		this.length = length;
		this.dataType = dataType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isNotNull() {
		return notNull;
	}
	public void setNotNull(boolean notNull) {
		this.notNull = notNull;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public int getDataType() {
		return dataType;
	}
	public void setDataType(int dataType) {
		this.dataType = dataType;
	}
	

}
