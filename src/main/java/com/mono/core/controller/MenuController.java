package com.mono.core.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mono.core.entity.Menu;
import com.mono.core.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {
	@Resource(name = "menuService")
	private MenuService menuService;

	@RequestMapping(value="/getUserMenu",method=RequestMethod.POST)
	@ResponseBody
	public List<Menu> getUserMenu() {
//		Session session = SecurityUtils.getSubject().getSession();
//		User user = (User) session.getAttribute("user");
//		return menuService.getMenuByLoginname(user.getLoginName());
		System.out.println("menu11111111");
		return menuService.getTopMenuByLoginname("liuliang");
	}

}
