package com.preserve.blog.service.impl;

import javax.annotation.Resource;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.stereotype.Service;

import com.preserve.blog.dao.IUserMetaDao;
import com.preserve.blog.model.UserMeta;
import com.preserve.blog.service.IUserMetaService;
import com.preserve.core.dao.IBaseDao;
import com.preserve.core.service.impl.BaseServiceImpl;

/**
 * 用户扩展表业务接口实现
 * 
 * @author 
 * @version 1.0 2013-05-08
 */
@Service(value = "userMetaService")
public class UserMetaServiceImp extends BaseServiceImpl<UserMeta> implements
		IUserMetaService {

	@Resource(name = "userMetaDao")
	private IUserMetaDao userMetaDao;

	@Resource(name = "queryRunner")
	private QueryRunner queryRunner;

	public QueryRunner getQueryRunner() {
		return queryRunner;
	}

	@Override
	public IBaseDao<UserMeta> getBaseDao() {
		// TODO Auto-generated method stub
		return userMetaDao;
	}

	//	@Override
	//	public String getTableName() {
	//		// TODO Auto-generated method stub
	//		return "user_meta";
	//	}

}
