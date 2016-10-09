<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加商品</title>

  </head>
  
  <body>
     <form  id="target" action="${pageContext.request.contextPath}/servlet/GoodsServlet?method=add" method="post" enctype="multipart/form-data" >
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
   <td>所属类别：</td>
   <td>
   <select name="subdivide">
   <c:forEach var="sub" items="${subdivides}">
   <option value="${sub.uuid}">${sub.name}</option>
   </c:forEach>
   </select>
   </td>
   </tr>
    <tr>
   <td>上传图片：</td>
   <td>
   <input type="file" name="imgae">
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
