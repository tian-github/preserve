package com.preserve.test.model;

import com.preserve.core.annotation.Column;
import com.preserve.core.annotation.IDStrategy;
import com.preserve.core.annotation.Id;
import com.preserve.core.annotation.Table;
import com.preserve.core.model.BaseModel;

@Table(name = "user")
public class User extends BaseModel {

	@Id(name = "user_id",IDStrategy=IDStrategy.IN_CREMENT)
	private String userId;
	@Column(name = "name")
	private String name;
	@Column(name = "pwd")
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
