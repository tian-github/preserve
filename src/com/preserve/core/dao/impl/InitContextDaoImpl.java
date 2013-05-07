package com.preserve.core.dao.impl;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;

import com.preserve.core.dao.IinitContextDao;
import com.preserve.core.exception.AppStartupException;

@Repository
public class InitContextDaoImpl implements IinitContextDao {
	
	private static final Logger log = Logger.getLogger(InitContextDaoImpl.class);
	
	@javax.annotation.Resource private JdbcTemplate jdbc;
	
	
	/**
	 * 执行sql脚本方法
	 * // TODO 应该将此方法提取出来并改变其中的异常类型
	 * @param sqlFilePath
	 */
	private void executeSql(String sqlFilePath) {
		if (sqlFilePath == null) {
			throw new AppStartupException("执行的sql路径["+sqlFilePath+"]不对啊");
		}
		try {
			log.info("加载脚本["+sqlFilePath+"]");
			Resource sqlRes = new ClassPathResource(sqlFilePath);
			EncodedResource encRes = new EncodedResource(sqlRes, "UTF-8");
			String sqls = null;
			sqls = FileCopyUtils.copyToString(encRes.getReader());
			String[] sqlArr = sqls.split(";");
			log.info("开始执行脚本");
			for (String sql : sqlArr) {
				log.info(sql);
				jdbc.execute(sql);
			}
			log.info("执行脚本完成");
		} catch (IOException e) {
			log.error("读取["+sqlFilePath+"]文件失败", e);
			throw new AppStartupException("读取["+sqlFilePath+"]文件失败", e);
		} catch (Exception e) {
			log.error("执行["+sqlFilePath+"]文件失败", e);
			throw new AppStartupException("执行["+sqlFilePath+"]文件失败", e);
		}
	}


	@Override
	public void initDB() throws Exception {
		// TODO Auto-generated method stub
		executeSql("db/init.sql");
	}


	@Override
	public void resetDB() throws Exception {
		// TODO Auto-generated method stub
		executeSql("db/reset.sql");
	}


	@Override
	public void updateDB(String version) throws Exception {
		// TODO Auto-generated method stub
		executeSql("db/update"+version+".sql");
	}
	

}
