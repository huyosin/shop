package com.mono.core.entity.vo;

import java.util.List;

import com.mono.core.entity.Menu;
import com.mono.core.entity.User;

public class UserVo extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2558858643490241206L;
	
	private List<Menu> menus;

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

}
