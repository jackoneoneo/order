package team.waibao.entity;
/**
 * 订单里面的菜单类
* @author 曾志鹏
* @version 创建时间：2016年8月18日 上午10:23:16
*
 */
public class OrderMenu extends Menu{

	private static final long serialVersionUID = 2426642445260934960L;
	
	private int id;
	private Order order;
	private int amount;
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		if(amount < 0)
			throw new RuntimeException("订单的数量不能小于0！");
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return super.toString()+"OrderMenu [id=" + id+"amount=" + amount + ", order=" + order + "]";
	}
	

}
