package com.preserve.test.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.preserve.core.interfaces.IAjaxDataBean;

@Service(value = "testService")
public class TestService implements IAjaxDataBean {

	@Override
	public JSON getDataJSON(HttpServletRequest request) {
		JSONArray jsonArray = new JSONArray();
		String type = request.getParameter("type");
		if("1".equals(type)){
			for (int i = 0; i < 100; i++) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("name", "hongzq" + i);
				jsonArray.add(jsonObject);
			}
			//json.put("key", "dataSource1");
		}
		if("2".equals(type)){
			for (int i = 0; i < 100; i++) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("name", "zhangtian" + i);
				jsonArray.add(jsonObject);
			}
			//json.put("key", "dataSource2");
		}
		return jsonArray;
	}
}
