package com.mono.core.util;

public class QueryCriteria {
	private String name;
	private String restriction;
	private String value;

	public QueryCriteria() {
		super();
	}

	public QueryCriteria(String name, String restriction, String value) {
		super();
		this.name = name;
		this.restriction = restriction;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRestriction() {
		return restriction;
	}

	public void setRestriction(String restriction) {
		this.restriction = restriction;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
