package com.mono.core.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.mono.core.dao.hibernate.BaseDao;
import com.mono.core.entity.Role;
import com.mono.core.service.RoleService;

@Service("roleService")
@Transactional
public class RoleServiceImpl extends BaseServiceImpl<Role, Long> implements RoleService {

	@Override
	@Resource(name = "roleDaoHibernate")
	public void setBaseDao(BaseDao<Role, Long> roleDao) {
		this.baseDao = roleDao;
	}

}
