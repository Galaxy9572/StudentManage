<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<link href="/homePage/css/bg_regSuccess.css" rel="stylesheet"
	type="text/css" />
<title>注册状态</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="/homePage/js/jump_back.js"></script>
</head>

<body onload="jump_back(5)">
	<div id="head">
		<div id="web_title">注册成功</div>
	</div>
	<br>
	<br>
	<br>
	<div id="success">
		<img alt="img_success" src="/homePage/img/success.png" width="300px">
	</div>
	<br>
	<br>
	<br>
	<h1  id="timer">5</h1>秒
	
</body>
</html>
