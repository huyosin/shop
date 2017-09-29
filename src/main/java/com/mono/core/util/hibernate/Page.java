package com.mono.core.util.hibernate;

import java.util.List;
import java.util.Map;

public class Page<T> implements java.io.Serializable {
	private static final long serialVersionUID = 5633829940236061195L;

	public static final int DEFAULT_PAGE_SIZE = 10;

	private List<T> elements;

	private long totalElements;

	private int pageNo;

	private int pageSize;
	
	private String sort;
	
	private String order;
	
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public Map<String, Object> getCondition() {
		return condition;
	}

	public void setCondition(Map<String, Object> condition) {
		this.condition = condition;
	}

	private Map<String, Object> condition;

	public Page(int pageNo, int pageSize) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}

	public Page(int pageNo, long totalElements, List<T> elements) {
		super();
		this.elements = elements;
		this.totalElements = totalElements;
		this.pageNo = pageNo;
		this.pageSize = DEFAULT_PAGE_SIZE;
	}

	public Page(int pageNo, int pageSize, long totalElements, List<T> elements) {
		super();
		this.elements = elements;
		this.totalElements = totalElements;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}

	public List<T> getElements() {
		return elements;
	}

	public void setElements(List<T> elements) {
		this.elements = elements;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getTotalPages() {
		return (int) (totalElements / pageSize + (totalElements % pageSize > 0 ? 1 : 0));
	}

	public int getPageStart() {
		return getPageStart(this.pageNo, this.pageSize);
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public static int getPageStart(int pageNo, int pageSize) {
		return (pageNo - 1) * pageSize;
	}

	public boolean hasNext() {
		return this.pageNo < this.getTotalPages();
	}

	public boolean hasPrev() {
		return this.pageNo > 1;
	}

	public int nextPageNo() {
		return this.pageNo + 1;
	}

	public int prevPageNo() {
		return this.pageNo - 1;
	}

	@Override
	public String toString() {
		return "pageNo:" + this.getPageNo() + " pageSize:" + this.getPageSize() + " totalElements:"
				+ this.getTotalElements() + "\n" + this.getElements();
	}

}
