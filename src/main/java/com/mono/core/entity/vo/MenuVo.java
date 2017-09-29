package com.mono.core.entity.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class MenuVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7866803942687751570L;
	private Long id;
	private String name;
	private String url;
	private Long pid;
	private Integer status;
	private Integer type;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+08")
	private Date createTime;
	private String description;
	@JsonInclude(Include.NON_NULL)
	private List<MenuVo> childMenus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
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

	public List<MenuVo> getChildMenus() {
		return childMenus;
	}

	public void setChildMenus(List<MenuVo> childMenus) {
		this.childMenus = childMenus;
	}

	public TreeVo convert2TreeVo(){
		TreeVo treeVo = new TreeVo();
		treeVo.setId(this.getId());
		treeVo.setText(this.getName());
		if(this.getChildMenus().isEmpty()){
			treeVo.setState("open");
		}else{
			treeVo.setChildren(this.convertChildMenus2TreeVos());
			treeVo.setState("closed");
		}
		treeVo.setPid(this.getPid());
		if(StringUtils.hasText(this.getUrl())){
			Map<String,Object> attributes = new HashMap<String, Object>();
			attributes.put("url", this.getUrl());
			treeVo.setAttributes(attributes);
		}
		return treeVo;
	}

	public List<TreeVo> convertChildMenus2TreeVos() {
		List<TreeVo> treeVos = new ArrayList<TreeVo>();
		for (MenuVo menuVo : this.getChildMenus()) {
			treeVos.add(menuVo.convert2TreeVo());
		}
		return treeVos;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("id:").append(id).append(" name:").append(name).append(" url:").append(url).append(" pid:")
				.append(pid).append(" childmenu:").append(childMenus);
		return result.toString();
	}
}
