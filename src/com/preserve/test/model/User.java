package com.preserve.test.model;

import com.preserve.core.model.BaseModel;

//@Table(name="tb_user")
public class User extends BaseModel {
	
//	@Id(name="user_id")
	private String userId;
//	@Column(name="name")
	private String name ;
//	@Column(name="pas")
	private String pwd;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
