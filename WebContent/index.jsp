<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="cn.hysian.utils.*" %>
<%@ page import="cn.hysian.bean.ArticleBean" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="CSS/style.css" rel="stylesheet" type="text/css" />
<jsp:useBean id="articleDao" class="cn.hysian.dao.ArticleDao"></jsp:useBean>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>博客列表</title>
</head>
<body class="body">
	<jsp:include page="top.html"></jsp:include>
	<div class="wrap">
	<main>
	<div class="left">
<% 
	List list = articleDao.ArticleList();
	for(int i=0; i<list.size(); i++){
		ArticleBean article = (ArticleBean)list.get(i);
		String content =  article.getContent();
		if(content.length()>200){
			content = content.substring(0,200)+"...";
		}
		String time = DATEtool.GetJump(article.getUpTime());
%>	
		<article>
		<div>
			<div><h1 id="title"><a href="articlePage.jsp?id=<%=article.getId()%>"><%=article.getTitle()%>
			</a></h1></div>
			<div style="float:left;clear:both;"><%=content %></div>
			<div style="float:right;"><span><%=time %>前发布</span><span>阅读（<%=article.getNumber()%>）</span></div>
			<div id="x_line"></div>
		</div>
		
		</article>
		<%} %>
	</div>
	</main>
	<jsp:include page="left.html"></jsp:include>
	</div>
</body>
</html>