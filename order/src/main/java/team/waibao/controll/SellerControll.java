package team.waibao.controll;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import team.waibao.dao.SellerMapper;
import team.waibao.entity.Order;
import team.waibao.entity.Pager;
import team.waibao.entity.Seller;
import team.waibao.entity.SellerMenu;
import team.waibao.service.SellerService;
import team.waibao.util.RandomImage;
import team.waibao.util.StoreType;

@RequestMapping(value = "/seller")
@Controller
public class SellerControll {

	// private static final String[] fileSuffix = {"png","jpg"};
	@Autowired
	private SellerService sellerService;

	private Logger log = LoggerFactory.getLogger(SellerControll.class);

	@RequestMapping(value = "sellerLogin.do")
	public String sellerLogin() {
		return "seller_login";
	}
	
	@RequestMapping(value="/sellerRegister.do")
	public String sellerRegister(){
		return "seller_Register";
	}

	@RequestMapping(value = "/addSeller.do")
	public String addSeller(HttpServletRequest request) {
		
        String sellerName= request.getParameter("name");
        String password = request.getParameter("password");
        String address = request.getParameter("sellerAddress");
        Seller seller = new Seller();
        seller.setName(sellerName);
        seller.setPassword(password);
        seller.setSellerAddress(address);
        sellerService.addSeller(seller);
		return "seller_login";
	}

