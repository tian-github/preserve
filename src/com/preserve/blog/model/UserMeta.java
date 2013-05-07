package com.preserve.blog.model;

import com.preserve.core.model.BaseModel;

/**
 * 用户扩展表
 * 
 * @author 
 * @version 1.0 2013-05-08
 */
public class UserMeta extends BaseModel {

	/**
	 * key
	 */
	protected String metaKey;
	
	/**
	 * @return key
	 */
	public String getMetaKey() {
		return metaKey;
	}
	
	/**
	 * @param metaKey key
	 */
	public void setMetaKey(String metaKey) {
		this.metaKey = metaKey;
	}
	
	/**
	 * value
	 */
	protected String metaValue;
	
	/**
	 * @return value
	 */
	public String getMetaValue() {
		return metaValue;
	}
	
	/**
	 * @param metaValue value
	 */
	public void setMetaValue(String metaValue) {
		this.metaValue = metaValue;
	}
}
