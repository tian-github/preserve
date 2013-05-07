package com.preserve.test.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.preserve.core.service.impl.BaseServieImpl;
import com.preserve.test.dao.IUserDao;
import com.preserve.test.model.User;
import com.preserve.test.service.IUserService;

@Service(value="userService")
public class UserService extends BaseServieImpl<User> implements IUserService {
	
	@Resource(name="userDao")
	private IUserDao userDao ;
	
	public void save(User u){
		userDao.save(u);
	}
	
	public boolean login(User u){
		if(u==null){
			return false;
		}
		String sql="select * from user where name=:name and pwd=:pwd ";
		Map<String, Object> params =new HashMap<String, Object>();
		params.put("name", u.getName());
		params.put("pwd", u.getPwd());
		
		List<User> users= userDao.find(sql, params);
		if(users!=null&&!users.isEmpty())
		{
			return true;
		}
		return false;
	}




}
