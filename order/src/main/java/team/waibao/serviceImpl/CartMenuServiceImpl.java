package team.waibao.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.waibao.dao.CartMenuMapper;
import team.waibao.entity.CartMenu;
import team.waibao.service.CartMenuService;


@Service
public class CartMenuServiceImpl implements CartMenuService {

	@Autowired
	private CartMenuMapper cartMenuMapper;
	@Override
	public void addCartMenuToCart(CartMenu cartMenu) {
		
		cartMenuMapper.addMenuToCart(cartMenu);
	}
	@Override
	public void updateMenuAddOneAccountFromCart(CartMenu menu) {
		
		cartMenuMapper.updateMenuAccountFromCart(menu);
		
	}
	@Override
	public boolean isContainCartMenu(CartMenu menu) {
		
		return cartMenuMapper.isContainCartMenu(menu) != null;
	}
	@Override
	public List<CartMenu> getCartMenusByCartId(int cartId) {
	
		return cartMenuMapper.getCartMenusByCartId(cartId);
	}
	@Override
	public CartMenu getCartMenuByCartMenuId(int cartMenuId) {
		return cartMenuMapper.getCartMenuByCartMenuId(cartMenuId);
	}
	@Override
	public void deleteCartMenuByCartMenuId(int cartMenuId) {
		
		cartMenuMapper.deleteCartMenuByCartMenuId(cartMenuId);
		
	}

}
