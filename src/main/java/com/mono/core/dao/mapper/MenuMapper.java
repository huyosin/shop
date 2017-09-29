package com.mono.core.dao.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mono.core.entity.Menu;
import com.mono.core.entity.vo.MenuVo;

public interface MenuMapper extends BaseMapper<Menu>{

	List<MenuVo> getMenuVoByUserId(Long userId);

	List<MenuVo> getMenuVoByLoginName(String loginName);

	List<MenuVo> getTopMenuVo();

	List<Menu> getTopMenu();
}
