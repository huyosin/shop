package com.mono.core.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.mono.core.dao.hibernate.BaseDao;
import com.mono.core.dao.hibernate.MenuDao;
import com.mono.core.entity.Menu;
import com.mono.core.service.MenuService;

@Service("menuService")
@Transactional
public class MenuServiceImpl extends BaseServiceImpl<Menu, Long> implements MenuService {
	private MenuDao menuDao;

	@Override
	@Resource(name = "menuDaoHibernate")
	public void setBaseDao(BaseDao<Menu, Long> menuDao) {
		this.baseDao = menuDao;
		this.menuDao = (MenuDao) menuDao;
	}

	@Override
	public List<Menu> getMenuByUserid(Long userid){
		return menuDao.getMenuByUserid(userid);
	}
	
	@Override
	public List<Menu> getTopMenuByLoginname(String loginName){
		return menuDao.getTopMenuByLoginname(loginName);
	}

}
