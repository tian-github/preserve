package com.preserve.core.service.impl;

import com.preserve.core.service.IBaseService;

public abstract class BaseServiceImpl<M> implements IBaseService<M> {

	public Object save(M model) {
		return getBaseDao().save(model);
	}
	public Object update(M model) {
		return getBaseDao().update(model);

	}
	public void delete(M model) {
		getBaseDao().delete(model);
	}

}
