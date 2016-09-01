package team.waibao.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import team.waibao.dao.UserMapper;
import team.waibao.entity.Order;
import team.waibao.entity.User;
import team.waibao.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	
	
	@Override
	public void addUser(User user) {
		userMapper.addUser(user);
	}

	@Override
	public List<User> findUsers(User searchingCondition) {
		return userMapper.findUsers(searchingCondition);
	}

	@Override
	public List<Order> findOrdersByUserName(String userName) {
		
		return userMapper.findUserByUserName(userName).getOrders();
	}

	@Override
	public void addMoneyForUser(String userName, double recruitment) {
		User user = userMapper.findUserByUserName(userName);
		user.addUserAccount(recruitment);
		userMapper.updateUserAccount(user);
	}

	@Override
	public void reduceMoneyForUser(String userName, double decrement) {
		User user = userMapper.findUserByUserName(userName);
		user.reduceUserAccount(decrement);
		userMapper.updateUserAccount(user);
	}

	@Override
	public boolean isContainUser(User user) {
		if(userMapper.findUserByUserNameAndPassword(user) == null)
		     return false;
		else
			return true;
	}

	@Override
	public boolean isContainUserName(String userName) {
		if(userMapper.findUserByUserName(userName) != null)
		return true;
		else
			return false;
	}

	@Override
	public int getIdByUserName(String userName) {
		return userMapper.findIdByUserName(userName);
	}

	@Override
	public double getUserAccountByUserId(int userId) {
		
		return userMapper.getUserAccountByUserId(userId);
	}

}
