<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>修改文章</title>
</head>
<body>
	<div>
	<h1>文本编辑</h1>
	<div id="editer">
	<form action="article" method="POST">
		<input type="text" name="title">
		<textarea id="text" name="content"></textarea>
		<input type="submit" value="提交">
	</form>
	</div>
</div>
</body>
</html>