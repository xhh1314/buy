<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title> 新增商品大类</title>
  

  </head>
  
  <body>
     <form  id="target" action="/buy/servlet/CategoryServlet?method=add" method="post" >
   <table>
   <tr>
   <td>名字：</td>
   <td>
   <input type="text" name="name" id="name">
   </td>
   <td><a id="info">${info }</a></td>
   </tr>
   <tr>
   <td>描述：</td>
   <td>
   <textarea rows="5" cols="16" name="description"></textarea>
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
