package com.bean;

import java.util.List;

public class PageBean {//��ҳʵ��
	private int page=1;//��ǰҳ
	private int rows=5;//ÿҳ��¼��
	private int maxpage;//���ҳ��
	private List<?> pageList;//���ؼ�¼���ϣ�ҳ��չʾ�ļ��ϣ�
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
