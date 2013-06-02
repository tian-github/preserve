package com.preserve.core.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.preserve.core.model.BaseModel;
import com.preserve.core.pagination.Page;
import com.preserve.core.service.IBaseService;
import com.preserve.core.service.IDispatchService;
import com.preserve.core.utils.BeanRowProcessor;
import com.preserve.core.utils.GeneralSQLBuilder;

public abstract class BaseServiceImpl<M extends BaseModel> implements
		IBaseService<M> {

	@Resource(name = "dispatchService")
	private IDispatchService dispatchService;

	public Object save(M model) throws Exception {
		Object object = getBaseDao().save(model);
		if (dispatchService != null)
			dispatchService.save(model);
		return object;
	}

	public Object update(M model) throws Exception {
		Object object = getBaseDao().update(model);
		if (dispatchService != null)
			dispatchService.update(model);
		return object;

	}

	public void delete(M model) throws Exception {
		getBaseDao().delete(model);
		if (dispatchService != null)
			dispatchService.delete(model);
	}

	public String getTableName() throws Exception {
		Class<? extends BaseModel> clazz = getBaseDao().getModelClass();
		return GeneralSQLBuilder.getTableName(clazz);
	};

	//0 开始
	public Page<M> findByPage(String sql, int curPage, int pageSize,
			Object... params) throws Exception {

		int total = getCount(sql, params);
		Page<M> page = new Page<M>(curPage, pageSize);
		page.setRowCount(total);

		String pageSql = parsePageSql(sql, page.getPageBegin(), page.getSize());

		List<M> result = getQueryRunner().query(
				pageSql,
				new BeanListHandler<M>((Class<M>) this.getBaseDao()
						.getModelClass(), new BasicRowProcessor(
						new BeanRowProcessor())), params);

		page.setRows(result);

		return page;

	}

	public String parsePageSql(String sql, int begin, int size) {

		String psql = " select * from (!{p_sql}) limit !{p_begin} ,!{p_size} ";

		psql = psql.replace("!{p_sql}", sql).replace("!{p_begin}", begin + "")
				.replace("!{p_begin}", size + "");
		return psql;
	}

	@Override
	public int getCount(String sql, Object... params) throws Exception {
		// TODO Auto-generated method stub

		String countSql = "select count(1) from ( !{sql} )";
		countSql = countSql.replace("!{sql}", sql);

		Integer result = getQueryRunner().query(countSql,
				new ResultSetHandler<Integer>() {
					@Override
					public Integer handle(ResultSet resultset)
							throws SQLException {
						// TODO Auto-generated method stub
						if (!resultset.next()) {
							return 0;
						} else {
							return resultset.getInt(1);
						}
					}
				}, params);
		return result;
	}

	@Override
	public List<M> getAll() throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM " + getTableName();

		List<M> result = getQueryRunner().query(
				sql,
				new BeanListHandler<M>((Class<M>) this.getBaseDao()
						.getModelClass(), new BasicRowProcessor(
						new BeanRowProcessor())));

		return result;
	}

	public abstract QueryRunner getQueryRunner();
}
