package com.preserve.blog.model;

import java.sql.Timestamp;
import java.sql.Types;

import com.preserve.core.annotation.Column;
import com.preserve.core.model.BaseModel;

/**
 * 博文
 * 
 * @author 
 * @version 1.0 2013-05-08
 */
public class Posts extends BaseModel {

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
	 * 文章类型
	 */
	protected String postType;
	
	/**
	 * @return 文章类型
	 */
	public String getPostType() {
		return postType;
	}
	
	/**
	 * @param postType 文章类型
	 */
	public void setPostType(String postType) {
		this.postType = postType;
	}
	
	/**
	 * 发布时间
	 */
	@Column(dataType=Types.TIMESTAMP)
	protected Timestamp publishTime;
	
	
	/**
	 * 创建时间
	 */
	@Column(dataType=Types.TIMESTAMP)
	protected Timestamp createTime;
	
	
	/**
	 * 文档状态
	 */
	protected String status;
	
	/**
	 * @return 文档状态
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * @param status 文档状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * 博客内容
	 */
	@Column(dataType=Types.LONGNVARCHAR)
	protected String postContent;
	
	/**
	 * @return 博客内容
	 */
	public String getPostContent() {
		return postContent;
	}
	
	/**
	 * @param postContent 博客内容
	 */
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	
	/**
	 * 博客标题
	 */
	protected String postTitle;
	
	/**
	 * @return 博客标题
	 */
	public String getPostTitle() {
		return postTitle;
	}
	
	/**
	 * @param postTitle 博客标题
	 */
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	
	/**
	 * 摘要
	 */
	@Column(dataType=Types.LONGNVARCHAR)
	protected String postExcerpt;
	
	/**
	 * @return 摘要
	 */
	public String getPostExcerpt() {
		return postExcerpt;
	}
	
	/**
	 * @param postExcerpt 摘要
	 */
	public void setPostExcerpt(String postExcerpt) {
		this.postExcerpt = postExcerpt;
	}
	
	/**
	 * 允许评论
	 */
	protected String commentStatus;
	
	/**
	 * @return 允许评论
	 */
	public String getCommentStatus() {
		return commentStatus;
	}
	
	/**
	 * @param commentStatus 允许评论
	 */
	public void setCommentStatus(String commentStatus) {
		this.commentStatus = commentStatus;
	}
	
	/**
	 * 最后修改时间
	 */
	@Column(dataType=Types.TIMESTAMP)
	protected Timestamp alterTime;
	
	
	
	/**
	 * 作者
	 */
	@Column(dataType=Types.INTEGER)
	protected long authorId;
	
	
	
	/**
	 * 所属分类
	 */
	@Column(dataType=Types.INTEGER)
	protected long categoryId;

	public Timestamp getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getAlterTime() {
		return alterTime;
	}

	public void setAlterTime(Timestamp alterTime) {
		this.alterTime = alterTime;
	}

	public long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	
	
}
