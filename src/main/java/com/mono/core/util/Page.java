package com.mono.core.util;

import java.util.List;

public class Page<T> {
	public static final int NUM_PER_PAGE = 10;

	private int currentPage;
	private int totalPages;
	private int numPerPage;
	private int totalCount;
	private List<T> elements;

	public Page() {
		this.currentPage = 1;
		this.numPerPage = NUM_PER_PAGE;
	}

	public Page(int currentPage) {
		this.currentPage = currentPage;
		this.numPerPage = NUM_PER_PAGE;
	}

	public Page(int numPerPage, int currentPage) {
		this.currentPage = currentPage;
		this.numPerPage = numPerPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		this.totalPages = this.totalCount / this.numPerPage;
		if (this.totalCount % this.numPerPage != 0) {
			this.totalPages++;
		}
	}

	public List<T> getElements() {
		return elements;
	}

	public void setElements(List<T> elements) {
		this.elements = elements;
	}

	public int getStartNum() {
		return (this.getCurrentPage() - 1) * this.getNumPerPage();
	}

	@Override
	public String toString() {
		return "currentPage:" + currentPage + " totalPages:" + totalPages + " numPerPage:" + numPerPage
				+ " totalCount:" + totalCount;

	}
}
