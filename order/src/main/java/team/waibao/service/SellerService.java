package team.waibao.service;

import java.util.List;

import team.waibao.entity.LineSeller;
import team.waibao.entity.Order;
import team.waibao.entity.Pager;
import team.waibao.entity.Seller;
import team.waibao.entity.SellerMenu;

public interface SellerService {

	/**
	 * 添加一个店家 
	 *@param seller 店家
	 */
	public void addSeller(Seller seller);
	/**
	 * 通过商家的id找到商家的所有信息
	 *@param sellerId
	 */
	public Seller getSellerInfo(int sellerId);
	/**
	 * 是否存在指定的商家名
	 *@param sellerName 商家名
	 *@return
	 */
	public boolean isContainSellerName(String sellerName);
	/**
	 * 是否存在指定的商家对象
	 *@param seller 判断的对象
	 *@return
	 */
	public boolean isContainSeller(Seller seller);
	
	/**
	 * 获取指定页面的pager
	 *@param currentPage 当前页
	 *@param pageSize 页面显示信息的条数
	 *@return
	 */
	public Pager<SellerMenu> getSellerMenus(int currentPage,int pageSize ,String sellerName);
	
	/**
	 * 添加菜谱
	 *@param menu 菜谱
	 */
	public void addMenu(SellerMenu menu);
	/**
	 * 通过用户找到用户的id
	 *@param sellerName
	 *@return
	 */
	public int getIdBySellerName(String sellerName);
	
	/**
	 * 
	 *@param sellerName
	 *@return
	 */
	public Seller getSellerBySellerName(String sellerName);
	/**
	 * 通过菜单id 删除菜单
	 *@param menuId 菜单的id
	 */
	public void deleteMenuByMenuId(int id);
	
	
	
	/**
	 * 获取指定页面的pager
	 *@param currentPage 当前页
	 *@param pageSize 页面显示信息的条数
	 *@return
	 */
	public Pager<Order> getSellerOrders(int currentPage,int pageSize ,String sellerName);
	/**
	 * 通过类型找到商家
	 *@param storeType
	 *@return
	 */
	public List<LineSeller> getSelersByStoreType(String storeType);
	/**
	 * 获取所有的商家
	 *@return
	 */
	public List<LineSeller> getSeller();
	
	/**
	 * 通过菜单名找到商家
	 *@param menuName
	 *@return
	 */
	public List<LineSeller> getSellersByMenuName(String menuName);
	
	/**
	 * 获取指定店铺的的菜单名
	 *@param id 商铺id
	 *@return
	 */
	public List<SellerMenu> getSellerMenusBySellerId(int id);
	
	/**
	 *跟新商家的信息
	 *@param seller
	 */
	public void updateSellerInfo(Seller seller);
	
	/**
	 * 通过对商店的模糊查询找到商店
	 *@param storeName
	 *@return
	 */
	public  List<LineSeller> getSellersByStoreName(String storeName);
	
	
	/**
	 * 为指定用户添加金额
	 *@param userName 指定的用户
	 *@param recruitment 增加的金额
	 */
	public void addMoneyForSeller(int sellerId,double  recruitment);
	
	/**
	 * 为指定用户减少金额
	 *@param userName 指定的用户
	 *@param decrement 减少量
	 */
	public void reduceMoneyForSeller(int sellerId,double decrement);
}
