package com.preserve.blog.model;

import java.sql.Types;

import com.preserve.core.annotation.Column;
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
	@Column(dataType=Types.INTEGER)
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
	@Column(length=500)
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
	@Column(length=500)
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
	@Column(length=500)
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
	@Column(dataType=Types.INTEGER)
	protected long linkCreator;

	public long getLinkCreator() {
		return linkCreator;
	}

	public void setLinkCreator(long linkCreator) {
		this.linkCreator = linkCreator;
	}

}
