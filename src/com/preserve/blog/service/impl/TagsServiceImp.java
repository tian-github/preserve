package com.preserve.blog.service.impl;

import javax.annotation.Resource;

import org.apache.commons.dbutils.QueryRunner;

import com.preserve.blog.dao.ITagsDao;
import com.preserve.blog.model.Tags;
import com.preserve.blog.service.ITagsService;
import com.preserve.core.dao.IBaseDao;
import com.preserve.core.service.impl.BaseServiceImpl;

/**
 * 标签业务接口实现
 * 
 * @author 
 * @version 1.0 2013-05-08
 */
public class TagsServiceImp extends BaseServiceImpl<Tags> implements
		ITagsService {

	@Resource(name = "tagsDao")
	private ITagsDao tagsDao;

	@Resource(name = "queryRunner")
	private QueryRunner queryRunner;

	public QueryRunner getQueryRunner() {
		return queryRunner;
	}

	@Override
	public IBaseDao<Tags> getBaseDao() {
		// TODO Auto-generated method stub
		return tagsDao;
	}

	//	@Override
	//	public String getTableName() {
	//		// TODO Auto-generated method stub
	//		return "tags";
	//	}

}
