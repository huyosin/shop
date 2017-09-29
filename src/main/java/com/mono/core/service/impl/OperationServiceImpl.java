package com.mono.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.mono.core.dao.mapper.OperationMapper;
import com.mono.core.entity.Operation;
import com.mono.core.service.OperationService;

@Service("operationService")
@Transactional
public class OperationServiceImpl extends ServiceImpl<OperationMapper, Operation> implements OperationService{
	@Resource(name = "operationMapper")
	private OperationMapper operationMapper;
	
	@Override
	public List<Operation> getOperationByLoginName(String loginName){
		return operationMapper.getOperationByLoginName(loginName);
	}

}
