package team.waibao.service;

import java.util.List;

import team.waibao.entity.Cart;
import team.waibao.entity.CartMenu;


/**
 * 购物车服务类
* @author 曾志鹏
* @version 创建时间：2016年8月17日 下午3:11:26
*
 */
public interface CartService {
   /**
    * 通过用户名找到该用户所有的购物车菜单号
    *@param userName
    *@return
    */
	public List<Integer> getCartMenuIdByUserName(String userName);

	/**
	 * 通过用户的id获取购物车
	 *@param id用户id
	 *@return
	 */
	public Cart getCartByUserId(int userId);
	/**
	 * 给指定 的用户添加一个购物车
	 *@param userId 用户id
	 */
	public void addCartToUserId(int userId);
	
 /**
  * 通过用户名过去该用户的购物车里面的东西
  *@param userName 用户名
  *@return
  */
	public List<CartMenu> getCartMenuByUserName(String userName);
	
	
}
