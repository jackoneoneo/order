package team.waibao.dao;

import java.util.List;

import team.waibao.entity.Cart;


/**
 * 购物车的操作
* @author 曾志鹏
* @version 创建时间：2016年8月17日 下午3:06:21
*
 */
public interface CartMapper {

	/**
	 * 通过用户的id创建一个不带物品信息的cart对象
	 *@param id
	 *@return
	 */
	public Cart getCartByUserId(int userId);
	
	/**
	 * 添加一个与购物车关联的用户
	 *@param userId 用户的Id
	 */
    public void addUserIdToCart(int userId);
 
	
}
