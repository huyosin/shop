package com.mono.core.dao.hibernate;

import com.mono.core.entity.User;

public interface UserDao extends BaseDao<User, Long> {

	User getUserByLoginname(String loginName);

}
