package team.waibao.entity;

import java.io.Serializable;

/**
 * 分页信息类
* @author 曾志鹏
* @version 创建时间：2016年8月23日 下午5:11:29
*
 */
public class DividePageCondition<T> implements Serializable {

	private static final long serialVersionUID = 597645586680588397L;
	
	private int id;//物品的标识
	private int currentPage; //当前页数
	//默认为10条
	private int pageSize = 10; //页面显示的数据的条数
	
	private T condition; //抽象的条件
	
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPagesize(int pageSize) {
		this.pageSize = pageSize;
	}
	public DividePageCondition( int currentPage, int pageSize ,T condition,int id) {
		super();
	    this.condition = condition;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.id = id;
	}
	
	public DividePageCondition(){}
	public T getCondition() {
		return condition;
	}
	public void setCondition(T condition) {
		this.condition = condition;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
