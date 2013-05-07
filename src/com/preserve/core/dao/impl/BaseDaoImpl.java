package com.preserve.core.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.preserve.core.annotation.Table;
import com.preserve.core.dao.IBaseDao;
import com.preserve.core.utils.GeneralSQLBuilder;
import com.preserve.core.vo.ModelInfo;

public abstract class BaseDaoImpl<M> implements IBaseDao<M> {
	
	public abstract Class<M> getModelClass();
	
	public Object save(M model) {
		
		String inserSql=GeneralSQLBuilder.getInsertSQL(model.getClass());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        getNamedParameterJdbcTemplate().update(inserSql, new BeanPropertySqlParameterSource(model), keyHolder);
        return keyHolder.getKey();
	
	}
	
	public Object update(M model) {
		
		String updateSql=GeneralSQLBuilder.getUpdateSQL(model.getClass());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        getNamedParameterJdbcTemplate().update(updateSql, new BeanPropertySqlParameterSource(model), keyHolder);
        return keyHolder.getKey();
	
	}
	
	public void delete(M model){
		String deleteSql=GeneralSQLBuilder.getDeleteSQL(model.getClass());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        getNamedParameterJdbcTemplate().update(deleteSql, new BeanPropertySqlParameterSource(model), keyHolder);
	}
	

	
}
