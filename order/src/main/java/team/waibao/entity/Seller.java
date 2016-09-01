package team.waibao.entity;

import java.io.Serializable;
import java.util.List;



/**
 * 商家表
* @author 曾志鹏
* @version 创建时间：2016年8月16日 下午11:49:49
*
 */
public class Seller implements Serializable {

	
	private static final long serialVersionUID = -523922185741733252L;
	
	private String password;//商家密码
	private int sellerNagetiveAccount;
	private int sellerPositiveAccount;
	private String sellerLogo;
	private String sellerAddress;
	private String storeName;
	private String name;
	private int sellerId;
	private List<Order> orders;
	private List<SellerMenu> menus;
	private double balance;
	private String storeType;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSellerNagetiveAccount() {
		return sellerNagetiveAccount;
	}
	public void setSellerNagetiveAccount(int sellerNagetiveAccount) {
		this.sellerNagetiveAccount = sellerNagetiveAccount;
	}
	public int getSellerPositiveAccount() {
		return sellerPositiveAccount;
	}
	public void setSellerPositiveAccount(int sellerPositiveAccount) {
		this.sellerPositiveAccount = sellerPositiveAccount;
	}
	public String getSellerLogo() {
		return sellerLogo;
	}
	public void setSellerLogo( String sellerLogo) {
		this.sellerLogo = sellerLogo;
	}
	public String getSellerAddress() {
		return sellerAddress;
	}
	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public List<SellerMenu> getMenus() {
		return menus;
	}
	public void setMenus(List<SellerMenu> menus) {
		this.menus = menus;
	}
	@Override
	public String toString() {
		return "Seller [password=" + password + ", sellerNagetiveAccount="
				+ sellerNagetiveAccount + ", sellerPositiveAccount="
				+ sellerPositiveAccount + ", sellerLogo=" + sellerLogo
				+ ", sellerAddress=" + sellerAddress + ", name=" + name
				+ ", sellerId=" + sellerId + ", orders=" + orders + ", menus="
				+ menus + "]";
	}
	public Seller() {

	}
	public Seller(String sellerName, String password) {
		this.name = sellerName;
		this.password = password;
	}
	public Seller(int sellerId) {
		this.sellerId = sellerId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreType() {
		return storeType;
	}
	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	/**
	 * 添加钱
	 */
	public synchronized void addBlance(double decrement){
		if(decrement < 0)
			throw new RuntimeException("不能小于0！");
		this.balance += decrement;
	}
	/**
	 * 减少钱
	 */
	public synchronized void reduceBlance(double decrement){
		if(decrement > this.balance)
			throw new RuntimeException("余额不足！");
		   this.balance -= decrement;
	}
}
