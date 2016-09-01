package team.waibao.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import team.waibao.entity.Seller;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/config/applicationContext.xml" })
public class SellerMapperTest {

	@Autowired
	private SellerMapper sellerMapper;
	@Test
	public void getSellerBySellerNameTest() {
		Seller seller = sellerMapper.getSellerBySellerName("曾志鹏");
		System.out.println("-----------------------------------");
		System.out.println(seller.getSellerId());
	}
	@Test
	public void getSellerBySellerNameAndPasswordTest() {
		Seller seller = sellerMapper.getSellerBySellerNameAndPassword(new Seller("曾志鹏" ,"123456"));
		System.out.println("-----------------------------------");
		System.out.println(seller);
	}
	
	@Test
	public void getSellerByIdTest() {
		Seller seller = sellerMapper.getSellerBySellerNameAndPassword(new Seller("曾志鹏" ,"123456"));
		System.out.println("-----------------------------------");
		System.out.println(seller);
	}
}
