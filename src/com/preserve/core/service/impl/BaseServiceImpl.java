package com.preserve.core.service.impl;

import javax.annotation.Resource;

import com.preserve.core.service.IBaseService;
import com.preserve.core.service.IDispatchService;

public abstract class BaseServiceImpl<M> implements IBaseService<M> {

	@Resource(name = "dispatchService")
	private IDispatchService dispatchService;

	public Object save(M model) throws Exception {
		Object object = getBaseDao().save(model);
		if (dispatchService != null)
			dispatchService.save(model);
		return object;
	}

	public Object update(M model) throws Exception {
		Object object = getBaseDao().update(model);
		if (dispatchService != null)
			dispatchService.update(model);
		return object;

	}

	public void delete(M model) throws Exception {
		getBaseDao().delete(model);
		if (dispatchService != null)
			dispatchService.delete(model);
	}

}
