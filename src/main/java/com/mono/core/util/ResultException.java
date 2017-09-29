package com.mono.core.util;

public class ResultException extends RuntimeException {
	private static final long serialVersionUID = -1937723297311867842L;
	
	private int code = 500;
	private String msg;
	
	public ResultException(String msg){
		this(msg, 500);
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public ResultException(String msg, int code){
		super(msg);
		this.msg=msg;
		this.code=code;
	}

}