	@RequestMapping(value = "/checkSeller.do", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String checkUser(HttpServletRequest request,
			HttpServletResponse response) {

		String sellerName = request.getParameter("sellerName");
		String password = request.getParameter("password");
		String code = request.getParameter("code");

		Seller seller = new Seller(sellerName, password);

		boolean isTrueValidNumber = code.equalsIgnoreCase((String) request
				.getSession().getAttribute("sellerCode"));
		// 登陆成功跳转到首页
		if (sellerService.isContainSeller(seller) && isTrueValidNumber) {
			request.getSession().setAttribute("sellerName", sellerName);
			return "redirect:background.do";
		} else {
			// 跳转到登陆界面
			return "redirect:sellerLogin.do";
		}
	}

	@RequestMapping(value = "/index.do")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/validNumber.do")
	public void getRandomCode(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		System.out.println("-------------------------");
		// 设置响应的类型格式为图片格式
		response.setContentType("image/jpeg");
		// 禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		RandomImage instance = new RandomImage();

		HttpSession session = request.getSession(true);
		session.setAttribute("sellerCode", instance.getCode());
		System.out.println("now code is+" + instance.getCode() + "");
		instance.write(response.getOutputStream());

	};

	/**
	 * 验证商家名
	 * 
	 */
	@RequestMapping(value = "/checkSellerName.do")
	public void checkUserName(HttpServletRequest request,
			HttpServletResponse response) {
		String sellerName = request.getParameter("sellerName");
		System.out.println(sellerName);
		if (!sellerService.isContainSellerName(sellerName)) {
			try {
				response.getWriter().write("false");
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

	/**
	 * 验证密码是否正确
	 * 
	 * @param
	 * @throws IOException
	 */
	@RequestMapping(value = "/checkSellerPassword.do")
	public void checkUserPassword(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String sellerName = request.getParameter("sellerName");

		String password = request.getParameter("password");
		if (sellerService.isContainSellerName(sellerName)) {
			if (!sellerService
					.isContainSeller(new Seller(sellerName, password))) {
				response.getWriter().write("false");
			}
		}

	}

	/**
	 * 验证验证码
	 * 
	 * 
	 */
	@RequestMapping(value = "/checkSellerValidNumber.do")
	public void checkUserValidNumber(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String code = (String) request.getSession().getAttribute("sellerCode");
		System.out.println("code:" + code);
		String sellerCode = request.getParameter("code");
		System.out.println("sellerCode:" + sellerCode);
		if (!code.equalsIgnoreCase(sellerCode)) {
			response.getWriter().write("false");
		}

	}

	@RequestMapping(value = "/background.do")
	public String background() {
		return "background";
	}

	// "redic:seller/de/foodlist/1.do"
	@RequestMapping(value = "/foodList/{currentPage}.do")
	public ModelAndView foodList(@PathVariable int currentPage,
			HttpServletRequest request) {
		String sellerName = (String) request.getSession().getAttribute(
				"sellerName");
		Pager<SellerMenu> pager = sellerService.getSellerMenus(currentPage, 10,
				sellerName);
		System.out.println(pager.getDataList().size());
		ModelAndView view = new ModelAndView();

		view.setViewName("foodlist");

		view.addObject("pager", pager);
		return view;
	}

	@RequestMapping(value = "/orderList/{currentPage}.do")
	public ModelAndView orderList(@PathVariable int currentPage,
			HttpServletRequest request) {
		String sellerName = (String) request.getSession().getAttribute(
				"sellerName");
		Pager<Order> pager = sellerService.getSellerOrders(currentPage, 10,
				sellerName);
		System.out.println(pager.getDataList().size());
		ModelAndView view = new ModelAndView();
		view.setViewName("orderlist");
		view.addObject("pager", pager);
		return view;
	}

	@RequestMapping(value = "/saveFood.do")
	public String saveFood() {
		return "savefood";
	}

	@RequestMapping(value = "/addMenu.do")
	public String addMenu(HttpServletRequest request,
			@RequestParam("file") MultipartFile file)
			throws IllegalStateException, IOException {
		String menuName = request.getParameter("menuName");
		double menuPrice = Double
				.parseDouble(request.getParameter("menuPrice"));
		Seller seller = sellerService.getSellerBySellerName((String) request
				.getSession().getAttribute("sellerName"));
		String fileByte = this.upload_file(request, file, "SellerMenuImages");
		SellerMenu menu = new SellerMenu();
		menu.setSeller(seller);
		menu.setMenuImage(fileByte);
		menu.setMenuName(menuName);
		menu.setMenuPrice(menuPrice);
		sellerService.addMenu(menu);
		return "redirect:foodList/1.do";
	}

	/**
	 * 保存图片
	 * 
	 * @param request
	 * @param file
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public String upload_file(HttpServletRequest request,
			@RequestParam("file") MultipartFile file, String relativePath)
			throws IllegalStateException, IOException {
		if (file != null) {

			String filepath = "D:\\java代码\\MyCode\\order\\src\\main\\webapp\\"
					+ relativePath + "\\" + file.getOriginalFilename();
			System.out.println("++++++++++++++++++" + filepath);
			file.transferTo(new File(filepath));
			return relativePath + "/" + file.getOriginalFilename();
		}
		return null;
	}

	// "redirect:foodList/1.do";
	@RequestMapping(value = "/deleteMenu/{id}.do")
	public String deleteMenu(@PathVariable("id") int id,
			HttpServletRequest request) {
		sellerService.deleteMenuByMenuId(id);
		return "redirect:/seller/foodList/1.do";
	}

	@RequestMapping(value = "/updateSellerInfo.do")
	public String updateSellerInfo(HttpServletRequest request,
			@RequestParam("file") MultipartFile file)
			throws IllegalStateException, IOException {
		String sellerName = (String) request.getSession().getAttribute(
				"sellerName");
		String storeName = request.getParameter("storeName");
		String storeType = StoreType.getStoreType(Integer.parseInt(request
				.getParameter("storeType")));
		String sellerLogo = upload_file(request, file, "sellerLogo");
		String sellerAddress = request.getParameter("sellerAddress");

		Seller seller = new Seller();
		seller.setName(sellerName);
		seller.setStoreType(storeType);
		seller.setSellerLogo(sellerLogo);
		seller.setSellerAddress(sellerAddress);
		seller.setStoreName(storeName);

		sellerService.updateSellerInfo(seller);

		return "redirect:background.do";
	}

	@RequestMapping(value = "/updateSeller.do")
	public ModelAndView updateSeller(HttpServletRequest request) {
		String sellerName = (String) request.getSession().getAttribute(
				"sellerName");

		Seller seller = sellerService.getSellerBySellerName(sellerName);

		ModelAndView view = new ModelAndView();
		view.setViewName("update_seller");
		view.addObject("seller", seller);
		return view;
	}
}
