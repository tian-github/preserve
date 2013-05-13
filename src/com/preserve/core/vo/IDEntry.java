package com.preserve.core.vo;

import java.util.Map.Entry;

public class IDEntry implements Entry<String, ModelFieldVo> {

	private String key;

	private ModelFieldVo value;

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return key;
	}

	@Override
	public ModelFieldVo getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public ModelFieldVo setValue(ModelFieldVo value) {
		// TODO Auto-generated method stub
		return value;
	}

	public IDEntry(String key, ModelFieldVo value) {
		super();
		this.key = key;
		this.value = value;
	}

}
