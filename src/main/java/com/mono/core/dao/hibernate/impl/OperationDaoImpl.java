package com.mono.core.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import com.mono.core.dao.hibernate.OperationDao;
import com.mono.core.entity.Operation;

@Repository("operationDaoHibernate")
public class OperationDaoImpl extends BaseDaoImpl<Operation, Long> implements OperationDao {

}
