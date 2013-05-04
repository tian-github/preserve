package com.preserve.core.dao.impl;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.preserve.core.dao.IBaseDao;

public abstract class BaseDaoImpl<M> implements IBaseDao<M> {
	
	public abstract Class<M> getModelClass();
	
	public abstract String getInsertSQL();
	
	public abstract String getUpdateSQL();
	
	public abstract String getDeleteSQL();
	
	public Object save(M model) {
		
		String inserSql=getInsertSQL();
        KeyHolder keyHolder = new GeneratedKeyHolder();
        getNamedParameterJdbcTemplate().update(inserSql, new BeanPropertySqlParameterSource(model), keyHolder);
        return keyHolder.getKey();
	
	}
	
	public Object update(M model) {
		
		String updateSql=getUpdateSQL();
        KeyHolder keyHolder = new GeneratedKeyHolder();
        getNamedParameterJdbcTemplate().update(updateSql, new BeanPropertySqlParameterSource(model), keyHolder);
        return keyHolder.getKey();
	
	}
	
	public void delete(Object id){
		
	}

	
}
