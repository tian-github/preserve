package com.preserve.blog.model;

import com.preserve.core.model.BaseModel;

/**
 * 
 * @author 
 *	角色
 */
public class Role extends BaseModel {

	private String name ;
	private String description ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
