package com.preserve.blog.model;

import java.util.Date;

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
	protected Date publishTime;
	
	/**
	 * @return 发布时间
	 */
	public Date getPublishTime() {
		return publishTime;
	}
	
	/**
	 * @param publishTime 发布时间
	 */
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
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
	protected Date alterTime;
	
	/**
	 * @return 最后修改时间
	 */
	public Date getAlterTime() {
		return alterTime;
	}
	
	/**
	 * @param alterTime 最后修改时间
	 */
	public void setAlterTime(Date alterTime) {
		this.alterTime = alterTime;
	}
	
	/**
	 * 作者
	 */
	protected Users docAuthor;
	
	/**
	 * @return 作者
	 */
	public Users getDocAuthor() {
		return docAuthor;
	}
	
	/**
	 * @param docAuthor 作者
	 */
	public void setDocAuthor(Users docAuthor) {
		this.docAuthor = docAuthor;
	}
	
	/**
	 * 所属分类
	 */
	protected Category docCategory;
	
	/**
	 * @return 所属分类
	 */
	public Category getDocCategory() {
		return docCategory;
	}
	
	/**
	 * @param docCategory 所属分类
	 */
	public void setDocCategory(Category docCategory) {
		this.docCategory = docCategory;
	}
}
