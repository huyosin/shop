package com.mono.core.service;

import com.baomidou.mybatisplus.service.IService;
import com.mono.core.entity.User;

public interface UserService extends IService<User> {

	User getUserByLoginName(String loginName);

}
