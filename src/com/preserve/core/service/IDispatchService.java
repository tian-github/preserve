package com.preserve.core.service;


public interface IDispatchService<M> {

	public void save(M model) throws Exception;

	public void update(M model) throws Exception;

	public void delete(M model) throws Exception;

}
