package com.preserve.blog.service.impl;

import javax.annotation.Resource;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.stereotype.Service;

import com.preserve.blog.dao.ICommentsMetaDao;
import com.preserve.blog.model.CommentsMeta;
import com.preserve.blog.service.ICommentsMetaService;
import com.preserve.core.dao.IBaseDao;
import com.preserve.core.service.impl.BaseServiceImpl;

/**
 * 评论扩展表业务接口实现
 * 
 * @author 
 * @version 1.0 2013-05-08
 */
@Service(value = "commentsMetaService")
public class CommentsMetaServiceImp extends BaseServiceImpl<CommentsMeta>
		implements ICommentsMetaService {

	@Resource(name = "commentsMetaDao")
	private ICommentsMetaDao commentsMetaDao;

	@Resource(name = "queryRunner")
	private QueryRunner queryRunner;

	public QueryRunner getQueryRunner() {
		return queryRunner;
	}

	@Override
	public IBaseDao<CommentsMeta> getBaseDao() {
		// TODO Auto-generated method stub
		return commentsMetaDao;
	}

	//	@Override
	//	public String getTableName() {
	//		// TODO Auto-generated method stub
	//		return "comments_meta";
	//	}

}
