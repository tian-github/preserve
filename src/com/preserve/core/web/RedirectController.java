package com.preserve.core.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/redirect")
public class RedirectController {

	@RequestMapping(value = "jsp")
	public String redirect(HttpServletRequest request) {
		return request.getParameter("p_jsp");
	}
}
