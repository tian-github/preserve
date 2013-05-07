package com.preserve.blog.model;

import com.preserve.core.model.BaseModel;

/**
 * 标签
 * 
 * @author 
 * @version 1.0 2013-05-08
 */
public class Tags extends BaseModel {

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
	 * 名称
	 */
	protected String name;
	
	/**
	 * @return 名称
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name 名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 标签图标
	 */
	protected String tagImg;
	
	/**
	 * @return 标签图标
	 */
	public String getTagImg() {
		return tagImg;
	}
	
	/**
	 * @param tagImg 标签图标
	 */
	public void setTagImg(String tagImg) {
		this.tagImg = tagImg;
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
