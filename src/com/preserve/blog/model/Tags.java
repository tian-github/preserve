package com.preserve.blog.model;

import java.sql.Types;

import com.preserve.core.annotation.Column;
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
	@Column(length=500)
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
	@Column(dataType=Types.INTEGER)
	protected long creatorId;

	public long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(long creatorId) {
		this.creatorId = creatorId;
	}
	
}
