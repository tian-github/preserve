package com.preserve.blog.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.preserve.blog.dao.IPostsTagsDao;
import com.preserve.blog.model.PostsTags;
import com.preserve.blog.service.IPostsTagsService;
import com.preserve.core.dao.IBaseDao;
import com.preserve.core.service.impl.BaseServiceImpl;

/**
 * 标签博文业务接口实现
 * 
 * @author 
 * @version 1.0 2013-05-08
 */
@Service(value="postsTagsService")
public class PostsTagsServiceImp extends BaseServiceImpl<PostsTags> implements IPostsTagsService {

	@Resource(name="postsTagsDao")
	private IPostsTagsDao postsTagsDao;
	
	@Override
	public IBaseDao<PostsTags> getBaseDao() {
		// TODO Auto-generated method stub
		return postsTagsDao;
	}

}
