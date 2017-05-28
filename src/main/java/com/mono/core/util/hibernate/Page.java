package com.mono.core.util.hibernate;

import java.util.List;

public class Page<T> implements java.io.Serializable {
	private static final long serialVersionUID = 5633829940236061195L;

	public static final int DEFAULT_PAGE_SIZE = 10;

	private List<T> elements;

	private long totalElements;

	private int pageNo;

	private int pageSize;

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

	@Override
	public String toString() {
		return "pageNo:" + this.getPageNo() + " pageSize:" + this.getPageSize() + " totalElements:"
				+ this.getTotalElements() + "\n" + this.getElements();
	}

}
