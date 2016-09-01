package team.waibao.dao;


import java.util.List;

import team.waibao.entity.OrderMenu;

public interface OrderMenuMapper {

	/**
	 * 添加商品到订单里
	 *@param menu
	 */
	public void addMenuToOrder(OrderMenu menu);
	/**
	 * 在订单里删除指定的菜单
	 *@param menu 菜单
	 */
	public void deleteMenuFromOrder(OrderMenu menu);
	/**
	 * 跟新订单里菜单数量
	 *@param menu 需要更新的菜单
	 */
	public void updateMenuAccountFromOrder(OrderMenu menu);
	/**
	 * 通过订单号获取所有的菜单信息
	 *@param OrderId订单id
	 *@return
	 */
	public List<OrderMenu> getOrderMenusByOrderId(int OrderId);
}
