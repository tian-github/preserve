package com.preserve.blog.service.impl;

import javax.annotation.Resource;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.stereotype.Service;

import com.preserve.blog.dao.ICategoryDao;
import com.preserve.blog.model.Category;
import com.preserve.blog.service.ICategoryService;
import com.preserve.core.dao.IBaseDao;
import com.preserve.core.service.impl.BaseServiceImpl;

/**
 * 分类业务接口实现
 * 
 * @author 
 * @version 1.0 2013-05-08
 */
@Service
public class CategoryServiceImp extends BaseServiceImpl<Category> implements
		ICategoryService {

	@Resource(name = "categoryDao")
	private ICategoryDao categoryDao;

	@Resource(name = "queryRunner")
	private QueryRunner queryRunner;

	@Override
	public IBaseDao<Category> getBaseDao() {
		// TODO Auto-generated method stub
		return categoryDao;
	}

	//	public String getTableName() {
	//		// TODO Auto-generated method stub
	//		return "category";
	//	}

	public QueryRunner getQueryRunner() {
		return queryRunner;
	}

}
