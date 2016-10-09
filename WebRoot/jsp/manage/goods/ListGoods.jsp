<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>goods lists</title>
    

  </head>
  
  <body>
  <form>
		<table>
			<tr>
			<th>图片</th>
				<th>名字</th>
				<th>描述</th>
				<th>商品类别</th>
				<th>修改</th>
				<th>删除</th>
			</tr>
			<c:forEach var="good" items="${goods}">
				<tr>
				<td> <div> <img name="image" src="${good.image_location}"  ></div></td>
					<td>${good.name}</td>
					<td>${ good.description}</td>
					<td>${ good.subdivide.name}</td>
					<td><a
						href="/buy/servlet/GoodsServlet?method=update&&uuid=${good.uuid}">修改</a>
					</td>
					<td><a href="/buy/servlet/GoodsServlet?method=delete&&uuid=${good.uuid}" >删除</a>
					</td>
				</tr>
			</c:forEach>

		</table>

	</form>
  <br/>
 
  </body>
</html>
