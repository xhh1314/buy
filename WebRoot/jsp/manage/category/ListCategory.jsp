<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>list Categorys</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<form>
		<table>
			<tr>
				<th>名字</th>
				<th>描述</th>
				<th>修改</th>
				<th>删除</th>
			</tr>
			<c:forEach var="cat" items="${categorys}">
				<tr>
					<td>${cat.name}</td>
					<td>${ cat.description}</td>
					<td><a
						href="/buy/servlet/CategoryServlet?method=update&&uuid=${cat.uuid}">修改</a>
					</td>
					<td><a href="/buy/servlet/CategoryServlet?method=delete&&uuid=${cat.uuid}" >删除</a>
					</td>
				</tr>
			</c:forEach>

		</table>

	</form>

</body>
</html>
