package com.preserve.blog.model;

import com.preserve.core.model.BaseModel;

/**
 * 超链接
 * 
 * @author 
 * @version 1.0 2013-05-08
 */
public class Link extends BaseModel {

	/**
	 * 排序号
	 */
	protected Integer orderNum;
	
	/**
	 * @return 排序号
	 */
	public Integer getOrderNum() {
		return orderNum;
	}
	
	/**
	 * @param orderNum 排序号
	 */
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	
	/**
	 * 链接URL
	 */
	protected String linkUrl;
	
	/**
	 * @return 链接URL
	 */
	public String getLinkUrl() {
		return linkUrl;
	}
	
	/**
	 * @param linkUrl 链接URL
	 */
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	
	/**
	 * 链接名称
	 */
	protected String linkName;
	
	/**
	 * @return 链接名称
	 */
	public String getLinkName() {
		return linkName;
	}
	
	/**
	 * @param linkName 链接名称
	 */
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	
	/**
	 * 链接图标
	 */
	protected String linkImage;
	
	/**
	 * @return 链接图标
	 */
	public String getLinkImage() {
		return linkImage;
	}
	
	/**
	 * @param linkImage 链接图标
	 */
	public void setLinkImage(String linkImage) {
		this.linkImage = linkImage;
	}
	
	/**
	 * 链接描述
	 */
	protected String linkDescription;
	
	/**
	 * @return 链接描述
	 */
	public String getLinkDescription() {
		return linkDescription;
	}
	
	/**
	 * @param linkDescription 链接描述
	 */
	public void setLinkDescription(String linkDescription) {
		this.linkDescription = linkDescription;
	}
	
	/**
	 * 创建者
	 */
	protected Users docCreator;
	
	/**
	 * @return 创建者
	 */
	public Users getDocCreator() {
		return docCreator;
	}
	
	/**
	 * @param docCreator 创建者
	 */
	public void setDocCreator(Users docCreator) {
		this.docCreator = docCreator;
	}
	
}
