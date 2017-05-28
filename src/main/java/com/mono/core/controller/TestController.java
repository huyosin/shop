package com.mono.core.controller;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mono.core.entity.Test;
import com.mono.core.service.TestService;
import com.mono.core.util.hibernate.Page;

@Controller
@RequestMapping(value = "/test")
public class TestController {
	@Resource(name = "testService")
	private TestService testService;

	@RequestMapping(value = "/getAllPerPage")
	@RequiresAuthentication
	public String getAllPerPage(@RequestParam(value="pageNo", required=false) Integer pageNo, Model model) {
		Page<Test> page = testService.getAllPerPage(pageNo);
		model.addAttribute("page", page);
		return "query";
	}
}
