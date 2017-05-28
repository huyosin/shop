package com.mono.core.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Menu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7516890925975861374L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String url;
	private long pid;
	private int status;
	private int type;
	private Date createTime;
	private String description;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@Cascade({CascadeType.ALL})
//	@JoinColumn(name = "pid")
//	@JsonIgnore
//	private Menu parent;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pid")
	@Cascade({CascadeType.ALL})
	@OrderBy("id ASC")
	private List<Menu> childs = new ArrayList<Menu>();

	@ManyToMany(fetch = FetchType.LAZY)
	@Cascade({CascadeType.ALL})
	@JoinTable(name = "permission_menu", joinColumns = {@JoinColumn(name = "menuid")}, inverseJoinColumns = {
			@JoinColumn(name = "permissionid")})
	@OrderBy("id ASC")
	@JsonIgnore
	private List<Permission> permissions = new ArrayList<Permission>();

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

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public List<Menu> getChilds() {
		return childs;
	}

	public void setChilds(List<Menu> childs) {
		this.childs = childs;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Menu.id:").append(id).append(" Menu.name:").append(name).append(" Menu.url:").append(url).append(" Menu.childs: ").append(childs);
		return result.toString();
	}

}
