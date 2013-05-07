package com.preserve.core.model;

import java.io.Serializable;

import com.preserve.core.annotation.IDStrategy;
import com.preserve.core.annotation.Id;

public class BaseModel implements Serializable {

	@Id(name="fd_id",IDStrategy=IDStrategy.IN_CREMENT)
	private long fdId;

	public long getFdId() {
		return fdId;
	}

	public void setFdId(long fdId) {
		this.fdId = fdId;
	}
	
	
}
