package com.preserve.blog.service.impl;

import javax.annotation.Resource;

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

	@Override
	public IBaseDao<Users> getBaseDao() {
		// TODO Auto-generated method stub
		return usersDao;
	}

}
