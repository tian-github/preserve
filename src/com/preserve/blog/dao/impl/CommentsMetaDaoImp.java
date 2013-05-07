package com.preserve.blog.dao.impl;

import javax.annotation.Resource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.preserve.blog.dao.ICommentsMetaDao;
import com.preserve.blog.model.CommentsMeta;
import com.preserve.core.dao.impl.BaseDaoImpl;

/**
 * 评论扩展表数据访问接口实现
 * 
 * @author 
 * @version 1.0 2013-05-08
 */
@Repository(value="commentsMetaDao")
public class CommentsMetaDaoImp extends BaseDaoImpl<CommentsMeta> implements ICommentsMetaDao {

	@Resource(name = "namedJdbcTemplate")
	private NamedParameterJdbcTemplate namedJdbc;
	
	@Override
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		// TODO Auto-generated method stub
		return namedJdbc;
	}

	@Override
	public Class<CommentsMeta> getModelClass() {
		// TODO Auto-generated method stub
		return CommentsMeta.class;
	}

}
