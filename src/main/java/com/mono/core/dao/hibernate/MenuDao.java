package com.mono.core.dao.hibernate;

import java.util.List;

import com.mono.core.entity.Menu;

public interface MenuDao extends BaseDao<Menu, Long>{

	List<Menu> getMenuByUserid(Long userid);

	List<Menu> getTopMenuByLoginname(String loginName);

}
