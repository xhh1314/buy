<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>欢迎访问竹海之家</title>
    
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
   <form action="/buy/servlet/LoginServlet" method="post">
   <table>
   <tr>
   <td>用户名：</td>
   <td>
   <input type="text" name="username" id="username">
   </td>
   </tr>
   <tr>
   <td>密码：</td>
   <td>
   <input type="password" name="password" id="password">
   </td>
   </tr>
   <tr>
   <td>
   <input type="submit" value="登录" id="login">
   </td>
   <td></td>
   </tr>
   </table>
   </form>
   <br/><br/>
   <a>没有账号？点这里</a><a href="/buy/jsp/Register.jsp">注册</a>
  </body>
</html>
