package com.preserve.core.service;

import com.preserve.core.dao.IBaseDao;

public interface IBaseService<M> {

	public Object save(M model) throws Exception;

	public Object update(M model) throws Exception;

	public void delete(M model) throws Exception;

	public IBaseDao<M> getBaseDao() throws Exception;
}
