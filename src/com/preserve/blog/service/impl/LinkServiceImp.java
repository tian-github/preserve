package com.preserve.blog.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.preserve.blog.dao.ILinkDao;
import com.preserve.blog.model.Link;
import com.preserve.blog.service.ILinkService;
import com.preserve.core.dao.IBaseDao;
import com.preserve.core.service.impl.BaseServiceImpl;

/**
 * 超链接业务接口实现
 * 
 * @author 
 * @version 1.0 2013-05-08
 */
@Service(value="linkService")
public class LinkServiceImp extends BaseServiceImpl<Link> implements ILinkService {

	@Resource(name="linkDao")
	private ILinkDao linkDao;
	
	
	@Override
	public IBaseDao<Link> getBaseDao() {
		// TODO Auto-generated method stub
		return linkDao;
	}

}
