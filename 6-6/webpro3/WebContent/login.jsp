<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">登录---1.0</h1>
<hr>
<h3>1.<a href="login.jsp">登录</a></h3>
<h3>2.<a href="zhuanZhang.jsp">转账</a></h3>
<hr>
<form name="form1" action="servlet/UserinfoServlet?method=login" method="post">
账号：<input type="text" name="userName" /><br><br>
密码：<input type="password" name="pwd" /><br><br>
<input type="submit"  name="submit" value="登录" />
<input type="reset"  name="reset" value="重置" />
</form>
</body>
</html>