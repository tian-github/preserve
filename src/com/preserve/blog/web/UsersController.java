package com.preserve.blog.web;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.preserve.blog.service.IUsersService;

@Controller
@RequestMapping(value = "/u")
public class UsersController {

	@Resource(name = "usersService")
	private IUsersService userService;

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		return "";
	}

	@RequestMapping(value = "view")
	public String view(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		return "";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		return "";
	}

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		System.out.println("");
		return "user/index";
	}

}
