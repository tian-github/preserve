package com.preserve.blog.model;

import java.sql.Types;

import com.preserve.core.annotation.Column;
import com.preserve.core.model.BaseModel;

public class RolePermissions extends BaseModel {

	@Column(dataType = Types.INTEGER)
	private long roleId;
	@Column(dataType = Types.INTEGER)
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
