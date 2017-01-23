package cn.hysian.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hysian.bean.ArticleBean;
import cn.hysian.dao.ArticleDao;
import cn.hysian.tool.DATEtool;


public class ArticleServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String p = request.getParameter("op");
		int id = Integer.parseInt(request.getParameter("id"));
		response.setCharacterEncoding("UTF-8");
		if(p.equals("4")){
			boolean flag = new ArticleDao().exeArticle("delete", id);
			if(flag){
				response.setContentType("application/json; charset=utf-8");
			}
		}
		response.getWriter().print("true");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String text = request.getParameter("content");
		title = java.net.URLDecoder.decode(title,"UTF-8");
		text = java.net.URLDecoder.decode(text,"UTF-8");
		System.out.println(text);
		ArticleBean article = new ArticleBean();
		String time = new DATEtool().GetTime();
		article.setTitle(title);
		article.setContent(text);
		article.setUpTime(time);
		boolean flag = new ArticleDao().upArticle("add",article);
		System.out.println(flag);
		if(flag){
//			response.sendRedirect("admin.jsp");
		}
	}

}
