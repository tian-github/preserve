package com.preserve.core.model;

import java.io.Serializable;

import com.preserve.core.annotation.IDStrategy;
import com.preserve.core.annotation.Id;
import com.preserve.core.utils.GeneralSQLBuilder;

public class BaseModel implements Serializable {

	@Id(name = "fd_id", IDStrategy = IDStrategy.IN_CREMENT)
	private long fdId;

	public long getFdId() {
		return fdId;
	}

	public void setFdId(long fdId) {
		this.fdId = fdId;
	}

	public String getTableName() {

		return GeneralSQLBuilder.getTableName(this.getClass());

	}

}
