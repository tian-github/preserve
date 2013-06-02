package com.preserve.blog.service;

import java.util.List;

import com.preserve.blog.model.Users;
import com.preserve.core.service.IBaseService;

/**
 * 用户业务对象接口
 * 
 * @author 
 * @version 1.0 2013-05-08
 */
public interface IUsersService extends IBaseService<Users> {

	public List<Users> getAll() throws Exception;

}
