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
	<script type="text/javascript" src="jsp/jquery-3.1.0.js"></script>
<script type="text/javascript">
$(document).ready(function(){
$("#username").click(function(){
$("#fail").hide();
})});

</script>
<script type="text/javascript">
//提交验证
function befor(){
$("#id").submit(function(){
var username=$("#username");
var password=$("#password");
if(username==null || password==null){
alert("用户名或者密码不能为空");
return false;}
else
return true;

});
}
</script>
  </head>
  
  <body>
   <form  id="target" action="/buy/servlet/LoginServlet" method="post" onsubmit="return befor">
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
   <br/><br/>
   <a>没有账号？点这里</a><a href="/buy/jsp/Register.jsp">注册</a>
  </body>
</html>
