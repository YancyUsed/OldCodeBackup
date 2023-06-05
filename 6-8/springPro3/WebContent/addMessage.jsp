<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">留言板--添加留言</h1><hr>
<h3>1.<a href="<%=request.getContextPath() %>/addMessage.jsp">添加留言</a></h3>
<h3>2.<a href="<%=request.getContextPath() %>/servlet/MessageServlet?method=findAll">查看留言</a></h3>
<hr>
<form name="form1" action="servlet/MessageServlet?method=add" method="post">
昵称:<input type="text" name="name"/><br><br>
标题:<input type="text" name="title"/><br><br>
留言:<textarea name="conTxt" rows="5" cols="20"></textarea><br><br>
<input type="submit" name="submit" value="提交"/><br><br>
</form>
</body>
</html>