package com.preserve.blog.dao.impl;

import javax.annotation.Resource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.preserve.blog.dao.IUsersDao;
import com.preserve.blog.model.Users;
import com.preserve.core.dao.impl.BaseDaoImpl;

/**
 * 用户数据访问接口实现
 * 
 * @author 
 * @version 1.0 2013-05-08
 */
@Repository(value="usersDao")
public class UsersDaoImp extends BaseDaoImpl<Users> implements IUsersDao {

	@Resource(name = "namedJdbcTemplate")
	private NamedParameterJdbcTemplate namedJdbc;
	
	@Override
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		// TODO Auto-generated method stub
		return namedJdbc;
	}

	@Override
	public Class<Users> getModelClass() {
		// TODO Auto-generated method stub
		return Users.class;
	}



}
