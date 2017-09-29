package com.mono.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.mono.core.dao.mapper.MenuMapper;
import com.mono.core.entity.Menu;
import com.mono.core.entity.vo.MenuVo;
import com.mono.core.entity.vo.TreeVo;
import com.mono.core.service.MenuService;

@Service("menuService")
@Transactional
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
	@Resource(name = "menuMapper")
	private MenuMapper menuMapper;
	
	@Override
	public List<MenuVo> getMenuByUserId(Long userid){
		return menuMapper.getMenuVoByUserId(userid);
	}
	
	@Override
	public List<MenuVo> getMenuByLoginName(String loginName){
		return menuMapper.getMenuVoByLoginName(loginName);
	}

	@Override
	public List<TreeVo> getMenuTreeByLoginName(String loginName){
		List<MenuVo> menuVos = menuMapper.getMenuVoByLoginName(loginName);
		return convert2TreeVoList(menuVos);
	}	
	
	@Override
	public List<TreeVo> getMenuTree(){
		List<MenuVo> menuVos = menuMapper.getTopMenuVo();
		return convert2TreeVoList(menuVos);
	}	
	
	@Override
	public List<Menu> getTopMenu(){
		return menuMapper.getTopMenu();
	}
	
	private List<TreeVo> convert2TreeVoList(List<MenuVo> menuVos){
		List<TreeVo> treeVos = new ArrayList<TreeVo>();
		for(MenuVo menu : menuVos){
			treeVos.add(menu.convert2TreeVo());
		}
		return treeVos;
	}

}
