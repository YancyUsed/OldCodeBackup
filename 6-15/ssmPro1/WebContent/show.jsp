<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">SSM应用一show.jsp</h1>
<hr>
<h3>1.<a href="<%=request.getContextPath() %>/test/UserinfoHandler_findAll">控制器UserinfoHandler_findAll</a></h3>
<hr>
<h2 align="center">${msg }</h2>
<hr>
<c:forEach items="${requestScope.list }" var="u">
<h3>id:${u.id }</h3>
<h3>userName:${u.username }</h3>
<h3>pwd:${u.pwd }</h3>
<h3>num:${u.num }</h3>
<h3>other:${u.other }</h3>
<hr>
</c:forEach>
</body>
</html>