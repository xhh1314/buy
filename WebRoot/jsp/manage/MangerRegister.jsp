<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员注册</title>
    
  </head>
  
  <body>
        <form action="/buy/servlet/RegisterServlet" method="post">
    <table>
    <tr>
    <td>姓名：</td><td><input type="text" name="username" ></td><td></td>
    </tr>
    <tr>
    <td>密码：</td><td><input type="password" name="password"></td><td></td>
    </tr>
    <tr>
    <td>密码确认：</td><td><input type="password" name="password1"></td><td></td>
    </tr>
    <tr>
    <td>手机：</td><td><input type="text" name="telephone"></td><td></td>
    </tr>
    <tr>
    <td>邮箱：</td><td><input type="text" name="email"></td><td></td>
    </tr>
    <tr>
    <td><input type="submit" value="注册"></td>
    </tr>
    </table>
    </form>
  </body>
</html>
