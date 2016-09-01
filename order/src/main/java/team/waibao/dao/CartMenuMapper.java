package team.waibao.dao;

import java.util.List;

import team.waibao.entity.CartMenu;

/**
 * 购物车里的菜单类
* @author 曾志鹏
* @version 创建时间：2016年8月18日 下午4:23:33
*
 */
public interface CartMenuMapper {

	/**
	 * 添加商品到购物车里
	 *@param menu
	 */
	public void addMenuToCart(CartMenu menu);
	/**
	 * 在购物车里删除指定的菜单
	 *@param menu 菜单
	 */
	public void deleteMenuFromCart(CartMenu menu);
	/**
	 * 跟新购物车里菜单数量
	 *@param menu 需要更新的菜单
	 */
	public void updateMenuAccountFromCart(CartMenu menu);
	/**
	 * 判断是否存在该物品在购物车
	 *@param menu
	 *@return
	 */
	public CartMenu isContainCartMenu(CartMenu menu);
	
	/**
	 * 通过cartId 找到该购物车里的所有物品
	 *@param cartId 购物车id
	 *@return
	 */
	public List<CartMenu> getCartMenusByCartId(int cartId);
	
	/**
	 * 通过购物车菜单id找到购物车里的物品
	 *@param cartMenuId
	 *@return
	 */
	public CartMenu getCartMenuByCartMenuId(int cartMenuId);
	
	/**
	 * 通过购物车菜单id删除购物车里的东西
	 *@param cartMenuId
	 */
	public void deleteCartMenuByCartMenuId(int cartMenuId);
}
