<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台登录</title>

	<script type="text/javascript" src="/buy/jsp/jquery-3.1.0.js"></script>
<script type="text/javascript">
$(document).ready(function(){
$("#username").click(function(){
$("#fail").hide();
})});
</script>
  </head>
  
  <body>
     <form  id="target" action="/buy/servlet/ManagerLoginServlet" method="post" onsubmit="return befor">
   <table>
   <tr>
   <td>用户名：</td>
   <td>
   <input type="text" name="username" id="username">
   </td>
   <td><a id="fail">${fail }</a></td>
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
  </body>
</html>
