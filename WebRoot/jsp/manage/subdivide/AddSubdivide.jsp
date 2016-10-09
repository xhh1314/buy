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
    
    <title>新增中类明细</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript" src="jsp/jquery-3.1.0.js"></script>
<script type="text/javascript">
$(document).ready(function(){
$("#name").click(function(){
$("#fail").hide();
})});

</script>
  </head>
  
  <body>
      <form  id="target" action="/buy/servlet/SubdivideServlet?method=add" method="post" >
   <table>
   <tr>
   <td>名字：</td>
   <td>
   <input type="text" name="name" id="name">
   </td>
   <td><a id="fail">${fail }</a></td>
   </tr>
   <tr>
   <td>所属大类</td>
   <td>
   <select name="category">
   <c:forEach var="cat" items="${categorys}">
   <option value="${cat.uuid}">${cat.name}</option>
   </c:forEach>
   </select>
   </td>
   </tr>
   <tr>
   <td>描述：</td>
   <td>
   <textarea rows="5" cols="16" name="desciption"></textarea>
   </td>
   </tr>
   <tr>
   <td>
   <input type="submit" value="提交" id="login">
   </td>
   <td></td>
   </tr>
   </table>
   </form>
  </body>
</html>
