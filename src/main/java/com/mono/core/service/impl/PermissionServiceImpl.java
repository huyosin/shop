package com.mono.core.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.mono.core.dao.mapper.PermissionMapper;
import com.mono.core.entity.Permission;
import com.mono.core.service.PermissionService;

@Service("permissionService")
@Transactional
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper,Permission> implements PermissionService {

}
