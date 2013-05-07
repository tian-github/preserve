package com.preserve.blog.dao.impl;

import javax.annotation.Resource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.preserve.blog.dao.IPostsDao;
import com.preserve.blog.model.Posts;
import com.preserve.core.dao.impl.BaseDaoImpl;

/**
 * 博文数据访问接口实现
 * 
 * @author 
 * @version 1.0 2013-05-08
 */
@Repository(value="postsDao")
public class PostsDaoImp extends BaseDaoImpl<Posts> implements IPostsDao {

	@Resource(name = "namedJdbcTemplate")
	private NamedParameterJdbcTemplate namedJdbc;
	
	@Override
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		// TODO Auto-generated method stub
		return namedJdbc;
	}

	@Override
	public Class<Posts> getModelClass() {
		// TODO Auto-generated method stub
		return Posts.class;
	}

}
