package team.waibao.service;

import java.util.List;

import team.waibao.entity.Order;

/**
 * 
* @author 曾志鹏
* @version 创建时间：2016年8月30日 上午11:11:55
*
 */
public interface OrderService {

	/**
	 * 添加订单
	 *@param order 订单
	 */
	public void addOrder(Order order);
	
	/**
	 * 获取当前可用id
	 *@return
	 */
	public int getCurrentId();
	
	/**
	 * 根据用户名获取所有的订单
	 *@param userId 用户订单
	 *@return
	 */
	public List<Order> getOrdersByUserId(int userId);
}
