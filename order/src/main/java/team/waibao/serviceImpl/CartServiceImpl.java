package team.waibao.serviceImpl;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.waibao.dao.CartMapper;
import team.waibao.dao.CartMenuMapper;
import team.waibao.dao.UserMapper;
import team.waibao.entity.Cart;
import team.waibao.entity.CartMenu;
import team.waibao.service.CartService;



@Service
public class CartServiceImpl implements  CartService{

	@Resource
	private UserMapper userMapper;
	@Autowired
	private CartMapper cartMapper;
	
    @Autowired
    private CartMenuMapper cartMenuMapper;



	@Override
	public Cart getCartByUserId(int userId) {
	
		return cartMapper.getCartByUserId(userId);
	}

	@Override
	public void addCartToUserId(int userId) {
		cartMapper.addUserIdToCart(userId);
	}

	@Override
	public List<CartMenu> getCartMenuByUserName(String userName) {
		int userId = userMapper.findIdByUserName(userName);
		int cartId = cartMapper.getCartByUserId(userId).getCartId();
		return cartMenuMapper.getCartMenusByCartId(cartId);
	}

	@Override
	public List<Integer> getCartMenuIdByUserName(String userName){
		List<CartMenu> menus = getCartMenuByUserName(userName);
		List<Integer> menuIds = new ArrayList<Integer>();
		for (CartMenu menu : menus) {
			menuIds.add(menu.getId());
		}
		return menuIds;
	}
	
}
