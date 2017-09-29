package com.mono.core.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mono.core.service.UserService;
import com.mono.core.util.Result;

@Controller
public class LoginController {
	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login(@RequestParam String loginName, @RequestParam String password) {
		Subject user = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
		try {
			user.login(token);
			return Result.success();
		} catch (UnknownAccountException e) {
			return Result.error(e.getMessage());
		} catch (DisabledAccountException e) {
			return Result.error(e.getMessage());
		} catch (ExcessiveAttemptsException e) {
			return Result.error(e.getMessage());
		} catch (IncorrectCredentialsException e) {
			return Result.error("密码错误！");
		}
	}
}
