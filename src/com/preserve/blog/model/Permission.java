package com.preserve.blog.model;

import com.preserve.core.annotation.Column;
import com.preserve.core.model.BaseModel;

public class Permission extends BaseModel {
	
	private String name ;
	@Column(length=500)
	private String description ;
//	改权限控制资源地址
	@Column(length=500)
	private String url ;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
