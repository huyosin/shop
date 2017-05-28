package com.mono.core.dao.hibernate.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mono.core.dao.hibernate.MenuDao;
import com.mono.core.entity.Menu;

@Repository("menuDaoHibernate")
public class MenuDaoImpl extends BaseDaoImpl<Menu, Long> implements MenuDao {
	
	@Override
	public List<Menu> getMenuByUserid(Long userid){
		String hql = "select distinct m from Menu m join m.permissions p join p.roles r join r.users u where u.id = :userid order by m.id";
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("userid", userid);
		return this.getAll(hql,params);
	}

	@Override
	public List<Menu> getTopMenuByLoginname(String loginName){
		String hql = "select distinct m from Menu m join m.permissions p join p.roles r join r.users u where m.pid=0 and u.loginName = :loginName order by m.id";
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("loginName", loginName);
		return this.getAll(hql,params);
	}
}
