package com.preserve.blog.model;

import com.preserve.core.model.BaseModel;

/**
 * 标签博文
 * 
 * @author 
 * @version 1.0 2013-05-08
 */
public class PostsTags extends BaseModel {

	/**
	 * 标签id
	 */
	protected Tags fdTag;
	
	/**
	 * @return 标签id
	 */
	public Tags getFdTag() {
		return fdTag;
	}
	
	/**
	 * @param fdTag 标签id
	 */
	public void setFdTag(Tags fdTag) {
		this.fdTag = fdTag;
	}
	
	/**
	 * 博客id
	 */
	protected Posts fdPost;
	
	/**
	 * @return 博客id
	 */
	public Posts getFdPost() {
		return fdPost;
	}
	
	/**
	 * @param fdPost 博客id
	 */
	public void setFdPost(Posts fdPost) {
		this.fdPost = fdPost;
	}
	
}
