package com.mono.core.entity;

import java.io.Serializable;
import java.util.Date;

public class Operation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8763350216437305307L;

	private long id;
	private String name;
	private String url;
	private long pid;
	private int status;
	private int type;
	private Date createTime;
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("ID:").append(this.getId()).append(" Name:").append(this.getName()).append(" Url:").append(this.getUrl()).append(" CreateTime:").append(this.getCreateTime());
		return sb.toString();
	}
}
