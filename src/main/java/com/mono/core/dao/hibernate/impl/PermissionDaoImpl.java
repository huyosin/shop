package com.mono.core.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import com.mono.core.dao.hibernate.PermissionDao;
import com.mono.core.entity.Permission;

@Repository("permissionDaoHibernate")
public class PermissionDaoImpl extends BaseDaoImpl<Permission, Long> implements PermissionDao {

}
