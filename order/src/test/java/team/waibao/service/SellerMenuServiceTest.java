package team.waibao.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import team.waibao.dao.SellerMenuMapper;
import team.waibao.entity.SellerMenu;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/config/applicationContext.xml" })
public class SellerMenuServiceTest {
	@Autowired
	private SellerMenuMapper sellerMenuMapper;
	@Test
	public void getSellerMenuBySellerMenuIdTest() {
		SellerMenu sellerMenu = sellerMenuMapper.getSellerMenuBySellerMenuId(42);
		System.out.println("============================="+sellerMenu);
	}

}
