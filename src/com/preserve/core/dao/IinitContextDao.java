package com.preserve.core.dao;

public interface IinitContextDao {
	
	public void initDB() throws Exception;

	public void resetDB() throws Exception;
	
	public void updateDB(String version) throws Exception;
}
