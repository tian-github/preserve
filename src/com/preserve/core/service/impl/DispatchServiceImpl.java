package com.preserve.core.service.impl;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.preserve.core.service.IDispatchService;
import com.preserve.core.utils.spring.SpringBeanUtil;

/**
 * 通用service分发器
 * 
 */
@Component(value = "dispatchService")
public class DispatchServiceImpl implements IDispatchService,
		ApplicationContextAware {

	private List<IDispatchService> disService;

	@Override
	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		this.setDisService();
	}

	private void init() {
		disService = SpringBeanUtil.getBeansForType(IDispatchService.class,
				"disPatchService");
		if (disService != null)
			System.out.println(disService.size());
	}

	public List<IDispatchService> getDisService() {
		return disService;
	}

	public void setDisService() {
		if (disService == null)
			this.init();
	}

	@Override
	public void save(Object model) throws Exception {
		List<IDispatchService> list = getDisService();
		for (IDispatchService service : list) {
			service.save(model);
		}
	}

	@Override
	public void update(Object model) throws Exception {
		List<IDispatchService> list = getDisService();
		for (IDispatchService service : list) {
			service.update(model);
		}
	}

	@Override
	public void delete(Object model) throws Exception {
		List<IDispatchService> list = getDisService();
		for (IDispatchService service : list) {
			service.delete(model);
		}
	}
}
