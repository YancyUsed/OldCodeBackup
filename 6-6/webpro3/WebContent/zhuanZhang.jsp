<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">转账</h1>
<hr>
<h2 align="center">${msg }</h2>
<hr>
<h3>1.<a href="login.jsp">登录--1.0</a></h3>
<h3>1.<a href="login2.jsp">登录--2.0</a></h3>
<h3>2.<a href="zhuanZhang.jsp">转账</a></h3>
<hr>
<form name="form1" action="servlet/UserinfoServlet?method=zhuanZhang" method="post">
账号A:<input type="text" name="userName_a"/><br><br>
账号B:<input type="text" name="userName_b"/><br><br>
转账金额:<input type="text" name="num"/><br><br>
<hr>
<input type="submit" name="submit" value="转账"/><br><br>
</form>
</body>
</html>