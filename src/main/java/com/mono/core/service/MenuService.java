package com.mono.core.service;

import java.util.List;

import com.mono.core.entity.Menu;

public interface MenuService extends BaseService<Menu, Long> {

	List<Menu> getMenuByUserid(Long userid);

	List<Menu> getTopMenuByLoginname(String loginName);

}
