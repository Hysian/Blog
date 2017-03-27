package cn.hysian.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hysian.service.UserService;
import cn.hysian.service.impl.UserServiceimpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;
       
	
	@Override
	public void init() throws ServletException {
		userService=new UserServiceimpl();
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("userId").trim();
		String userPwd = request.getParameter("passWd").trim();
//		if(userName==null || userPwd==null){
//			response.sendRedirect("login.html");
//		}
		boolean flag = userService.loginUser(userName, userPwd);
		if(flag){
			//Cookie id = new Cookie("LoginUser", userName);
			request.getSession().setMaxInactiveInterval(30*60);     // 设置session失效时间（timeout），单位为秒  
            request.getSession().setAttribute("LoginUser", userName);        // 用户名和密码正确，保存登录信息(获得session与jsp网页稍有不同) 
            //response.addCookie(id);
            response.sendRedirect("admin.jsp");
        } else {  
            response.sendRedirect("login.html");            // 用户名和密码错误，跳转到登录界面  
        }  
	}

}
