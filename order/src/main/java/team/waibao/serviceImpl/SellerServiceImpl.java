package team.waibao.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.waibao.dao.OrderMapper;
import team.waibao.dao.SellerMapper;
import team.waibao.dao.SellerMenuMapper;
import team.waibao.entity.DividePageCondition;
import team.waibao.entity.LineSeller;
import team.waibao.entity.Order;
import team.waibao.entity.Pager;
import team.waibao.entity.Seller;
import team.waibao.entity.SellerMenu;
import team.waibao.service.SellerService;


@Service
public class SellerServiceImpl implements SellerService {

	@Resource
	private SellerMapper sellerMapper;
	@Resource
	private OrderMapper orderMapper;
	@Autowired
	private SellerMenuMapper sellerMenuMapper;

	/**
	 * 添加一个商家
	 */
	@Override
	public void addSeller(Seller seller) {
		sellerMapper.addSeller(seller);
	}

	/**
	 * 通过商家的id找到商家的所有信息
	 */
	@Override
	public Seller getSellerInfo(int sellerId) {
		Seller seller = sellerMapper.getSellerBySellerId(sellerId);
		seller.setMenus(sellerMenuMapper.getMenusBySellerId(sellerId));
		seller.setOrders(orderMapper.getOrdersBySellerId(sellerId));
		return seller;
	}

	@Override
	public boolean isContainSellerName(String sellerName) {
		if (sellerMapper.getSellerBySellerName(sellerName) != null)
			return true;
		else
			return false;
	}

	@Override
	public boolean isContainSeller(Seller seller) {
		if (sellerMapper.getSellerBySellerNameAndPassword(seller) != null)
			return true;
		else
			return false;

	}

	/**
	 * 获取指定页面的pager
	 * 
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            页面显示信息的条数
	 * @return
	 */
	@Override
	public Pager<SellerMenu> getSellerMenus(int currentPage, int pageSize,
			String sellerName) {
		if (currentPage < 0)
			throw new RuntimeException("当前的页数不能小于0！");
		DividePageCondition<SellerMenu> condition = new DividePageCondition<SellerMenu>();

		Seller seller = sellerMapper.getSellerBySellerName(sellerName);

		int id = seller.getSellerId();
		int total = sellerMenuMapper.getMenusBySellerId(id).size();

		condition.setId(id);
		condition.setCurrentPage((currentPage - 1) * pageSize);
		condition.setPagesize(pageSize);
		List<SellerMenu> sourceList = sellerMenuMapper
				.getMenusByCondition(condition);
		System.out.println("数组的大小：" + sourceList.size());
		Pager<SellerMenu> sellerMenuPager = new Pager<SellerMenu>(currentPage,
				pageSize, total, sourceList);

		return sellerMenuPager;
	}


	@Override
	public void addMenu(SellerMenu menu) {
         sellerMenuMapper.addMenuToSeller(menu);
	}

	@Override
	public int getIdBySellerName(String sellerName) {
		return sellerMapper.getSellerBySellerName(sellerName).getSellerId();
	}

	@Override
	public Seller getSellerBySellerName(String sellerName) {
		
		return sellerMapper.getSellerBySellerName(sellerName);
	}

	@Override
	public void deleteMenuByMenuId(int id) {
		sellerMenuMapper.deleteMenuByMenuId(id);
	}

	@Override
	public Pager<Order> getSellerOrders(int currentPage, int pageSize,
			String sellerName) {
		if (currentPage < 0)
			throw new RuntimeException("当前的页数不能小于0！");
		DividePageCondition<Order> condition = new DividePageCondition<Order>();

		Seller seller = sellerMapper.getSellerBySellerName(sellerName);

		int id = seller.getSellerId();
		int total = sellerMenuMapper.getMenusBySellerId(id).size();

		condition.setId(id);
		condition.setCurrentPage((currentPage - 1) * pageSize);
		condition.setPagesize(pageSize);
		List<Order> sourceList = orderMapper.getOrdersByCondition(condition);
		System.out.println("数组的大小：" + sourceList.size());
		Pager<Order> orderPager = new Pager<Order>(currentPage,
				pageSize, total, sourceList);
		return orderPager;
	}

	@Override
	public List<LineSeller> getSeller() {
		/**
		 *获取所有的商家
		 */
		List<Seller> sellers = sellerMapper.getSellers();
		List<LineSeller> list = new ArrayList<LineSeller>();
		for(int i = 0;i<sellers.size();){
			  LineSeller lineSeller = new LineSeller();
			  lineSeller.setFirstSeller(sellers.get(i++));
			  if(i == sellers.size()){
				  list.add(lineSeller);
				  break;
			  }
			  lineSeller.setSecondSeller(sellers.get(i++));
			  if(i == sellers.size()){
				  list.add(lineSeller);
				  break;
			  }
			  lineSeller.setThirdSeller(sellers.get(i++));
			  if(i == sellers.size()){
				  list.add(lineSeller);
				  break;
			  }
			  lineSeller.setFourSeller(sellers.get(i++));
			  list.add(lineSeller);
		}
		
		return list;
	}

