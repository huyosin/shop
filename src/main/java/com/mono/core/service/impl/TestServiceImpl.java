package com.mono.core.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.mono.core.dao.hibernate.BaseDao;
import com.mono.core.dao.hibernate.TestDao;
import com.mono.core.entity.Test;
import com.mono.core.service.TestService;
import com.mono.core.util.hibernate.Page;

@Service("testService")
@Transactional
public class TestServiceImpl extends BaseServiceImpl<Test, Integer> implements TestService {
	private TestDao testDao;

	@Resource(name = "testDaoHibernate")
	@Override
	public void setBaseDao(BaseDao<Test, Integer> testDao) {
		this.baseDao = testDao;
		this.testDao = (TestDao) testDao;
	}

	@Override
	public Page<Test> queryByIdName(int pageNo, int pageSize, int id, String name) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("name", name);
		return testDao.queryByIdName(pageNo, pageSize, params);
	}
}
