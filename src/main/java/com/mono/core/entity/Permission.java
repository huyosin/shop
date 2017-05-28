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
import javax.persistence.OrderBy;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Permission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3889472128662205261L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private int status;
	private int type;
	private Date createTime;
	private String description;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@Cascade({CascadeType.ALL})
	@JoinTable(
		name = "role_permission", 
		joinColumns = {@JoinColumn(name = "roleid")}, 
		inverseJoinColumns = {@JoinColumn(name = "permissionid")}
	)
	@OrderBy("id ASC")
	@JsonIgnore
	private List<Role> roles = new ArrayList<Role>();
	
	@ManyToMany(fetch=FetchType.LAZY)
	@Cascade({CascadeType.ALL})
	@JoinTable(
		name = "permission_operation", 
		joinColumns = {@JoinColumn(name = "permissionid")}, 
		inverseJoinColumns = {@JoinColumn(name = "operationid")}
	)
	@OrderBy("id ASC")
	@JsonIgnore
	private List<Operation> operations = new ArrayList<Operation>();

	@ManyToMany(fetch=FetchType.LAZY)
	@Cascade({CascadeType.ALL})
	@JoinTable(
		name = "permission_menu", 
		joinColumns = {@JoinColumn(name = "permissionid")}, 
		inverseJoinColumns = {@JoinColumn(name = "menuid")}
	)
	@OrderBy("id ASC")
	@JsonIgnore
	private List<Menu> menus = new ArrayList<Menu>();

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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

}
