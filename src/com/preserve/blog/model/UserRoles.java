package com.preserve.blog.model;

import java.sql.Types;

import com.preserve.core.annotation.Column;
import com.preserve.core.model.BaseModel;

public class UserRoles extends BaseModel {
	
	@Column(notNull=true,length=11,dataType=Types.INTEGER)
	private long userId;
	
	@Column(notNull=true,length=11,dataType=Types.INTEGER)
	private long roleId;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	

}
