package com.preserve.blog.dao.impl;

import javax.annotation.Resource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.preserve.blog.dao.ITagsDao;
import com.preserve.blog.model.Tags;
import com.preserve.core.dao.impl.BaseDaoImpl;

/**
 * 标签数据访问接口实现
 * 
 * @author 
 * @version 1.0 2013-05-08
 */
@Repository(value="tagsDao")
public class TagsDaoImp extends BaseDaoImpl<Tags>  implements ITagsDao {

	@Resource(name = "namedJdbcTemplate")
	private NamedParameterJdbcTemplate namedJdbc;
	
	@Override
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		// TODO Auto-generated method stub
		return namedJdbc;
	}

	@Override
	public Class<Tags> getModelClass() {
		// TODO Auto-generated method stub
		return Tags.class;
	}

}
