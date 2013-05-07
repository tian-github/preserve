package com.preserve.core.vo;

import java.util.Map.Entry;

public class IDEntry implements Entry<String,String> {

	private String key;
	
	private String value ;
	
	public IDEntry(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return key;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public String setValue(String paramV) {
		// TODO Auto-generated method stub
		this.value=paramV;
		return this.value;
	}
	


}
