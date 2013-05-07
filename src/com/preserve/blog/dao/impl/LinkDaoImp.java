package com.preserve.blog.dao.impl;

import javax.annotation.Resource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.preserve.blog.dao.ILinkDao;
import com.preserve.blog.model.Link;
import com.preserve.core.dao.impl.BaseDaoImpl;

/**
 * 超链接数据访问接口实现
 * 
 * @author 
 * @version 1.0 2013-05-08
 */
@Repository(value="linkDao")
public class LinkDaoImp extends BaseDaoImpl<Link> implements ILinkDao {

	@Resource(name = "namedJdbcTemplate")
	private NamedParameterJdbcTemplate namedJdbc;
	
	@Override
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		// TODO Auto-generated method stub
		return namedJdbc;
	}

	@Override
	public Class<Link> getModelClass() {
		// TODO Auto-generated method stub
		return Link.class;
	}

}
