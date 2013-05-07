package com.preserve.test.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.preserve.core.dao.impl.BaseDaoImpl;
import com.preserve.test.dao.IUserDao;
import com.preserve.test.model.User;

@Repository(value="userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {

	@Resource(name = "namedJdbcTemplate")
	private NamedParameterJdbcTemplate namedJdbc;

	public int delete(Object id ){
		
		String sql = "delete from user where id=:id ";
		Map<String, Object> hashMap=new HashMap<String, Object>(1);
		hashMap.put("id", id);
		return namedJdbc.update(sql, hashMap);
		
	}
	
	public List<User> find(String sql,Map<String,Object> params){
		
		List<User> list = namedJdbc.query(sql, params,new BeanPropertyRowMapper<User>(User.class));
		
		return list;
	}


	@Override
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		// TODO Auto-generated method stub
		return namedJdbc;
	}

	@Override
	public Class<User> getModelClass() {
		return User.class;
	}

}
