<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>update Category</title>
    
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
     <form  id="target" action="/buy/servlet/CategoryServlet?method=updateValue" method="post" >
   <table>
   <tr>
   <td>名字：</td>
   <td>
   <input type="text" name="name" id="name" value="${category.name}">
   </td>
   <td><a id="info">${info }</a></td>
   </tr>
   <tr>
   <td>描述：</td>
   <td>
   <textarea rows="5" cols="16" name="description" >${category.description}</textarea>
   </td>
   </tr>
   <tr>
   <td>
   <input type="submit" value="提交" id="login">
   </td>
   
   <td>
   <input type="hidden" name="uuid" value="${category.uuid}">
   <input type="hidden" name="id" value="${category.id }">
   </td>
   </tr>
   </table>
   </form>
  </body>
</html>
