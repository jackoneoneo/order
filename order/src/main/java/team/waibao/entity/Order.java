package team.waibao.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
* 订单类
* @author 曾志鹏
* @version 创建时间：2016年8月16日 下午11:43:53
*
*/
public class Order implements Serializable {
	
	private static final long serialVersionUID = -3315008107032664864L;
	private Seller seller;
	private int orderStatus;
	private User user;
	private double orderPrice;
	private Date orderTime;
	private int orderId;
	private List<OrderMenu> menus;
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public List<OrderMenu> getMenus() {
		return menus;
	}
	public void setMenus(List<OrderMenu> menus) {
		this.menus = menus;
	}
	@Override
	public String toString() {
		return "Order [seller=" + seller + ", orderStatus=" + orderStatus
				+ ", user=" + user + ", orderPrice=" + orderPrice
				+ ", orderTime=" + orderTime + ", orderId=" + orderId
				+ ", menus=" + menus + "]";
	}
	public Order() {
	
	}
	
	

}
