<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="cn.hysian.utils.*" %>
<%@ page import="cn.hysian.bean.ArticleBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理</title>
<jsp:useBean id="articleDao" class="cn.hysian.dao.ArticleDao"></jsp:useBean>
</head>
<script type="text/javascript">
	function dec(n,id){
		if(confirm("确认删除"))
		{
			var xmlhttp=new XMLHttpRequest();
			n.parentNode.parentNode.removeChild(n.parentNode);
			xmlhttp.open("GET","article?op=4&id="+id,true);
			xmlhttp.send();
			xmlhttp.onreadystatechange=function()
			  {
			  if (xmlhttp.readyState==4 && xmlhttp.status==200)
			    {
			    document.getElementById("myDiv").innerHTML="成功";
			    }
			  }
			
		}
	}
</script>
<body>
	<div>
	<div>
	<table>
	<% 
		List list = articleDao.ArticleList();
		for(int i=0; i<list.size(); i++){
			ArticleBean article = (ArticleBean)list.get(i);
			int id =  article.getId();
	%>	
	<tr id="id<%= id%>">
		<td><%= article.getTitle() %></td>
		<td><button type = "button"  onclick="dec(this.parentNode,<%= id%>)">删除</button></td>
		<td><a href="fixArticle?id=<%=id%>>"></a></td>
	</tr>
	<%} %>
	</table>
	<div id = "myDiv"></div>
	</div>		
	</div>

</body>
</html>