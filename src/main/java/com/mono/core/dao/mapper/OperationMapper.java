package com.mono.core.dao.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mono.core.entity.Operation;

public interface OperationMapper extends BaseMapper<Operation>{
	List<Operation> getOperationByLoginName(String loginName);
}
