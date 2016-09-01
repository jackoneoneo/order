package team.waibao.dao;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import team.waibao.entity.Cart;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/config/applicationContext.xml" })
public class CartMapperTest {

	@Autowired
	private CartMapper cartMapper;
	@Test
	public void getCartByUserIdTest() {
		Cart cart = cartMapper.getCartByUserId(33);
		System.out.println("======================"+cart);
	}

}
