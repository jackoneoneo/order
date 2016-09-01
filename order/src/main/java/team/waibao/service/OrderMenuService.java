package team.waibao.service;

import java.util.List;

import team.waibao.entity.OrderMenu;

public interface OrderMenuService {

	/**
	 * 添加商品到订单里
	 *@param menu
	 */
	public void addMenuToOrder(OrderMenu menu);
	
	/**
	 * 通过订单号获取所有的菜单信息
	 *@param OrderId订单id
	 *@return
	 */
	public List<OrderMenu> getOrderMenusByOrderId(int OrderId);
}
