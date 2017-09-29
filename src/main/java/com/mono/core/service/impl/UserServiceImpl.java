package com.mono.core.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.mono.core.dao.mapper.UserMapper;
import com.mono.core.entity.User;
import com.mono.core.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
	@Resource(name = "userMapper")
	private UserMapper userMapper;

	@Override
	public User getUserByLoginName(String loginName){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("loginName", loginName);
		List<User> users = userMapper.selectByMap(params);
		if(users.size()>0){
			return users.get(0);
		}else{
			return null;
		}
	}
}
