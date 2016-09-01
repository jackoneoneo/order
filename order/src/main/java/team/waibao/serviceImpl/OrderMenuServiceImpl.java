package team.waibao.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.waibao.dao.OrderMenuMapper;
import team.waibao.entity.OrderMenu;
import team.waibao.service.OrderMenuService;

@Service
public class OrderMenuServiceImpl implements OrderMenuService {

	@Autowired
	private OrderMenuMapper orderMenuMapper;
	@Override
	public void addMenuToOrder(OrderMenu menu) {
		orderMenuMapper.addMenuToOrder(menu);
	}
	@Override
	public List<OrderMenu> getOrderMenusByOrderId(int OrderId) {
		
		return orderMenuMapper.getOrderMenusByOrderId(OrderId);
	}

}
