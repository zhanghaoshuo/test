package com.bean;

import java.util.List;

public class PageBean {//分页实体
	private int page=1;//当前页
	private int rows=5;//每页记录数
	private int maxpage;//最大页数
	private List<?> pageList;//返回记录集合（页面展示的集合）
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageBean(int page, int rows, int maxpage, List<?> pageList) {
		super();
		this.page = page;
		this.rows = rows;
		this.maxpage = maxpage;
		this.pageList = pageList;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getMaxpage() {
		return maxpage;
	}
	public void setMaxpage(int maxpage) {
		this.maxpage = maxpage;
	}
	public List<?> getPageList() {
		return pageList;
	}
	public void setPageList(List<?> pageList) {
		this.pageList = pageList;
	}
	@Override
	public String toString() {
		return "PageBean [page=" + page + ", rows=" + rows + ", maxpage=" + maxpage + ", pageList=" + pageList + "]";
	}
	

}
