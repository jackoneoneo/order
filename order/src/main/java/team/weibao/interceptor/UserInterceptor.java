package team.weibao.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 用户访问的拦截器
 * 
 * @author 曾志鹏
 * @version 创建时间：2016年8月22日 上午10:19:11
 * 
 */
public class UserInterceptor extends HandlerInterceptorAdapter {

	private final Logger log = LoggerFactory.getLogger(UserInterceptor.class);
	// 存放不需要拦截的uri
	private List<String> uriList = new ArrayList<String>();

	public List<String> getUriList() {
		return uriList;
	}

	public void setUriList(List<String> uriList) {
		this.uriList = uriList;
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		//log.debug("===============================afterCompletion");
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		//log.debug("===========HandlerInterceptor1 postHandle");
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// /order/user/validNumber.do
		String userName = (String) request.getSession()
				.getAttribute("userName");
		String requestURI = request.getRequestURI().toString();
		if (null == userName) {
			if (uriList.contains(requestURI))
				return true;
			else {
				request.getRequestDispatcher("/WEB-INF/jsp/user_login.jsp")
						.forward(request, response);
				return false;
			}
		} else {
			return true;
		}

	}

}
