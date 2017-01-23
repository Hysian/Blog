<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.util.*" %>
<%@ page import="cn.hysian.tool.*" %>
<%@ page import="cn.hysian.bean.ArticleBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="CSS/style.css" rel="stylesheet" type="text/css" />
<jsp:useBean id="articleDao" class="cn.hysian.dao.ArticleDao"></jsp:useBean>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%	
	int id = Integer.parseInt(request.getParameter("id"));
	ArticleBean article = articleDao.queArticle(id);
	String content = article.getContent();
%>
<title><%=article.getTitle() %></title>
</head>
<body>
<div class="wrap">

	<h1><%=article.getTitle() %></h1>
	<div><span><%=article.getUpTime() %></span><span>阅读（<%=article.getNumber()%>）</span></div>
	<div style="float:left;line-height:30px;"><%=content %></div>
</div>
</body>
</html>