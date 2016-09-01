package team.waibao.entity;

import java.io.Serializable;

import java.util.Arrays;



/**
 * 菜单类
* @author 曾志鹏
* @version 创建时间：2016年8月16日 下午11:33:47
*
 */
public class Menu  implements Serializable{
	
	private static final long serialVersionUID = -3431006211667215388L;
	
    protected  String menuImage ;//菜的图片
    protected double menuPrice;//菜的价格
    protected String menuName;//菜名
	
	public String getMenuImage() {
		return menuImage;
	}
	public void setMenuImage(String menuImage) {
		this.menuImage = menuImage;
	}
	public double getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(double menuPrice) {
		this.menuPrice = menuPrice;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public Menu(String menuImage, double menuPrice, String menuName) {
		super();
		this.menuImage = menuImage;
		this.menuPrice = menuPrice;
		this.menuName = menuName;
	}
	public Menu() {
	}
	@Override
	public String toString() {
		return "Menu [ menuImage="
				+ menuImage + ", menuPrice=" + menuPrice
				+ ", menuName=" + menuName ;
	}

	

	
	
	
}
