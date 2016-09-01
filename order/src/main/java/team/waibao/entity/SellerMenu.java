package team.waibao.entity;
/**
 * 商家的菜单
* @author 曾志鹏
* @version 创建时间：2016年8月18日 上午10:24:28
*
 */
public class SellerMenu extends Menu {

	private static final long serialVersionUID = 7207699054633451540L;
	
	private int id;
	private Seller seller;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	@Override
	public String toString() {
		return super.toString()+"SellerMenu [id=" + id + ", seller=" + seller + "]";
	}
	
	

}
