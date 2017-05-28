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
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4788026111167257471L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private int orderno;
	private int status;
	private Date createTime;
	private String description;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@Cascade({CascadeType.ALL})
	@JoinTable(
		name = "user_role", 
		joinColumns = {@JoinColumn(name = "roleid")}, 
		inverseJoinColumns = {@JoinColumn(name = "userid")}
	)
	@OrderBy("id ASC")
	@JsonIgnore
	private List<User> users = new ArrayList<User>();

	@ManyToMany(fetch=FetchType.LAZY)
	@Cascade({CascadeType.ALL})
	@JoinTable(
		name = "role_permission", 
		joinColumns = {@JoinColumn(name = "roleid")}, 
		inverseJoinColumns = {@JoinColumn(name = "permissionid")}
	)
	@OrderBy("id ASC")
	@JsonIgnore
	private List<Permission> permissions = new ArrayList<Permission>();

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

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

	public int getOrderno() {
		return orderno;
	}

	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
