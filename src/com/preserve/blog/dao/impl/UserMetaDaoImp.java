package com.preserve.blog.dao.impl;

import javax.annotation.Resource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.preserve.blog.dao.IUserMetaDao;
import com.preserve.blog.model.UserMeta;
import com.preserve.core.dao.impl.BaseDaoImpl;

/**
 * 用户扩展表数据访问接口实现
 * 
 * @author 
 * @version 1.0 2013-05-08
 */
@Repository(value="userMetaDao")
public class UserMetaDaoImp extends BaseDaoImpl<UserMeta> implements IUserMetaDao {

	@Resource(name = "namedJdbcTemplate")
	private NamedParameterJdbcTemplate namedJdbc;
	
	@Override
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		// TODO Auto-generated method stub
		return namedJdbc;
	}

	@Override
	public Class<UserMeta> getModelClass() {
		// TODO Auto-generated method stub
		return UserMeta.class;
	}

}
