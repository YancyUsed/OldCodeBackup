<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
pagination{   
padding: 2px;   
}   
  
.pagination ul{   
margin: 0;   
padding: 0;   
text-align: left; /*Set to "right" to right align pagination interface*/   
font-size: 12px;   
}   
  
.pagination li{   
list-style-type: none;   
display: inline;   
padding-bottom: 1px;   
}   
  
.pagination a, .pagination a:visited{   
padding: 0 5px;   
border: 1px solid #9aafe5;   
text-decoration: none;    
color: #2e6ab1;   
}   
  
.pagination a:hover, .pagination a:active{   
border: 1px solid #2b66a5;   
color: #000;   
background-color: lightyellow;   
}   
  
.pagination li.currentpage{   
font-weight: bold;   
padding: 0 5px;   
border: 1px solid navy;   
background-color: #2e6ab1;   
color: #FFF;   
}   
  
.pagination li.disablepage{   
padding: 0 5px;   
border: 1px solid #929292;   
color: #929292;   
}   
  
.pagination li.nextpage{   
font-weight: bold;   
}   
  
* html .pagination li.currentpage, * html .pagination li.disablepage{ /*IE 6 and below. Adjust non linked LIs slightly to account for bugs*/   
margin-right: 5px;   
padding-right: 0;   
}  
</style>
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
<h3><a href="#">删除</a></h3>
<hr>
</c:forEach>

<hr>
<div class="pagination">  
<ul> 
<li><a href="MessageHandler_findAllByPage?page=1">首页</a></li> 
<li><a href="MessageHandler_findAllByPage?page=${p.page-1}">上一页</a></li> 

<c:forEach begin="${p.startPage }" end="${p.endPage }" var="i">
<c:if test="${p.page==i }">
	<li class="currentpage">${i }</li> 
</c:if>
<c:if test="${p.page!=i }">
	<li><a href="MessageHandler_findAllByPage?page=${i }">${i }</a></li> 
</c:if>
</c:forEach>
 
<li><a href="MessageHandler_findAllByPage?page=${p.page+1}">下一页</a></li>  
<li><a href="MessageHandler_findAllByPage?page=${p.maxPage }">尾页</a></li> 
</ul>  
</div> 
<hr>
<div class="pagination">  
<ul>  
<li class="disablepage">上一页</li>  
<li class="currentpage">1</li>  
<li><a href="#">2</a></li>  
<li><a href="#">3</a></li>  
<li><a href="#">4</a></li>  
<li><a href="#">5</a></li>  
<li><a href="#">6</a></li>  
<li><a href="#">7</a></li>  
<li><a href="#">8</a></li>  
<li><a href="#">9</a>...</li>  
<li><a href="#">15</a></li>  
<li><a href="#">16</a></li>  
<li class="nextpage"><a href="#">下一页</a></li>  
</ul>  
</div>
</body>
</html>