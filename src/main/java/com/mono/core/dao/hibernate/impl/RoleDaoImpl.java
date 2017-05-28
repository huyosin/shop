package com.mono.core.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import com.mono.core.dao.hibernate.RoleDao;
import com.mono.core.entity.Role;

@Repository("roleDaoHibernate")
public class RoleDaoImpl extends BaseDaoImpl<Role, Long> implements RoleDao {

}
