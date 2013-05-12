package com.preserve.test.web;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.preserve.test.model.User;
import com.preserve.test.service.impl.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource UserService userService;
	
	@RequestMapping(value="create",method = RequestMethod.POST)
	public String create(User u) throws Exception {
//		add
		userService.save(u);
		return "user/login";
	}
	
	@RequestMapping(value="login",method = RequestMethod.POST)
	public String login(User u) {
		if(userService.login(u)){
			return "index";
		}
		return "user/login";
	}
	
	@RequestMapping(value="register")
	public String register() {
		
		return "user/create";
	}
	
	@RequestMapping(value="signin")
	public String signin() {
		
		return "user/login";
	}

}
