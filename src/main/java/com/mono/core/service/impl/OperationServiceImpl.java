package com.mono.core.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.mono.core.dao.hibernate.BaseDao;
import com.mono.core.entity.Operation;
import com.mono.core.service.OperationService;

@Service("operationService")
@Transactional
public class OperationServiceImpl extends BaseServiceImpl<Operation, Long> implements OperationService{

	@Override
	@Resource(name = "operationDaoHibernate")
	public void setBaseDao(BaseDao<Operation, Long> operationDao) {
		this.baseDao = operationDao;
	}

}
