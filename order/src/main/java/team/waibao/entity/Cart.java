package team.waibao.entity;

import java.io.Serializable;
import java.util.List;

public class Cart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5517753848716335541L;
	private User user;
	private int cartId;
	private List<CartMenu> menus;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	
	public List<CartMenu> getMenus() {
		return menus;
	}
	public void setMenus(List<CartMenu> menus) {
		this.menus = menus;
	}
	@Override
	public String toString() {
		return "Cart [user=" + user + ", cartId=" + cartId + ", menus=" + menus
				+ "]";
	}
	public Cart() {
	}
	
	
}
