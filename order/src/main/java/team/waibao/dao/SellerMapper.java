package team.waibao.dao;

import java.util.List;

import team.waibao.entity.Seller;
import team.waibao.entity.User;




/**
* 商家的操作接口
* @author 曾志鹏
* @version 创建时间：2016年8月17日 下午3:07:15
*
*/
public interface SellerMapper {

	/**
	 * 添加一个商家
	 *@param user 要添加的商家
	 */
	public void addSeller(Seller seller);
	
    /**
     * 通过商家id找到一个商家的一些信息
     *@param sellerId 商家的Id
     *@return
     */
	public Seller getSellerBySellerId(int sellerId);
	
	/**
	 * 通过一个商家名获取一个商家对象
	 *@param sellerName 商家名
	 *@return
	 */
	public Seller getSellerBySellerName(String sellerName);
	
	/**
	 * 通过一个商家名与商家密码来找到一个商家对象
	 *@param seller 寻找找的条件
	 *@return
	 */
	public Seller getSellerBySellerNameAndPassword(Seller seller);
	
	/**
	 * 获取所有的商家
	 *@return
	 */
	public List<Seller> getSellers();
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
	public List<Integer> getSellersByStoreName(String storeName);
	/**
	 * 通过类型找到商家
	 *@param storeType
	 *@return
	 */
	public List<Integer> getSelersByStoreType(String storeType);
	
	/**
	 * 给指定商家变动金额
	 *@param recruitment
	 *@param 商家
	 *@return
	 */
	public void updateSellerBlance(Seller seller);

	}
