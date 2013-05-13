package com.preserve.core.vo;

import java.util.HashMap;
import java.util.Map;

import com.preserve.core.annotation.IDStrategy;

public class ModelInfo {

	private String tableName;
	private String className;
	private IDEntry idEntry;
	private int idStrategy = IDStrategy.IN_CREMENT;// 默认自增

	private Map<String, ModelFieldVo> fieldMappings = new HashMap<String, ModelFieldVo>();

	public ModelInfo addFieldMapping(String key, ModelFieldVo value) {
		fieldMappings.put(key, value);
		return this;
	}

	public ModelInfo addFieldMapping(Map<String, ModelFieldVo> paramMap) {
		fieldMappings.putAll(paramMap);
		return this;
	}

	public String getTableName() {
		return tableName;
	}

	public ModelInfo setTableName(String tableName) {
		this.tableName = tableName;
		return this;
	}

	public String getClassName() {
		return className;
	}

	public ModelInfo setClassName(String className) {
		this.className = className;
		return this;
	}

	public IDEntry getIdEntry() {
		return idEntry;
	}

	public ModelInfo setIdEntry(IDEntry idEntry) {
		this.idEntry = idEntry;
		return this;
	}

	public int getIdStrategy() {
		return idStrategy;
	}

	public ModelInfo setIdStrategy(int idStrategy) {
		this.idStrategy = idStrategy;
		return this;
	}

	public Map<String, ModelFieldVo> getFieldMappings() {
		return fieldMappings;
	}

	public void setFieldMappings(Map<String, ModelFieldVo> fieldMappings) {
		this.fieldMappings = fieldMappings;
	}

	public boolean hasIdColumn() {
		if (idEntry != null) {
			return true;
		}
		return false;
	}

}
