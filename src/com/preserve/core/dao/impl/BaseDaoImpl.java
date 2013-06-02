package com.preserve.core.dao.impl;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.preserve.core.dao.IBaseDao;
import com.preserve.core.utils.GeneralSQLBuilder;

public abstract class BaseDaoImpl<M> implements IBaseDao<M> {

	public Object save(M model) {

		String inserSql = GeneralSQLBuilder.getInsertSQL(model.getClass());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getNamedParameterJdbcTemplate().update(inserSql,
				new BeanPropertySqlParameterSource(model), keyHolder);
		return keyHolder.getKey();

	}

	public Object update(M model) {

		String updateSql = GeneralSQLBuilder.getUpdateSQL(model.getClass());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getNamedParameterJdbcTemplate().update(updateSql,
				new BeanPropertySqlParameterSource(model), keyHolder);
		return keyHolder.getKey();

	}

	public void delete(M model) {
		String deleteSql = GeneralSQLBuilder.getDeleteSQL(model.getClass());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getNamedParameterJdbcTemplate().update(deleteSql,
				new BeanPropertySqlParameterSource(model), keyHolder);
	}

}
