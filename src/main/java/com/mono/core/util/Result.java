package com.mono.core.util;

import java.util.HashMap;
import java.util.Map;

public class Result extends HashMap<String, Object> {
	private static final long serialVersionUID = -1797915403060968772L;
	public Result(){
		this.put("code", 200);
	}
	
	public static Result error(){
		return error(500, "未知异常，请联系管理员");
	}
	
	public static Result error(String msg){
		return error(500, msg);
	}
	
	public static Result error(int code, String msg){
		Result result = new Result();
		result.put("code", code);
		result.put("msg", msg);
		return result;
	}
	
	public static Result success(String msg){
		Result result = new Result();
		result.put("msg", msg);
		return result;
	}
	
	public static Result success(Map<String, Object> map){
		Result result = new Result();
		result.putAll(map);
		return result;
	}
	
	public static Result success(){
		return new Result();
	}

}
