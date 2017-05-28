package com.mono.core.dao.hibernate;

import java.util.List;
import java.util.Map;

import com.mono.core.util.hibernate.Page;

public interface BaseDao<T extends java.io.Serializable, PK extends java.io.Serializable> {

	T get(PK id);

	List<T> getAll();
	
	List<T> getAll(String hql, Map<String, Object> params);
	
	List<T> getAllById(PK id);

	T add(T t);

	T delete(PK id);

	T update(T t);

	Page<T> getAllPerPage(int start, int pageNo);

	List<T> queryPerPage(String hql, int pageNo, int pageSize, Map<String, Object> params);

	long queryCount(String hql, Map<String, Object> params);

	List<T> query(Map<String, Object> params);

	T queryUnique(Map<String, Object> params);

}
