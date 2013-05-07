package com.preserve.test.dao;

import java.util.List;
import java.util.Map;

import com.preserve.core.dao.IBaseDao;
import com.preserve.test.model.User;

public interface IUserDao extends IBaseDao<User> {
	public List<User> find(String sql,Map<String,Object> params);
}
