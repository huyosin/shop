package com.mono.core.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.mono.core.dao.hibernate.BaseDao;
import com.mono.core.dao.hibernate.UserDao;
import com.mono.core.entity.User;
import com.mono.core.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {
	private UserDao userDao;
	
	@Resource(name = "userDaoHibernate")
	@Override
	public void setBaseDao(BaseDao<User, Long> userDao) {
		this.baseDao = userDao;
		this.userDao = (UserDao) userDao;
	}
	
	public User getUserByLoginname(String loginName){
		return userDao.getUserByLoginname(loginName);
	}
}
