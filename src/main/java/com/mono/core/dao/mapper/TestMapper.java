package com.mono.core.dao.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.mono.core.entity.Test;

public interface TestMapper extends BaseMapper<Test> {
	List<Test> selectTestByName(String name);

	List<Test> selectPageByMap(Page<Test> page, Map<String, Object> params);
}
