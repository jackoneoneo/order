package team.waibao.service;

import java.util.List;

import team.waibao.entity.Order;
import team.waibao.entity.SellerMenu;
import team.waibao.entity.User;

public interface UserService {

	/**
	 * 添加一个用户
	 *@param user 要添加的用户
	 */
	public void addUser(User user);
	/**
	 * 根据条件查找用户
	 *@param searchingCondition 查询的条件
	 *@return
	 */
	public List<User> findUsers(User searchingCondition);
	
	/**
	 * 通过用户名查找订单
	 *@param userName
	 *@return
	 */
	public List<Order> findOrdersByUserName(String userName);
	
	/**
	 * 为指定用户添加金额
	 *@param userName 指定的用户
	 *@param recruitment 增加的金额
	 */
	public void addMoneyForUser(String userName,double  recruitment);
	
	/**
	 * 为指定用户减少金额
	 *@param userName 指定的用户
	 *@param decrement 减少量
	 */
	public void reduceMoneyForUser(String userName,double decrement);
	/**
	 * 判读是否存在该用户
	 *@param user 判断的对象
	 *@return
	 */
	public boolean isContainUser(User user);
	/**
	 * 是否存在该用户名
	 *@param userName 用户名
	 *@return
	 */
	public boolean isContainUserName(String userName);
	/**
	 * 通过用户名找到用户的id
	 *@param userName 用户名
	 *@return
	 */
	public int getIdByUserName(String userName);
	
	/**
	 * 通过用户id找到余额
	 *@param userId
	 *@return
	 */
	public double getUserAccountByUserId(int userId);
	
}
