package com.preserve.blog.model;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Date;

import com.preserve.core.annotation.Column;
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
	@Column(dataType=Types.TIMESTAMP)
	protected Timestamp createTime;
	
	/**
	 * 评论内容
	 */
	@Column(dataType=Types.LONGNVARCHAR)
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
	@Column(dataType=Types.INTEGER)
	protected long fdPostId;

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public long getFdPostId() {
		return fdPostId;
	}

	public void setFdPostId(long fdPostId) {
		this.fdPostId = fdPostId;
	}
	

	
}
