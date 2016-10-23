<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>注册结果</title>
    <meta http-equiv="refresh" content="3;url=/StudentManage/index.jsp"> 
	<link rel="stylesheet" type="text/css" href="/StudentManage/css/regResult.css">
  </head>
  
  <body>
    <div id="regState"><h1><font color="white">${requestScope.regResult}</font></h1></div>
  </body>
</html>
