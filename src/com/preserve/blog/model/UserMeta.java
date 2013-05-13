package com.preserve.blog.model;

import java.sql.Types;

import com.preserve.core.annotation.Column;
import com.preserve.core.model.BaseModel;

/**
 * 用户扩展表
 * 
 * @author 
 * @version 1.0 2013-05-08
 */
public class UserMeta extends BaseModel {

	@Column(dataType=Types.INTEGER)
	protected long userId;
	
	/**
	 * key
	 */
	@Column(length=500)
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
	@Column(length=500)
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

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
}
