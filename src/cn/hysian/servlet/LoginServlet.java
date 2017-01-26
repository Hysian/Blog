package cn.hysian.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String USERNAME = "hysian";  
    private final static String USERPWD = "bk@7120";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("userId").trim();
		String userPwd = request.getParameter("passWd").trim();
		Cookie id = new Cookie("id", userName);
		if(userName==null || userPwd==null){
			response.sendRedirect("login.html");
		}
		if(userName.equals(USERNAME) && userPwd.equals(USERPWD)){
			request.getSession().setMaxInactiveInterval(30*60);     // 设置session失效时间（timeout），单位为秒  
            request.getSession().setAttribute("userinfo", USERNAME);        // 用户名和密码正确，保存登录信息(获得session与jsp网页稍有不同) 
            response.addCookie(id);
            response.sendRedirect("admin.jsp");
        } else {  
            response.sendRedirect("login.html");            // 用户名和密码错误，跳转到登录界面  
        }  
	}

}
