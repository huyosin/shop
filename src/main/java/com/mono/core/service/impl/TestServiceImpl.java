package com.mono.core.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.mono.core.dao.mapper.TestMapper;
import com.mono.core.entity.Test;
import com.mono.core.service.TestService;

@Service("testService")
@Transactional
public class TestServiceImpl extends ServiceImpl<TestMapper,Test> implements TestService {
	@Resource(name = "testMapper")
	private TestMapper testMapper;

	@Override
	public Page<Test> queryByIdName(int pageNo, int pageSize, int id, String name) {
		Page<Test> page = new Page<Test>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("name", name);
		page.setCurrent(pageNo);
		page.setSize(pageSize);
		page.setRecords(testMapper.selectPageByMap(page, params));
		return page;
	}

	@Override
	public Page<Test> selectPerPage(Page<Test> page) {
		List<Test> records = testMapper.selectPageByMap(page, page.getCondition());
		page.setRecords(records);
		return page;
	}

	@Override
	public List<Test> selectTestByName(String name) {
		return testMapper.selectTestByName(name);
	}
}
