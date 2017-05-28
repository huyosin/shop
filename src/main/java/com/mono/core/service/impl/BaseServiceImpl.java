package com.mono.core.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import com.mono.core.dao.hibernate.BaseDao;
import com.mono.core.service.BaseService;
import com.mono.core.util.hibernate.Page;

@Transactional
public abstract class BaseServiceImpl<T extends java.io.Serializable, PK extends java.io.Serializable>
		implements
			BaseService<T, PK> {
	protected BaseDao<T, PK> baseDao;

	public abstract void setBaseDao(BaseDao<T, PK> baseDao);

	@Override
	public T add(T t) {
		return baseDao.add(t);
	}

	@Override
	public T delete(PK id) {
		return baseDao.delete(id);
	}

	@Override
	public T get(PK id) {
		return baseDao.get(id);
	}

	@Override
	public List<T> getAll() {
		return baseDao.getAll();
	}
	
	@Override
	public List<T> getAllById(PK id) {
		return baseDao.getAllById(id);
	}

	@Override
	public T update(T t) {
		return baseDao.update(t);
	}

	@Override
	public Page<T> getAllPerPage(Integer pageNo) {
		if(pageNo == null){
			pageNo = 1;
		}
		return this.getAllPerPage(pageNo, Page.DEFAULT_PAGE_SIZE);
	}

	@Override
	public Page<T> getAllPerPage(int pageNo, int pageSize) {
		return baseDao.getAllPerPage(pageNo, pageSize);
	}
}
