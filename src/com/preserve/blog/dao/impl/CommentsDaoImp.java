package com.preserve.blog.dao.impl;

import javax.annotation.Resource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.preserve.blog.dao.ICommentsDao;
import com.preserve.blog.model.Comments;
import com.preserve.core.dao.impl.BaseDaoImpl;

/**
 * 评论数据访问接口实现
 * 
 * @author 
 * @version 1.0 2013-05-08
 */
@Repository(value="commentsDao")
public class CommentsDaoImp extends BaseDaoImpl<Comments> implements ICommentsDao {

	@Resource(name = "namedJdbcTemplate")
	private NamedParameterJdbcTemplate namedJdbc;
	
	@Override
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		// TODO Auto-generated method stub
		return namedJdbc;
	}

	@Override
	public Class<Comments> getModelClass() {
		// TODO Auto-generated method stub
		return Comments.class;
	}

}
