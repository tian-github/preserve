package com.preserve.test.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.preserve.test.model.User;

@Repository
public class UserDao {

	@Resource(name = "namedJdbcTemplate")
	private NamedParameterJdbcTemplate namedJdbc;

	public Object save(User user) {

		String sql = "insert into user(name,pwd) values(:name,:pwd)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		namedJdbc.update(sql, new BeanPropertySqlParameterSource(user),
				keyHolder);
		return keyHolder.getKey();
	}

	public Object update(User user) {
		String sql = "";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		namedJdbc.update(sql, new BeanPropertySqlParameterSource(user),
				keyHolder);
		return keyHolder.getKey();
	}
	
	public int delete(Object id ){
		
		String sql = "delete from user where id=:id ";
		Map hashMap=new HashMap<String, Object>(1);
		hashMap.put("id", id);
		return namedJdbc.update(sql, hashMap);
		
	}
	
	public List<User> find(String sql,Map<String,Object> params){
		
		List<User> list = namedJdbc.query(sql, params,new BeanPropertyRowMapper<User>(User.class));
		
		return list;
	}
	

}
