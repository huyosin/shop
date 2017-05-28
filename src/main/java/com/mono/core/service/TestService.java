package com.mono.core.service;

import com.mono.core.entity.Test;
import com.mono.core.util.hibernate.Page;

public interface TestService extends BaseService<Test, Integer>{

	Page<Test> queryByIdName(int pageNo, int pageSize, int id, String name);

}
