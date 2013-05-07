package com.preserve.blog.dao.impl;

import javax.annotation.Resource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.preserve.blog.dao.IPostsMetaDao;
import com.preserve.blog.model.PostsMeta;
import com.preserve.core.dao.impl.BaseDaoImpl;

/**
 * 博文扩展表数据访问接口实现
 * 
 * @author 
 * @version 1.0 2013-05-08
 */
@Repository(value="postsMetaDao")
public class PostsMetaDaoImp extends BaseDaoImpl<PostsMeta> implements IPostsMetaDao {

	@Resource(name = "namedJdbcTemplate")
	private NamedParameterJdbcTemplate namedJdbc;
	
	@Override
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		// TODO Auto-generated method stub
		return namedJdbc;
	}

	@Override
	public Class<PostsMeta> getModelClass() {
		// TODO Auto-generated method stub
		return PostsMeta.class;
	}

}
