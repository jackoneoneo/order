package team.waibao.service;

import java.util.List;

import team.waibao.entity.CartMenu;

public interface CartMenuService {

	/**
	 * 添加物品到购物车
	 *@param cartMenu 物品
	 */
	public void  addCartMenuToCart(CartMenu cartMenu);
	
	
	/**
	 * 跟新购物车里菜单数量
	 *@param menu 需要更新的菜单
	 */
	public void updateMenuAddOneAccountFromCart(CartMenu menu);
	/**
	 * 判断是否存在该物品在购物车
	 *@param menu
	 *@return
	 */
	public boolean isContainCartMenu(CartMenu menu);
	

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
