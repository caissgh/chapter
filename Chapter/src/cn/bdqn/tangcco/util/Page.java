package cn.bdqn.tangcco.util;

import java.util.List;
/**
 * ��ҳͨ����
 */
public class Page<T>{
	private int currentIndex;//��ǰҳ
	private int totalCount;//�ܼ�¼��
	private int pageTotalCount;//��ҳ��
	private int pageSize;//ÿҳ��ʾ��¼��
	private List<T> pageList;//ҳ����ʾ�б�
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
