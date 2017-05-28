package com.mono.core.dao.hibernate.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mono.core.dao.hibernate.UserDao;
import com.mono.core.entity.User;

@Repository("userDaoHibernate")
public class UserDaoImpl extends BaseDaoImpl<User, Long> implements UserDao {

	@Override
	public User getUserByLoginname(String loginName) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("loginName", loginName);
		return this.queryUnique(params);
	}
}
