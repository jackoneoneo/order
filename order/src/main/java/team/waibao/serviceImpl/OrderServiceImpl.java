package team.waibao.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.waibao.dao.OrderMapper;
import team.waibao.entity.Order;
import team.waibao.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;
	@Override
	public void addOrder(Order order) {
		orderMapper.addOrder(order);
	}
	@Override
	public int getCurrentId() {
		if(new Integer(orderMapper.getMaxId()) == null)
			return 1;
		return orderMapper.getMaxId() + 1;
	}
	@Override
	public List<Order> getOrdersByUserId(int userId) {
	
		return orderMapper.getOrdersByUserId(userId);
	}
     
}
