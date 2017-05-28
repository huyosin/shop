package com.mono.core.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Test implements java.io.Serializable {
	private static final long serialVersionUID = -5849583298318979036L;

	@Id
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString(){
		return "Id:" + id + ",Name:" + name;
	}

}
