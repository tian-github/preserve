package com.preserve.core.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.preserve.core.service.IAjaxDataBean;
import com.preserve.core.utils.spring.SpringBeanUtil;

/**
 * 异步请求控制器
 * 
 * @author zqhung
 * 
 */
@Controller
@RequestMapping(value="ajax")
public class AjaxController {
	
	@RequestMapping(value="portlet",method=RequestMethod.POST)
	public String portlet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.setContentType("application/jsonp");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		try {
			JSON json = null;
			String beanName = request.getParameter("p_bean");
			if (!StringUtils.isEmpty(beanName)) {
				Object beanObj = SpringBeanUtil.getBean(beanName);
				Assert.isTrue(beanObj instanceof IAjaxDataBean,
						beanObj.getClass() + "未实现接口：IAjaxDataBean");
				IAjaxDataBean bean = (IAjaxDataBean) beanObj;
				json = bean.getDataJSON(request);
				if (json != null) {
					out.println(json.toString());
				}
			}
		} catch (Exception e) {
			response.sendError(505);
			e.printStackTrace();
		}
		return null;
	}
}
