package com.mono.core.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.plugins.Page;
import com.mono.core.entity.Test;
import com.mono.core.entity.vo.TestVo;
import com.mono.core.service.TestService;
import com.mono.core.util.Result;

@Controller
@RequestMapping(value = "/test")
public class TestController {
	private static Logger logger = LoggerFactory.getLogger(TestController.class);

	@Resource(name = "testService")
	private TestService testService;

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@RequiresPermissions("/test/getAll")
	public String getAll() {
		return "test/test";
	}

	@RequestMapping(value = "/selectTestVoPage", method = RequestMethod.POST)
	@RequiresPermissions("/test/selectTestVoPage")
	@ResponseBody
	public Page<Test> selectPage(@RequestParam(value = "page", required = true) Integer pageNo,
			@RequestParam(value = "rows", required = true) Integer pageSize, @RequestParam(value = "sort", required = true)String orderByField, 
			String order, TestVo testVo) {
		Page<Test> page = new Page<Test>(pageNo, pageSize);
		Map<String, Object> condition = new HashMap<String, Object>();
		if (StringUtils.hasText(testVo.getName())) {
			condition.put("name", testVo.getName());
		}
		if (testVo.getCreatedateStart() != null) {
			condition.put("createdateStart", new SimpleDateFormat("yyyy-MM-dd").format(testVo.getCreatedateStart()));
		}
		if (testVo.getCreatedateEnd() != null) {
			condition.put("createdateEnd", new SimpleDateFormat("yyyy-MM-dd").format(testVo.getCreatedateEnd()));
		}
		if (StringUtils.hasText(orderByField)) {
			page.setOrderByField(orderByField);
		}
		if ("desc".equals(order)) {
            page.setAsc(false);
        } else {
            page.setAsc(true);
        }
		page.setCondition(condition);
		return testService.selectPerPage(page);
	}

	@RequestMapping(value = "/editPage", method = RequestMethod.GET)
	@RequiresPermissions("/test/editPage")
	public String editPage(Model model, Integer id) {
		model.addAttribute("id", id);
		return "test/editPage";
	}
	
	@RequestMapping(value = "/getTest", method = RequestMethod.GET)
	@RequiresPermissions("/test/getTest")
	@ResponseBody
	public Test getTest(Integer id) {
		return testService.selectById(id);
	}

	@RequestMapping("/edit")
	@ResponseBody
	@RequiresPermissions("/test/edit")
	public Object edit(Test test) {
		testService.updateById(test);
		return Result.success("编辑成功！");
	}

	@RequestMapping(value = "/addPage", method = RequestMethod.GET)
	@RequiresPermissions("/test/addPage")
	public String addPage(Model model) {
		return "test/addPage";
	}

	@RequestMapping("/add")
	@ResponseBody
	@RequiresPermissions("/test/add")
	public Object add(Test test) {
		testService.insert(test);
		return Result.success("添加成功！");
	}

	@RequestMapping("/delete")
	@ResponseBody
	@RequiresPermissions("/test/delete")
	public Object delete(Integer id) {
		testService.deleteById(id);
		return Result.success("删除成功！");
	}
}
