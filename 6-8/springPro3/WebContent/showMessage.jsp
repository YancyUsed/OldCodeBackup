<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">留言板--查看留言</h1><hr>
<h3>1.<a href="<%=request.getContextPath() %>/addMessage.jsp">添加留言</a></h3>
<hr>
<c:forEach items="${list }" var="m">
<h3>id:${m.id }</h3>
<h3>昵称:${m.name }</h3>
<h3>时间:${m.time }</h3>
<h3>标题:${m.title }</h3>
<h3>内容:${m.contxt }</h3>
<hr>
</c:forEach>
</body>
</html>