package team.waibao.controll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import team.waibao.dao.SellerMapper;
import team.waibao.entity.Cart;
import team.waibao.entity.CartMenu;
import team.waibao.entity.LineSeller;
import team.waibao.entity.Order;
import team.waibao.entity.OrderMenu;
import team.waibao.entity.Seller;
import team.waibao.entity.SellerMenu;
import team.waibao.entity.User;
import team.waibao.service.CartMenuService;
import team.waibao.service.CartService;
import team.waibao.service.OrderMenuService;
import team.waibao.service.OrderService;
import team.waibao.service.SellerMenuService;
import team.waibao.service.SellerService;
import team.waibao.service.UserService;
import team.waibao.util.StoreType;

/**
 * 
 * @author 曾志鹏
 * @version 创建时间：2016年8月24日 下午5:15:14
 * 
 */


@Controller
@RequestMapping(value="/main")
public class RestaurantControll {

	private  final Logger log = LoggerFactory.getLogger(RestaurantControll.class);
	@Autowired
	private SellerService sellerService;
	
	@Autowired
	private SellerMenuService sellerMenuService;
	
	@Autowired
	private UserService userService;
	@Autowired
	private OrderMenuService orderMenuService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CartMenuService cartMenuService;
	
	@Autowired
	private OrderService orderService;
	
	
	@RequestMapping(value="/mainPage.do")
	public ModelAndView mainPage(){
		List<LineSeller> list = sellerService.getSeller();
		ModelAndView view = new ModelAndView();
		view.setViewName("main_page");
		view.addObject("sellerList", list);
		return view;
	}
	/**
	 * 查找店面
	 *@param request
	 *@return
	 */
	@RequestMapping(value="/searchStore.do")
	public ModelAndView  conditionPage(HttpServletRequest request){
		String storeName = request.getParameter("storeName");
		List<LineSeller> list  = null;
		if(!"".equals(storeName.trim()))
	          list = sellerService.getSellersByStoreName(storeName);
		ModelAndView view = new ModelAndView();
		view.setViewName("main_page");
		view.addObject("sellerList", list);
		return view;
	}
	
	@RequestMapping(value="/getStore/{sellerId}.do")
	public ModelAndView getStore(@PathVariable int sellerId){
		List<SellerMenu> menus = sellerService.getSellerMenusBySellerId(sellerId);
		ModelAndView view = new ModelAndView();
		view.setViewName("shop_page");
		view.addObject("sellerMenus", menus);
		view.addObject("sellerId", sellerId);
		return view;
	}
	
	@RequestMapping(value="/getSearchConditionMenu/{sellerId}.do")
	public ModelAndView getSearchConditionMenu(@PathVariable int sellerId,HttpServletRequest request){
		String menuName = request.getParameter("menuName");
		List<SellerMenu> menus = sellerMenuService.getSellerMenusBySellerMenuName(sellerId, menuName);
		if("".equals(menuName.trim()))
			menus = null;
		ModelAndView view = new ModelAndView();
		view.setViewName("shop_page");
		view.addObject("sellerMenus", menus);
		view.addObject("sellerId", sellerId);
		return view;
	}

	@RequestMapping(value="/cart.do")
	public ModelAndView cart(HttpServletRequest request){
		String userName  = (String) request.getSession().getAttribute("userName");
		List<CartMenu> menus = cartService.getCartMenuByUserName(userName);
		ModelAndView view = new ModelAndView();
		view.setViewName("cart");
		view.addObject("menus", menus);
		return view;
	}
	/**
	 * 添加商品到购物车
	 *@param sellerId 商店的id
	 *@param sellerMenuId 商品 的id
	 *@return
	 */
	@RequestMapping(value="/saveCart/{sellerId}/{sellerMenuId}.do")
	public ModelAndView saveCart(@PathVariable int sellerId,@PathVariable int sellerMenuId,HttpServletRequest request){
		String userName =  (String) request.getSession().getAttribute("userName");
		log.error("==========================用户名" +userName );
		//创建购物车
		int userId = userService.getIdByUserName(userName);
		log.error("==========================用户id" +userId );
		Cart cart = cartService.getCartByUserId(userId);
		if(cart == null){
			//给用户添加一个购物车
			cartService.addCartToUserId(userId);
		}
		SellerMenu sellerMenu = sellerMenuService.getSellerMenuBySellerMenuId(sellerMenuId);
		
		CartMenu cartMenu = new CartMenu(sellerMenu);
		
		cartMenu.setCart(cart);
		cartMenu.setSellerId(sellerId);
		if(cartMenuService.isContainCartMenu(cartMenu)){
			cartMenuService.updateMenuAddOneAccountFromCart(cartMenu);
		}else{
			cartMenuService.addCartMenuToCart(cartMenu);
		}
		
		
		List<SellerMenu> menus = sellerService.getSellerMenusBySellerId(sellerId);
		ModelAndView view = new ModelAndView();
		view.setViewName("shop_page");
		view.addObject("sellerMenus", menus);
		view.addObject("sellerId", sellerId);
		return view;
	}
	@RequestMapping(value="/getTypeStore/{typeId}.do")
	public ModelAndView getTypeStore(@PathVariable int typeId){
		String storeType = StoreType.getStoreType(typeId);
		
		List<LineSeller>  list = sellerService.getSelersByStoreType(storeType);
		ModelAndView view = new ModelAndView();
		view.setViewName("main_page");
		view.addObject("sellerList", list);
		return view;
	}
	
