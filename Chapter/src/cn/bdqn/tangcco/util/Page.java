package cn.bdqn.tangcco.util;

import java.util.List;
/**
 * 分页通用类
 */
public class Page<T>{
	private int currentIndex;//当前页
	private int totalCount;//总记录数
	private int pageTotalCount;//总页数
	private int pageSize;//每页显示记录数
	private List<T> pageList;//页面显示列表
	public int getCurrentIndex() {
		return currentIndex;
	}
	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		if (totalCount>0) {
			this.totalCount = totalCount;
			this.pageTotalCount=(this.totalCount%this.pageSize==0)?(this.totalCount/this.pageSize):(this.totalCount/this.pageSize+1);
		}
	}
	public int getPageTotalCount() {
		return pageTotalCount;
	}
	public void setPageTotalCount(int pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getPageList() {
		return pageList;
	}
	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}
}
