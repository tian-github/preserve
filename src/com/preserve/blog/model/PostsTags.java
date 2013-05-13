package com.preserve.blog.model;

import java.sql.Types;

import com.preserve.core.annotation.Column;
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
	@Column(dataType = Types.INTEGER)
	protected long fdTagId;

	/**
	 * 博客id
	 */
	@Column(dataType = Types.INTEGER)
	protected long fdPostId;

	public long getFdTagId() {
		return fdTagId;
	}

	public void setFdTagId(long fdTagId) {
		this.fdTagId = fdTagId;
	}

	public long getFdPostId() {
		return fdPostId;
	}

	public void setFdPostId(long fdPostId) {
		this.fdPostId = fdPostId;
	}

}
