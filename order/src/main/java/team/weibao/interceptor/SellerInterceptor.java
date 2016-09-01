package team.weibao.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/**
 * 商家拦截器
* @author 曾志鹏
* @version 创建时间：2016年8月25日 上午9:15:40
*
 */
public class SellerInterceptor extends HandlerInterceptorAdapter {
  
	private final Logger log = LoggerFactory.getLogger(SellerInterceptor.class);
	private List<String> uriList ;
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	
	//	log.debug("=======================sellerInterceptorafterCompletion");
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		//log.debug("=======================sellerInterceptorPorstHandle");
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {


		// /order/user/validNumber.do
		String userName = (String) request.getSession()
				.getAttribute("sellerName");
		String requestURI = request.getRequestURI().toString();
		if (null == userName) {
			if (uriList.contains(requestURI))
				return true;
			else {
				request.getRequestDispatcher("/WEB-INF/jsp/seller_login.jsp")
						.forward(request, response);
				return false;
			}
		} else {
			return true;
		}

	
	}

	public List<String> getUriList() {
		return uriList;
	}

	public void setUriList(List<String> uriList) {
		this.uriList = uriList;
	}

}
