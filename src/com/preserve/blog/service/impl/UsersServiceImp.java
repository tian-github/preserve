package com.preserve.blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.stereotype.Service;

import com.preserve.blog.dao.IUsersDao;
import com.preserve.blog.model.Users;
import com.preserve.blog.service.IUsersService;
import com.preserve.core.dao.IBaseDao;
import com.preserve.core.service.impl.BaseServiceImpl;

/**
 * 用户业务接口实现
 * 
 * @author
 * @version 1.0 2013-05-08
 */
@Service(value = "usersService")
public class UsersServiceImp extends BaseServiceImpl<Users> implements
		IUsersService {

	@Resource(name = "usersDao")
	private IUsersDao usersDao;

	@Resource(name = "queryRunner")
	private QueryRunner queryRunner;

	@Override
	public IBaseDao<Users> getBaseDao() {
		// TODO Auto-generated method stub
		return usersDao;
	}

	//	@Override
	//	public List<Users> getAll() throws Exception {
	//		// TODO Auto-generated method stub
	////		BeanListHandler<T>
	////		ResultSetHandler<T>
	//		
	//		
	//		queryRunner.query(sql, rsh)
	//		return null;
	//	}

	//	@Override
	//	public String getTableName() {
	//		// TODO Auto-generated method stub
	//		return "users";
	//	}

	@Override
	public List<Users> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public QueryRunner getQueryRunner() {
		return queryRunner;
	}

}
