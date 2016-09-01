package team.waibao.entity;

import java.io.Serializable;
/**
 * 代表一行的商铺
* @author 曾志鹏
* @version 创建时间：2016年8月25日 下午3:08:22
* 默认一行显示4个商铺
 */
public class LineSeller implements Serializable{

	private static final long serialVersionUID = 6229050088485866453L;
	private Seller firstSeller;
	private Seller secondSeller;
	private Seller thirdSeller;
	private Seller fourSeller;
	public Seller getFirstSeller() {
		return firstSeller;
	}
	public void setFirstSeller(Seller firstSeller) {
		this.firstSeller = firstSeller;
	}
	public Seller getSecondSeller() {
		return secondSeller;
	}
	public void setSecondSeller(Seller secondSeller) {
		this.secondSeller = secondSeller;
	}
	public Seller getThirdSeller() {
		return thirdSeller;
	}
	public void setThirdSeller(Seller thirdSeller) {
		this.thirdSeller = thirdSeller;
	}
	public Seller getFourSeller() {
		return fourSeller;
	}
	public void setFourSeller(Seller fourSeller) {
		this.fourSeller = fourSeller;
	}
	public LineSeller(Seller firstSeller, Seller secondSeller,
			Seller thirdSeller, Seller fourSeller) {
		super();
		this.firstSeller = firstSeller;
		this.secondSeller = secondSeller;
		this.thirdSeller = thirdSeller;
		this.fourSeller = fourSeller;
	}
	public LineSeller(){
		
	}
	
}
