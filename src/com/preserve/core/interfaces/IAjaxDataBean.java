package com.preserve.core.interfaces;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;

public interface IAjaxDataBean {
	public JSON getDataJSON(HttpServletRequest request);
}
