package team.waibao.service;

import java.util.List;

import team.waibao.entity.SellerMenu;




public interface SellerMenuService {

	/**
	 *通过商品的id找到该商品
	 *@param sellerMenuId 商品的id
	 *@return
	 */
	public SellerMenu getSellerMenuBySellerMenuId(int sellerMenuId);
	
	/**
	 * 通过菜单名模糊查询菜单
	 *@param sellerMenuName
	 *@return
	 */
	public List<SellerMenu> getSellerMenusBySellerMenuName(int sellerId ,String menuName);
}
