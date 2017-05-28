package com.mono.core.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.mono.core.dao.hibernate.BaseDao;
import com.mono.core.entity.Permission;

@Service("permissionService")
@Transactional
public class PermissionServiceImpl extends BaseServiceImpl<Permission, Long> implements PermissionService {

	@Override
	@Resource(name = "permissionDaoHibernate")
	public void setBaseDao(BaseDao<Permission, Long> permissionDao) {
		this.baseDao = permissionDao;
	}

}
