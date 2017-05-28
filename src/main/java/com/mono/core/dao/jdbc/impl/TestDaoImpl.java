package com.mono.core.dao.jdbc.impl;

import org.springframework.stereotype.Repository;

import com.mono.core.dao.jdbc.TestDao;
import com.mono.core.entity.Test;

@Repository("testDaoJdbc")
public class TestDaoImpl extends BaseDaoImpl<Test> implements TestDao<Test> {
	
}
