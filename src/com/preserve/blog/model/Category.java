package com.preserve.blog.model;

import java.util.Date;

import com.preserve.core.model.BaseModel;

/**
 * 分类
 * 
 * @author 
 * @version 1.0 2013-05-08
 */
public class Category extends BaseModel {

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
	 * 创建时间
	 */
	protected Date docCreateTime;
	
	/**
	 * @return 创建时间
	 */
	public Date getDocCreateTime() {
		return docCreateTime;
	}
	
	/**
	 * @param docCreateTime 创建时间
	 */
	public void setDocCreateTime(Date docCreateTime) {
		this.docCreateTime = docCreateTime;
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
	
}
