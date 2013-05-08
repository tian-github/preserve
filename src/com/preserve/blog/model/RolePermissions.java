package com.preserve.blog.model;

import com.preserve.core.model.BaseModel;

public class RolePermissions extends BaseModel {
	
	private long roleId;
	private long permissionId;
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public long getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(long permissionId) {
		this.permissionId = permissionId;
	}
	

}