	@Override
	public List<LineSeller> getSellersByMenuName(String menuName) {
		/**
		 *获取所有的商家
		 */
		List<Integer> ids = sellerMenuMapper.getSellerIdByMenuName(menuName);
		List<Seller> sellers = new ArrayList<Seller>();
		for (int i = 0; i < ids.size(); i++) {
			sellers.add(sellerMapper.getSellerBySellerId(ids.get(i)));
		}
		List<LineSeller> list = new ArrayList<LineSeller>();
		for(int i = 0;i<sellers.size();){
			  LineSeller lineSeller = new LineSeller();
			  lineSeller.setFirstSeller(sellers.get(i++));
			  if(i == sellers.size()){
				  list.add(lineSeller);
				  break;
			  }
			  lineSeller.setSecondSeller(sellers.get(i++));
			  if(i == sellers.size()){
				  list.add(lineSeller);
				  break;
			  }
			  lineSeller.setThirdSeller(sellers.get(i++));
			  if(i == sellers.size()){
				  list.add(lineSeller);
				  break;
			  }
			  lineSeller.setFourSeller(sellers.get(i++));
			  list.add(lineSeller);
		}
		
		return list;
	}

	@Override
	public List<SellerMenu> getSellerMenusBySellerId(int id) {
		
		return sellerMenuMapper.getMenusBySellerId(id);
	}

	@Override
	public void updateSellerInfo(Seller seller) {
		sellerMapper.updateSellerInfo(seller);
		
	}

	@Override
	public List<LineSeller> getSellersByStoreName(String storeName) {
		
		/**
		 *获取所有的商家
		 */
		List<Integer> ids = sellerMapper.getSellersByStoreName(storeName);
		List<Seller> sellers = new ArrayList<Seller>();
		for (int i = 0; i < ids.size(); i++) {
			sellers.add(sellerMapper.getSellerBySellerId(ids.get(i)));
		}
		List<LineSeller> list = new ArrayList<LineSeller>();
		for(int i = 0;i<sellers.size();){
			  LineSeller lineSeller = new LineSeller();
			  lineSeller.setFirstSeller(sellers.get(i++));
			  if(i == sellers.size()){
				  list.add(lineSeller);
				  break;
			  }
			  lineSeller.setSecondSeller(sellers.get(i++));
			  if(i == sellers.size()){
				  list.add(lineSeller);
				  break;
			  }
			  lineSeller.setThirdSeller(sellers.get(i++));
			  if(i == sellers.size()){
				  list.add(lineSeller);
				  break;
			  }
			  lineSeller.setFourSeller(sellers.get(i++));
			  list.add(lineSeller);
		}
		return list;
	}

	@Override
	public List<LineSeller> getSelersByStoreType(String storeType) {
		
		/**
		 *获取所有的商家
		 */
		List<Integer> ids = sellerMapper.getSelersByStoreType(storeType);
		List<Seller> sellers = new ArrayList<Seller>();
		for (int i = 0; i < ids.size(); i++) {
			sellers.add(sellerMapper.getSellerBySellerId(ids.get(i)));
		}
		List<LineSeller> list = new ArrayList<LineSeller>();
		for(int i = 0;i<sellers.size();){
			  LineSeller lineSeller = new LineSeller();
			  lineSeller.setFirstSeller(sellers.get(i++));
			  if(i == sellers.size()){
				  list.add(lineSeller);
				  break;
			  }
			  lineSeller.setSecondSeller(sellers.get(i++));
			  if(i == sellers.size()){
				  list.add(lineSeller);
				  break;
			  }
			  lineSeller.setThirdSeller(sellers.get(i++));
			  if(i == sellers.size()){
				  list.add(lineSeller);
				  break;
			  }
			  lineSeller.setFourSeller(sellers.get(i++));
			  list.add(lineSeller);
		}
		return list;
	}

	@Override
	public void addMoneyForSeller(int sellerId, double recruitment) {
		
		Seller seller = getSellerInfo(sellerId);
		seller.addBlance(recruitment);
		sellerMapper.updateSellerBlance(seller);
		
	}

	@Override
	public void reduceMoneyForSeller(int sellerId, double decrement) {
		Seller seller = getSellerInfo(sellerId);
		seller.reduceBlance(decrement);
		sellerMapper.updateSellerBlance(seller);
		
	}
}
