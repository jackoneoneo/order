package team.waibao.controll;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import team.waibao.entity.User;
import team.waibao.service.UserService;
import team.waibao.util.RandomImage;

@RequestMapping(value="/user")
@Controller
public class UserControll {


	
	@Autowired
	private UserService  userService;
	
	
	
	@RequestMapping(value="/userLogin.do")
	public String userLogin(){
		return "user_login";
	}
	
	/**
	 * 用户的注册界面
	 *@return
	 */
	@RequestMapping(value="/userRegister.do")
	public String userRegister(){
		return "user_Register";
	}
	
	/**
	 * 添加用户
	 *@param user 需要添加的用户
	 */
	@RequestMapping(value="/addUser.do")
	public String  addUser(User user){
		userService.addUser(user);
		return "user_login";
	}
	@RequestMapping(value="/checkUser.do",method={RequestMethod.POST,RequestMethod.GET})
	public String checkUser(HttpServletRequest request,HttpServletResponse response){
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String code = request.getParameter("code");
		
		User user = new User(userName, password);
		
		boolean isTrueValidNumber = code.equalsIgnoreCase((String) request.getSession().getAttribute("code"));
		//登陆成功跳转到首页
		if(userService.isContainUser(user) && isTrueValidNumber ){
			request.getSession().setAttribute("userName", userName);
			return "redirect:/main/mainPage.do";
		}else{
			//跳转到登陆界面
			return "redirect:userLogin.do";
		}
	}

	
	
	@RequestMapping(value="/index.do")
	public String index(){
		return "index";
	}
	
	@RequestMapping(value="/validNumber.do")
	public void getRandomCode(HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println("-------------------------");
		  // 设置响应的类型格式为图片格式  
      response.setContentType("image/jpeg");  
      // 禁止图像缓存。  
      response.setHeader("Pragma", "no-cache");  
      response.setHeader("Cache-Control", "no-cache");  
      response.setDateHeader("Expires", 0);  
      RandomImage instance = new RandomImage();  
      
      
    
     HttpSession session = request.getSession(true);
     session.setAttribute("code", instance.getCode());
     System.out.println("now code is+"+instance.getCode()+"");
      instance.write(response.getOutputStream()); 
		
		  
	};
  
	/**
	 * 验证用户名
	 *@param userName
	 */
	@RequestMapping(value="/checkUserName.do")
	public void checkUserName(HttpServletRequest request,HttpServletResponse response){
		String userName = request.getParameter("userName");
		System.out.println(userName);
		if(!userService.isContainUserName(userName)){
			try {
				response.getWriter().write("false");
			} catch (IOException e) {
		
				e.printStackTrace();
			}
		}
			
	}
	/**
	 * 验证密码是否正确
	 *@param 
	 * @throws IOException 
	 */
	@RequestMapping(value="/checkUserPassword.do")
	public void checkUserPassword(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if(userService.isContainUserName(userName)){
			if(!userService.isContainUser(new User(userName,password))){
				response.getWriter().write("false");
			}
		}
			
	}
	
	/**
	 * 验证验证码
	 *
	 * 
	 */
	@RequestMapping(value="/checkUserValidNumber.do")
	public void checkUserValidNumber(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String code = (String) request.getSession().getAttribute("code");
		String userCode = request.getParameter("code");
		if(!code.equalsIgnoreCase(userCode)){
			response.getWriter().write("false");
		}
			
	}
	
}
