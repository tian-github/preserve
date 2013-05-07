package com.preserve.core.utils.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component(value="springBeanUtil")
public class SpringBeanUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext = null;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext=applicationContext;
	}
	
	/**
	 * 判断是否SpringBeanUtil是否已经初时化
	 * 
	 * @return
	 */
	public static boolean isInit() {
		return applicationContext != null;
	}
	
	/**
	 * 根据名称获取spring的bean
	 * 
	 * @param beanName
	 * @return
	 */
	public static Object getBean(String beanName) {
		if (applicationContext == null)
			return null;
		return applicationContext.getBean(beanName);
	}

	
	
	
}
