package com.preserve.blog.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.preserve.blog.dao.IPostsDao;
import com.preserve.blog.model.Posts;
import com.preserve.blog.service.IPostsService;
import com.preserve.core.dao.IBaseDao;
import com.preserve.core.service.impl.BaseServiceImpl;

/**
 * 博文业务接口实现
 * 
 * @author 
 * @version 1.0 2013-05-08
 */
@Service(value="postsService")
public class PostsServiceImp extends BaseServiceImpl<Posts> implements IPostsService {

	@Resource(name="postsDao")
	private IPostsDao postsDao;
	
	@Override
	public IBaseDao<Posts> getBaseDao() {
		// TODO Auto-generated method stub
		return postsDao;
	}

}
