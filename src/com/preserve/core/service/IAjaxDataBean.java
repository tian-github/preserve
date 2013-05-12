package com.preserve.core.service;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;

public interface IAjaxDataBean {
	public JSON getDataJSON(HttpServletRequest request);
}
