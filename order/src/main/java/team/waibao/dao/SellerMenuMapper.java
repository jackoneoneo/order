package team.waibao.dao;



import java.util.List;

import team.waibao.entity.DividePageCondition;
import team.waibao.entity.SellerMenu;

public interface SellerMenuMapper {


	/**
	 * 添加商品到商店菜谱
	 *@param menu 菜单
	 */
	public void addMenuToSeller(SellerMenu menu);
	/**
	 * 在商店菜谱里删除指定的菜单
	 *@param menu 菜单
	 */
	public void deleteMenuFromSeller(SellerMenu menu);
	
	/**
	 * 通过商家的id找到商家所有的菜单
	 *@param sellerId
	 *@return
	 */
	public List<SellerMenu> getMenusBySellerId(int sellerId);
	
	/**
	 * 通过条条件来查找商家的菜单
	 *@return
	 */
	public List<SellerMenu> getMenusByCondition(DividePageCondition<SellerMenu> condition);
	
	/**
	 * 通过菜单id 删除菜单
	 *@param menuId 菜单的id
	 */
	public void deleteMenuByMenuId(int menuId);
	

	/**
	 * 通过菜单名找到所有的菜单
	 *@param menuName
	 *@return
	 */
	public List<Integer>  getSellerIdByMenuName(String menuName);
	
	/**
	 * 通过sellerMenuId 找到该商平
	 *@param sellerMenuId 商品 的id
	 *@return
	 */
	public SellerMenu getSellerMenuBySellerMenuId(int sellerMenuId);
	/**
	 * 通过菜单名模糊查询菜单
	 *@param sellerMenuName
	 *@return
	 */
	public List<SellerMenu> getSellerMenusBySellerMenuName(SellerMenu menu);

}
