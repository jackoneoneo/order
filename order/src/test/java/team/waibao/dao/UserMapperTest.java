package team.waibao.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import team.waibao.entity.User;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/config/applicationContext.xml" })
public class UserMapperTest {

	@Autowired
	private UserMapper userMapper;
	@Test
	public void findUserByUserNameAndPasswordTest() {
		User user = new User("1", "23");
		
		User user1  = userMapper.findUserByUserNameAndPassword(user);
		System.out.println("----------------------------------");
		System.out.println(user1);
		System.out.println("-----------------------------------");
	}
	@Test
	public void findUserByUserNameAndPasswordTest1() {
		
		
		User user1  = userMapper.findUserByUserName("dsfdsfdsfdsf");
		System.out.println("----------------------------------");
		System.out.println(user1);
		System.out.println("-----------------------------------");
	}
}
