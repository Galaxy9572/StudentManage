<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Refresh" content="3;url=/StudentManage/index.jsp">
<base href="<%=basePath%>">
<link href="/homePage/css/bg_regSuccess.css" rel="stylesheet"
	type="text/css" />
<title>注册状态</title>

<link rel="stylesheet" type="text/css" href="/StudentManage/css/regSuccess.css">
</head>
<body>
	<br>
	<br>
	<br>
	<div id="success">
		<h1><font color="white">注册成功！</font></h1>
		<h1><font color="white">即将跳转到首页</font></h1>
	</div>
	<br>
	<br>
	<br>
</body>
</html>
