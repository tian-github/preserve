package com.preserve.core.service;

import java.util.List;

import com.preserve.core.dao.IBaseDao;
import com.preserve.core.model.BaseModel;

public interface IBaseService<M extends BaseModel> {

	public Object save(M model) throws Exception;

	public Object update(M model) throws Exception;

	public void delete(M model) throws Exception;

	public IBaseDao<M> getBaseDao() throws Exception;

	public int getCount(String sql, Object... params) throws Exception;

	public String getTableName() throws Exception;

	public List<M> getAll() throws Exception;

}
