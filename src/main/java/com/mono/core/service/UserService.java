package com.mono.core.service;

import com.mono.core.entity.User;

public interface UserService extends BaseService<User, Long> {

	User getUserByLoginname(String loginName);

}
