package com.preserve.blog.dao.impl;

import javax.annotation.Resource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.preserve.blog.dao.ICategoryDao;
import com.preserve.blog.model.Category;
import com.preserve.core.dao.impl.BaseDaoImpl;

/**
 * 分类数据访问接口实现
 * 
 * @author 
 * @version 1.0 2013-05-08
 */
@Repository(value="categoryDao")
public class CategoryDaoImp extends BaseDaoImpl<Category> implements ICategoryDao {

	@Resource(name = "namedJdbcTemplate")
	private NamedParameterJdbcTemplate namedJdbc;
	
	@Override
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		// TODO Auto-generated method stub
		return namedJdbc;
	}

	@Override
	public Class<Category> getModelClass() {
		// TODO Auto-generated method stub
		return Category.class;
	}


}
