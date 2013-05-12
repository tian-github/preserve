package com.preserve.core.utils.spring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component(value = "springBeanUtil")
public class SpringBeanUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext = null;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = applicationContext;
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

	/**
	 * 获取实现某接口且排除特定bean的集合
	 * 
	 * @param type
	 * @param exceptBeanName
	 * @return
	 */
	public static List getBeansForType(Class type, String exceptBeanName) {
		if (applicationContext == null)
			return null;
		String[] beanNameArr = applicationContext.getBeanNamesForType(type);
		List beanNameList = Arrays.asList(beanNameArr);
		List beanList = new ArrayList();
		for (int i = 0; i < beanNameArr.length; i++) {
			if (beanNameArr[i].equals(exceptBeanName))
				continue;
			beanList.add(applicationContext.getBean(beanNameArr[i]));
		}
		return beanList;
	}

}
