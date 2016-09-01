package team.waibao.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;



import team.waibao.util.UserStatus;
/**
 * 用户类
* @author 曾志鹏
* @version 创建时间：2016年8月16日 下午11:54:39
*
 */
public class User implements Serializable {

	private static final long serialVersionUID = 5126688350992601928L;
	
	private int type;//用户的类型
	private String address;//用户地址
	private String phoneTel;//用户电话
	private double userAccount;//余额
	private byte[] userImage;//用户头像
	private int userStatus = UserStatus.OPEN;//用户状态
	private String password;//用户密码
	private String userName;//用户名
	private int userId;
	private String gender; //性别
	private List<Order> orders; //持有的订单
	
	private Cart cart;//购物车
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneTel() {
		return phoneTel;
	}
	public void setPhoneTel(String phoneTel) {
		this.phoneTel = phoneTel;
	}
	public double getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(double userAccount) {
		this.userAccount = userAccount;
	}
	public byte[] getUserImage() {
		return userImage;
	}
	public void setUserImage(byte[] userImage) {
		this.userImage = userImage;
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUseId() {
		return userId;
	}
	public void setUseId(int userId) {
		this.userId = userId;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	/**
	 * 给用户添加余额
	 *@param recruitment 添加的余额数
	 */
	public synchronized void addUserAccount(double recruitment){
		if(recruitment < 0)
			throw new RuntimeException("添加的余额不能小于0");
		this.userAccount += recruitment;
	}
	/**
	 * 给用户减少余额
	 *@param decrement 减少的余额数
	 */
	public synchronized void reduceUserAccount(double decrement){
		
		if( decrement > this.userAccount)
			throw new RuntimeException("您的余额不足！");
		this.userAccount -= decrement;
	}
	@Override
	public String toString() {
		return "User [type=" + type + ", address=" + address + ", phoneTel="
				+ phoneTel + ", userAccount=" + userAccount + ", userImage="
				+ Arrays.toString(userImage) + ", userStatus=" + userStatus
				+ ", password=" + password + ", userName=" + userName
				+ ", useId=" + userId + ", gender=" + gender + ", orders="
				+ orders + ", cart=" + cart + "]";
	}
	
	
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public User(){}
	public User(int userId) {
		this.userId = userId;
	}
	

}
