package com.preserve.blog.dao.impl;

import javax.annotation.Resource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.preserve.blog.dao.IPostsTagsDao;
import com.preserve.blog.model.PostsTags;
import com.preserve.core.dao.impl.BaseDaoImpl;

/**
 * 标签博文数据访问接口实现
 * 
 * @author 
 * @version 1.0 2013-05-08
 */
@Repository(value="postsTagsDao")
public class PostsTagsDaoImp extends  BaseDaoImpl<PostsTags> implements IPostsTagsDao {

	@Resource(name = "namedJdbcTemplate")
	private NamedParameterJdbcTemplate namedJdbc;
	
	@Override
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		// TODO Auto-generated method stub
		return namedJdbc;
	}

	@Override
	public Class<PostsTags> getModelClass() {
		// TODO Auto-generated method stub
		return PostsTags.class;
	}


}
