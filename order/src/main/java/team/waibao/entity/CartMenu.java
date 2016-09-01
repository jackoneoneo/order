package team.waibao.entity;




/**
 * 购物车里的东西
* @author 曾志鹏
* @version 创建时间：2016年8月18日 上午10:12:04
*
 */
public class CartMenu extends Menu {

	private static final long serialVersionUID = -2851628754164430873L;
	private  int id;
	private Cart cart;
	private int amount;
	private int sellerId;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		if(amount < 0)
			throw new RuntimeException("购物车东西的数量不能小于0！");
		this.amount = amount;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return super.toString() +" , id=" + id + ", cart=" + cart + ", amount=" + amount
				+ "]";
	}

	public CartMenu()  {
	}
	
   public CartMenu(SellerMenu sellerMenu) {
		this.menuImage = sellerMenu.menuImage;
		this.menuName = sellerMenu.menuName;
		this.menuPrice = sellerMenu.menuPrice;
	}

public static void main(String[] args) {
	 CartMenu cartMenu = new CartMenu();
	cartMenu.setMenuName("zdfdfdfds");
	 System.out.println(cartMenu);
}

public int getSellerId() {
	return sellerId;
}

public void setSellerId(int sellerId) {
	this.sellerId = sellerId;
}
}
