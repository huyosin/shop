package com.mono.core.dao.hibernate.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mono.core.dao.hibernate.TestDao;
import com.mono.core.entity.Test;
import com.mono.core.util.hibernate.Page;

@Repository("testDaoHibernate")
public class TestDaoImpl extends BaseDaoImpl<Test, Integer> implements TestDao {
	@Override
	public Page<Test> queryByIdName(int pageNo, int pageSize, Map<String, Object> params) {
		String hql = "from Test where id = :id and name like :name";
		List<Test> list = this.queryPerPage(hql, pageNo, pageSize, params);
		long totalElements = this.queryCount("select count(*) " + hql, params);
		return new Page<Test>(pageNo, pageSize, totalElements, list);
	}
}
