package team.waibao.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pager<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	//用来存放一个页面的学生的数量
	private List<T> dataList = new ArrayList<T>();
	private int pageSize; //一个页面显示的条数
	private int currentPage; //当前页数
	private int totalRecord; //总的数据条数
	private int totalPage; //总页数
	
	
	public Pager(List<T> dataList, int pageSize, int currentPage, int totalRecord,
			int totalPage) {
		super();
		this.dataList = dataList;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.totalRecord = totalRecord;
		this.totalPage = totalPage;
	}
	public Pager(int pageSize,int pageNum,List<T> sourceList){
		if(sourceList  == null || sourceList.size() == 0){
			return;
		}
	    this.pageSize = pageSize;	
	    this.totalRecord = sourceList.size();
	    this.totalPage = (totalRecord % pageSize == 0) ?totalRecord / pageSize:totalRecord / pageSize +1;
	    
	    this.currentPage  = (totalPage > pageNum)?pageNum:totalPage;
	    
	    int fromIndex = (this.currentPage-1) * this.pageSize;
	    int toIndex = (this.pageSize * this.currentPage > this.totalRecord) ?totalRecord:this.pageSize * this.currentPage;
	    this.dataList = sourceList.subList(fromIndex, toIndex);
	} 
	
	public Pager(){
		
	}
	
	
	public Pager(int currentPage, int pageSize, int total,List<T> sourceList) {
		this.totalPage = (total % pageSize == 0) ?total / pageSize:total / pageSize +1;
		this.currentPage  = (totalPage > currentPage)?currentPage:totalPage;
		this.pageSize = pageSize;
		this.totalRecord = total;
		this.dataList = sourceList;
		
	}
	public List<T> getDataList() {
		return dataList;
	}
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
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
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
}
