package com.mono.core.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.mono.core.entity.Operation;

public interface OperationService extends IService<Operation> {

	List<Operation> getOperationByLoginName(String loginName);

}
