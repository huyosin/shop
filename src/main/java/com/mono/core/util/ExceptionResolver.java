package com.mono.core.util;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Component
public class ExceptionResolver implements HandlerExceptionResolver {
	private final static Logger logger = LoggerFactory.getLogger(ExceptionResolver.class);

	@Resource 
	private JacksonObjectMapper jacksonObjectMapper;
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		logger.debug("开始resolveException");

		// 非控制器请求照成的异常
		if (!(handler instanceof HandlerMethod)) {
			return new ModelAndView("error/500");
		}
		HandlerMethod handlerMethod = (HandlerMethod) handler;

		if (WebUtils.isAjax(handlerMethod)) {
			Result result = new Result();
			if (ex instanceof ResultException) {
				result.put("code", ((ResultException) ex).getCode());
				result.put("msg", ((ResultException) ex).getMessage());
			}else if(ex instanceof DuplicateKeyException){
				result = Result.error("数据库中已存在该记录");
			}else if(ex instanceof AuthorizationException){
				result = Result.error("没有权限，请联系管理员授权");
			}else{
				result = Result.error();
			}
			MappingJackson2JsonView view = new MappingJackson2JsonView();
			view.setObjectMapper(jacksonObjectMapper);
			view.setContentType("text/html;charset=UTF-8");
			return new ModelAndView(view, result);
		}

		// 页面指定状态为500，便于上层的resion或者nginx的500页面跳转，由于error/500不适合对用户展示
		//response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		return new ModelAndView("error/500").addObject("error", ex.getMessage());
	}

}
