package com.preserve.blog.service.impl;

import javax.annotation.Resource;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.stereotype.Service;

import com.preserve.blog.dao.ICommentsDao;
import com.preserve.blog.model.Comments;
import com.preserve.blog.service.ICommentsService;
import com.preserve.core.dao.IBaseDao;
import com.preserve.core.service.impl.BaseServiceImpl;

/**
 * 评论业务接口实现
 * 
 * @author 
 * @version 1.0 2013-05-08
 */
@Service(value = "commentsService")
public class CommentsServiceImp extends BaseServiceImpl<Comments> implements
		ICommentsService {

	@Resource(name = "commentsDao")
	private ICommentsDao commentsDao;

	@Resource(name = "queryRunner")
	private QueryRunner queryRunner;

	public QueryRunner getQueryRunner() {
		return queryRunner;
	}

	@Override
	public IBaseDao<Comments> getBaseDao() {
		// TODO Auto-generated method stub
		return commentsDao;
	}

	//	@Override
	//	public String getTableName() {
	//		// TODO Auto-generated method stub
	//		return "comments";
	//	}

}
