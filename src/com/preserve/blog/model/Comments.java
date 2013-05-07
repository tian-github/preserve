package com.preserve.blog.model;

import java.util.Date;

import com.preserve.core.model.BaseModel;

/**
 * 评论
 * 
 * @author 
 * @version 1.0 2013-05-08
 */
public class Comments extends BaseModel {

	/**
	 * 评论者
	 */
	protected String commentAuthor;
	
	/**
	 * @return 评论者
	 */
	public String getCommentAuthor() {
		return commentAuthor;
	}
	
	/**
	 * @param commentAuthor 评论者
	 */
	public void setCommentAuthor(String commentAuthor) {
		this.commentAuthor = commentAuthor;
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
	 * 评论内容
	 */
	protected String commentContent;
	
	/**
	 * @return 评论内容
	 */
	public String getCommentContent() {
		return commentContent;
	}
	
	/**
	 * @param commentContent 评论内容
	 */
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	
	/**
	 * 所属博客ID
	 */
	protected String fdPostId;
	
	/**
	 * @return 所属博客ID
	 */
	public String getFdPostId() {
		return fdPostId;
	}
	
	/**
	 * @param fdPostId 所属博客ID
	 */
	public void setFdPostId(String fdPostId) {
		this.fdPostId = fdPostId;
	}
	
}
