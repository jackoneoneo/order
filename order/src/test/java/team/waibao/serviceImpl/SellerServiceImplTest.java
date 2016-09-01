package team.waibao.serviceImpl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import team.waibao.entity.Pager;
import team.waibao.entity.SellerMenu;
import team.waibao.service.SellerService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/config/applicationContext.xml" })
public class SellerServiceImplTest {

	@Autowired
	private SellerService sellerService;
	@Test
	public void getSellerMenusTest() {
		Pager<SellerMenu> pager = sellerService.getSellerMenus(1, 10, "曾志鹏");
		for (SellerMenu  menu : pager.getDataList()) {
			System.out.println(menu);
		}
	}

}
