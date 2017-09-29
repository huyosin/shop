package com.mono.core.service;

import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.mono.core.entity.Test;

public interface TestService extends IService<Test>{

	Page<Test> queryByIdName(int pageNo, int pageSize, int id, String name);

	Page<Test> selectPerPage(Page<Test> page);
	
	List<Test> selectTestByName(String name);

}
