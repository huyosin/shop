package com.mono.core.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mono.core.entity.Menu;
import com.mono.core.entity.User;
import com.mono.core.entity.vo.MenuVo;
import com.mono.core.entity.vo.TreeVo;
import com.mono.core.service.MenuService;
import com.mono.core.util.Result;

@Controller
@RequestMapping("/menu")
public class MenuController {
	@Resource(name = "menuService")
	private MenuService menuService;

	@RequestMapping(value="/menuPage",method=RequestMethod.GET)
	@RequiresPermissions("/menu/menuPage")
	public String menuPage() {
		return "/admin/menu/menuPage";
	}

	@RequestMapping(value="/getUserMenuTree",method=RequestMethod.POST)
	@ResponseBody
	@RequiresPermissions("/menu/getUserMenuTree")
	public List<TreeVo> getUserMenuTree() {
		Session session = SecurityUtils.getSubject().getSession();
		User user = (User) session.getAttribute("user");
		return menuService.getMenuTreeByLoginName(user.getLoginName());
	}

	@RequestMapping(value="/getUserMenu",method=RequestMethod.POST)
	@ResponseBody
	@RequiresPermissions("/menu/getUserMenu")
	public List<MenuVo> getUserMenu() {
		Session session = SecurityUtils.getSubject().getSession();
		User user = (User) session.getAttribute("user");
		return menuService.getMenuByLoginName(user.getLoginName());
	}

	@RequestMapping(value="/getMenuTree",method=RequestMethod.POST)
	@ResponseBody
	@RequiresPermissions("/menu/getMenuTree")
	public List<TreeVo> getMenuTree() {
		return menuService.getMenuTree();
	}

	@RequestMapping(value="/getMenu",method=RequestMethod.GET)
	@ResponseBody
	@RequiresPermissions("/menu/getMenu")
	public Menu getMenu(Integer id) {
		return menuService.selectById(id);
	}

	@RequestMapping(value="/edit",method=RequestMethod.POST)
	@ResponseBody
	@RequiresPermissions("/menu/edit")
	public Object edit(Menu menu) {
		if (menuService.updateById(menu)){
			return Result.success("编辑成功！");
		}
		return Result.error("编辑失败,找不到Id为" + menu.getId() + "的数据！");
	}

	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	@RequiresPermissions("/menu/delete")
	public Object delete(Long id) {
		if (menuService.deleteById(id)){
			return Result.success("删除成功！");
		}
		return Result.error("删除失败,找不到Id为" + id + "的数据！");
	}

	@RequestMapping(value="/getTopMenu",method=RequestMethod.POST)
	@ResponseBody
	@RequiresPermissions("/menu/getTopMenu")
	public List<Menu> getTopMenu() {
		return menuService.getTopMenu();
	}

	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	@RequiresPermissions("/menu/add")
	public Object add(Menu menu) {
		if(menuService.insert(menu)){
			return Result.success("新增成功！");
		}
		return Result.error("新增失败！");
	}

}
