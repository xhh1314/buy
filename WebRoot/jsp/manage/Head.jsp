<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>

  </head>
  
  <body>
  <a style="right: 50%;">后台管理</a>
   <a style="position:absolute ;right:20%;top: 50%">管理员:${manager.name}</a>
  </body>
</html>
