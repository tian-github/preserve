package com.preserve.blog.model;

import java.sql.Timestamp;
import java.sql.Types;

import com.preserve.core.annotation.Column;
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
	 * 创建时间
	 */
	@Column(dataType=Types.TIMESTAMP)
	protected Timestamp createTime;
	

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
	 * 创建者
	 */
	@Column(dataType=Types.INTEGER)
	protected long creatorId;
	
	@Column(dataType=Types.INTEGER)
	protected long parentId;
	
}
