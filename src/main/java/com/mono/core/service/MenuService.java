package com.mono.core.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.mono.core.entity.Menu;
import com.mono.core.entity.vo.MenuVo;
import com.mono.core.entity.vo.TreeVo;

public interface MenuService extends IService<Menu> {

	List<MenuVo> getMenuByUserId(Long userid);

	List<MenuVo> getMenuByLoginName(String loginName);
	
	List<TreeVo> getMenuTreeByLoginName(String loginName);

	List<TreeVo> getMenuTree();

	List<Menu> getTopMenu();

}
