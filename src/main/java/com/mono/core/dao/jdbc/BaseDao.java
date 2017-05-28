package com.mono.core.dao.jdbc;

import java.util.List;
import java.util.Map;

import com.mono.core.util.Page;
import com.mono.core.util.QueryHelper;


public interface BaseDao<T> {

	T get(int id);

	List<T> getAll();

	int add(T t);

	int delete(int id);

	int delete(Map<String, Object> paramMap);

	int update(T t);

	Page<T> query(Page<T> page, QueryHelper queryHelper);

	String buildInsertSql();

	String buildInsertSql(boolean isNativeId);

	String buildUpdateSql();

	String buildUpdateSql(boolean isNativeId);

}
