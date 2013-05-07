package com.preserve.blog.model;

import java.util.Date;

import com.preserve.core.model.BaseModel;

/**
 * 用户
 * 
 * @author 
 * @version 1.0 2013-05-08
 */
public class Users extends BaseModel {

	/**
	 * 登录名
	 */
	protected String userLogin;
	
	/**
	 * @return 登录名
	 */
	public String getUserLogin() {
		return userLogin;
	}
	
	/**
	 * @param userLogin 登录名
	 */
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	
	/**
	 * 密码
	 */
	protected String userPwd;
	
	/**
	 * @return 密码
	 */
	public String getUserPwd() {
		return userPwd;
	}
	
	/**
	 * @param userPwd 密码
	 */
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	/**
	 * 昵称
	 */
	protected String userNicename;
	
	/**
	 * @return 昵称
	 */
	public String getUserNicename() {
		return userNicename;
	}
	
	/**
	 * @param userNicename 昵称
	 */
	public void setUserNicename(String userNicename) {
		this.userNicename = userNicename;
	}
	
	/**
	 * email
	 */
	protected String userEmail;
	
	/**
	 * @return email
	 */
	public String getUserEmail() {
		return userEmail;
	}
	
	/**
	 * @param userEmail email
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	/**
	 * 创建时间
	 */
	protected Date createTime;
	
	/**
	 * @return 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * @param createTime 创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * 用户状态
	 */
	protected String userStatus;
	
	/**
	 * @return 用户状态
	 */
	public String getUserStatus() {
		return userStatus;
	}
	
	/**
	 * @param userStatus 用户状态
	 */
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	
	/**
	 * 主页地址
	 */
	protected String userUrl;
	
	/**
	 * @return 主页地址
	 */
	public String getUserUrl() {
		return userUrl;
	}
	
	/**
	 * @param userUrl 主页地址
	 */
	public void setUserUrl(String userUrl) {
		this.userUrl = userUrl;
	}
	
}
