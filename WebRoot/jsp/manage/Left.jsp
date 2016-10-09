<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title> 左侧导航栏</title>
   

  </head>
  
  <body>
   <a id="pm">权限管理</a>
   <div>
   <ul>
   <li><a>用户管理</a></li>
   <li><a>角色管理</a></li>
   <li><a>资源管理</a></li>
   </ul>
   </div>
   <a id="gm">商品管理</a>
   <div>
   <ul>
   <li ><a >商品大类</a></li>
   
   <div>
   <ul>
  <li><a href="/buy/jsp/manage/category/AddCategory.jsp" target="body">添加商品分类</a></li>
  <li><a href="/buy/servlet/CategoryServlet?method=findAll" target="body">查看商品分类</a></li>
   </ul>
   </div>
   
   <li><a>商品中类</a></li>
   <div>
   <ul>
   <li><a href="/buy/servlet/SubdivideServlet?method=beforAdd" target="body">添加中类</a></li>
   <li><a href="/buy/servlet/SubdivideServlet?method=findAll" target="body">查看中类</a></li>
   </ul>
   </div>
   
   <li><a >商品</a></li>
   <div>
   <ul>
  <li><a href="/buy/servlet/GoodsServlet?method=beforAdd" target="body">添加商品</a></li>
  <li><a href="/buy/servlet/GoodsServlet?method=findAll" target="body">查看商品</a></li>
   </ul>
   </div>
   </li>
 </ul>
  </body>
</html>
