package com.mono.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.mono.core.dao.mapper.RoleMapper;
import com.mono.core.entity.Role;
import com.mono.core.service.RoleService;

@Service("roleService")
@Transactional
public class RoleServiceImpl extends ServiceImpl<RoleMapper,Role> implements RoleService {
	@Resource(name = "roleMapper")
	private RoleMapper roleMapper;

}