	@RequestMapping(value="/getOrder.do")
	public String getOrder(HttpServletRequest request){
		String userName = (String) request.getSession().getAttribute("userName");
		//用户id
		int userId = userService.getIdByUserName(userName);
		/**
		 * 获取用户选择的菜单id
		 */
		String[]  ids = request.getParameterValues("checkBox"); 
		List<Integer> idList = new ArrayList<Integer>();
		for(int i =0;i<ids.length;i++){
			idList.add(Integer.parseInt(ids[i]));
		}
		
		/**
		 * 获取菜单的数量
		 */
		String[] accounts = request.getParameterValues("account");
		List<Integer> accountList = new ArrayList<Integer>();
		for(int i =0;i<accounts.length;i++){
			accountList.add(Integer.parseInt(accounts[i]));
		}
		
		/**
		 * 实现菜单号与数量挂钩
		 */
	    List<Integer> menusId = cartService.getCartMenuIdByUserName((String) request.getSession().getAttribute("userName"));
	    Map<Integer,Integer> map = new HashMap<Integer, Integer>();
	    for(int j=0;j<accountList.size();j++){
	    	map.put(menusId.get(j), accountList.get(j));
	    }
	    /**
	     * 订单需要花费的金额
	     */
	    double totalMoney =0;
	    for(Integer id:idList){
	    	CartMenu menu = cartMenuService.getCartMenuByCartMenuId(id);
	    	totalMoney+=menu.getMenuPrice() * map.get(id);
	    }
	    request.getSession().setAttribute("totalMoney", totalMoney);
	    //判断用户是否有足够的钱
	    if(totalMoney>userService.getUserAccountByUserId(userId)){
	    	return "payFailure";
	    }
	    /**
	     * 购买物品
	     */
	    for (Integer id : idList) {
			CartMenu menu = cartMenuService.getCartMenuByCartMenuId(id);
			/**
			 * 产生订单
			 */
			Order order = new Order();
			
			//商家id
			int sellerId = menu.getSellerId();
			/**
			 * 产生订单
			 */
			order.setUser(new User(userId));
		    order.setSeller(new Seller(sellerId));
		    int currentOrderId = orderService.getCurrentId();
		    order.setOrderId(currentOrderId);
		    double accountPrice = menu.getMenuPrice() * map.get(id);
		    //给用户扣钱
		    userService.reduceMoneyForUser(userName, accountPrice);
		    //给商家添加钱
		    sellerService.addMoneyForSeller(sellerId, accountPrice);
		    order.setOrderPrice(accountPrice);
		    orderService.addOrder(order);
		    
		    /**
		     * 产生订单菜单
		     */
		    OrderMenu orderMenu = new OrderMenu();
		    orderMenu.setAmount(map.get(id));
		    orderMenu.setOrder(order);
		    orderMenu.setMenuImage(menu.getMenuImage());
		    orderMenu.setMenuName(menu.getMenuName());
		    orderMenu.setMenuPrice(menu.getMenuPrice());
		    orderMenuService.addMenuToOrder(orderMenu);
			
		    /**
		     * 删除购物车里面的东西
		     */
		    cartMenuService.deleteCartMenuByCartMenuId(id);
		}
	
		return "paySucceed";
	}
	/**
	 * 删除购物车车里的东西
	 *@return
	 */
	@RequestMapping(value="/deleteCartMenu/{cartMenuId}.do")
	public String deleteCartMenu(@PathVariable int cartMenuId){
		cartMenuService.deleteCartMenuByCartMenuId(cartMenuId);
		return "redirect:/main/cart.do";
	}
	@RequestMapping(value="/userOrder.do")
	public ModelAndView userOrder(HttpServletRequest request){
		String userName = (String) request.getSession().getAttribute("userName");
		//用户的id
		int userId = userService.getIdByUserName(userName);
		User user = new User();
		user.setUseId(userId);
		user.setUserName(userName);
		List<Order> orders = orderService.getOrdersByUserId(userId);
		for(int i =0;i<orders.size();i++){
			orders.get(i).setMenus(orderMenuService.getOrderMenusByOrderId(orders.get(i).getOrderId()));
	        orders.get(i).setSeller(sellerService.getSellerInfo(orders.get(i).getSeller().getSellerId()));	
		}
		user.setOrders(orders);
		ModelAndView view = new ModelAndView();
		view.addObject("orders", orders);
		view.setViewName("userOrder");
		return view;
	}
}
