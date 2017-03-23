package cn.hysian.servlet;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hysian.dao.impl.ArticleDaoimpl;
import cn.hysian.pojo.Article;
import cn.hysian.utils.DATEtool;


public class ArticleServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String p = request.getParameter("op");
		int id = Integer.parseInt(request.getParameter("id"));
		response.setCharacterEncoding("UTF-8");
		if(p.equals("4")){
			int flag = new ArticleDaoimpl().deleteArtcle(id);
			if(flag != 0){
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
		
		Article article = new Article();
		String time = new DATEtool().GetTime();
		article.setTitle(title);
		article.setContent(text);
		article.setUpTime(time);
		int flag = new ArticleDaoimpl().addArticle(article);
		System.out.println(flag);
	}

}
