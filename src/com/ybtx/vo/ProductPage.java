package com.ybtx.vo;

import java.util.List;

import com.ybtx.domain.Product;


public class ProductPage {
	private int pageSize;
	private int currentPage;
	private int totalCount;
	private int totalPage;
	private List<Product> dataList;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<Product> getDataList() {
		return dataList;
	}
	public void setDataList(List<Product> dataList) {
		this.dataList = dataList;
	}
	

}
