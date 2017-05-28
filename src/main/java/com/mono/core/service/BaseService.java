package com.mono.core.service;

import java.util.List;

import com.mono.core.util.hibernate.Page;

public interface BaseService<T extends java.io.Serializable, PK extends java.io.Serializable> {

	T add(T t);

	T delete(PK id);

	T get(PK id);

	List<T> getAll();

	List<T> getAllById(PK id);

	T update(T t);

	Page<T> getAllPerPage(Integer pageNo);

	Page<T> getAllPerPage(int pageNo, int pageSize);
	
}
