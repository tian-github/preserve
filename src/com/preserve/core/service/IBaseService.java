package com.preserve.core.service;

import com.preserve.core.dao.IBaseDao;

public interface IBaseService<M> {
	
	public Object save(M model);
	
	public Object update(M model);
	
	public void delete(M model);
	
	public IBaseDao<M> getBaseDao();
}
