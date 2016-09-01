package team.waibao.dao;

import java.util.List;

import team.waibao.entity.DividePageCondition;
import team.waibao.entity.Order;


/**
 *  *订单的操作接口
* @author 曾志鹏
* @version 创建时间：2016年8月17日 下午3:06:52
*
*/
public interface OrderMapper {

	/**
	 * 添加订单
	 *@param order 订单
	 */
	public void addOrder(Order order);
	/**
	 * 更新订单的状态
	 *@param order 订单
	 */
	public void updateOrderStatus(Order order);
	
	/**
	 * 通过商家的id找到商家所有的订单
	 *@param sellerId
	 *@return
	 */
	public List<Order> getOrdersBySellerId(int sellerId);
	
	
	/**
	 * 通过条条件来查找商家的订单
	 *@return
	 */
	public List<Order> getOrdersByCondition(DividePageCondition<Order> condition);
	
	/**
	 * 获取最大id
	 *@return
	 */
	public int getMaxId();
	/**
	 * 根据用户名获取所有的订单
	 *@param userId 用户订单
	 *@return
	 */
	public List<Order> getOrdersByUserId(int userId);
}
