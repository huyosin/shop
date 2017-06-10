package com.mono.core.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mono.core.entity.Menu;
import com.mono.core.entity.User;
import com.mono.core.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {
	@Resource(name = "menuService")
	private MenuService menuService;

	@RequestMapping(value="/getUserMenu",method=RequestMethod.POST)
	@ResponseBody
	@RequiresAuthentication
	public List<Menu> getUserMenu() {
		Session session = SecurityUtils.getSubject().getSession();
		User user = (User) session.getAttribute("user");
		return menuService.getTopMenuByLoginname(user.getLoginName());
	}

}
