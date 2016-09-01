package team.waibao.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import team.waibao.entity.DividePageCondition;
import team.waibao.entity.SellerMenu;
import team.waibao.util.ImgUtil;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/config/applicationContext.xml" })
public class SellerMenuMapperTest {

	@Autowired
	private SellerMenuMapper sellerMenuMapper;
	@Test
	public void getMenusByConditionTest() {
	   DividePageCondition<SellerMenu> condition = new DividePageCondition<SellerMenu>();
	   condition.setId(1);
	   condition.setCurrentPage(0);
	   List<SellerMenu> menus = sellerMenuMapper.getMenusByCondition(condition);
	   
	}

	@Test
	public void getSellerIdByMenuNameTest() {
	  
		List<Integer> ids = sellerMenuMapper.getSellerIdByMenuName("红烧");
		System.out.println("--------------------------------------------");
		
		System.out.println(ids.size());
		System.out.println("--------------------------------------------");

	}
	

}
