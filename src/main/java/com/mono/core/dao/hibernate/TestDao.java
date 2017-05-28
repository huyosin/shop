package com.mono.core.dao.hibernate;

import java.util.Map;

import com.mono.core.entity.Test;
import com.mono.core.util.hibernate.Page;

public interface TestDao extends BaseDao<Test,Integer>{

	Page<Test> queryByIdName(int pageNo, int pageSize, Map<String, Object> params);

}
