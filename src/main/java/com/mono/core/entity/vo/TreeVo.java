package com.mono.core.entity.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class TreeVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 866045029823054016L;
	
	private Long id;
	private String text;
	private String state = "closed";
	private boolean checked = false;
	private Map<String,Object> attributes;
	@JsonInclude(Include.NON_NULL)
	private List<TreeVo> children;
	private Long pid;
	private String iconCls;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	public List<TreeVo> getChildren() {
		return children;
	}
	public void setChildren(List<TreeVo> children) {
		this.children = children;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("id:").append(id).append(" text:").append(text).append(" pid:")
				.append(pid).append(" children:").append(children);
		return result.toString();
	}

}
