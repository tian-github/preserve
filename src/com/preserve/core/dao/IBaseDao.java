package com.preserve.core.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public interface IBaseDao<M> {

	public Object save(M model);
	
	public Object update(M model);
	
	public void delete(M model);
	
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate();
}
