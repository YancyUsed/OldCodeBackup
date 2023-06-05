<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">SSM应用一</h1>
<hr>
<h3>1.<a href="<%=request.getContextPath() %>/test/UserinfoHandler_findAll">控制器UserinfoHandler_findAll</a></h3>
<h3>2.<a href="<%=request.getContextPath() %>/zhuanZhang.jsp">转账业务</a></h3>
<hr>
<form action="<%=request.getContextPath() %>/test/UserinfoHandler_zhuanZhang" method="post">
	账号A:<input type="text" name="userNameA"/><br><br>
	账号B:<input type="text" name="userNameB"/><br><br>
	转账金额:<input type="text" name="num"/><br><br><hr>
	<input type="submit" name="submit" value="转账"/><br><br>
</form>
</body>
</html>