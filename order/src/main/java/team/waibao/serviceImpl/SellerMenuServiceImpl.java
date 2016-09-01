package team.waibao.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.waibao.dao.SellerMenuMapper;
import team.waibao.entity.Seller;
import team.waibao.entity.SellerMenu;
import team.waibao.service.SellerMenuService;

@Service
public class SellerMenuServiceImpl  implements SellerMenuService{

	@Autowired
	private SellerMenuMapper sellerMenuMapper;
	
	
	@Override
	public SellerMenu getSellerMenuBySellerMenuId(int sellerMenuId) {
		return sellerMenuMapper.getSellerMenuBySellerMenuId(sellerMenuId); 
	}


	@Override
	public List<SellerMenu> getSellerMenusBySellerMenuName(int sellerId,
			String menuName) {
		
		SellerMenu menu = new SellerMenu();
		Seller seller = new Seller();
		seller.setSellerId(sellerId);
		menu.setSeller(seller);
		menu.setMenuName(menuName);
		return sellerMenuMapper.getSellerMenusBySellerMenuName(menu);
	}

}
