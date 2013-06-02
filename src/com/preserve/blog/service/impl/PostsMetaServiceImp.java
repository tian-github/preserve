package com.preserve.blog.service.impl;

import javax.annotation.Resource;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.stereotype.Service;

import com.preserve.blog.dao.IPostsMetaDao;
import com.preserve.blog.model.PostsMeta;
import com.preserve.blog.service.IPostsMetaService;
import com.preserve.core.dao.IBaseDao;
import com.preserve.core.service.impl.BaseServiceImpl;

/**
 * 博文扩展表业务接口实现
 * 
 * @author 
 * @version 1.0 2013-05-08
 */
@Service(value = "postsMetaService")
public class PostsMetaServiceImp extends BaseServiceImpl<PostsMeta> implements
		IPostsMetaService {

	@Resource(name = "postsMetaDao")
	private IPostsMetaDao postsMetaDao;

	@Resource(name = "queryRunner")
	private QueryRunner queryRunner;

	public QueryRunner getQueryRunner() {
		return queryRunner;
	}

	@Override
	public IBaseDao<PostsMeta> getBaseDao() {
		// TODO Auto-generated method stub
		return postsMetaDao;
	}

	//	@Override
	//	public String getTableName() {
	//		// TODO Auto-generated method stub
	//		return "posts_meta";
	//	}

}
