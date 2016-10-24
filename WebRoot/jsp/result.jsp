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
<title>结果</title>
<meta http-equiv="refresh" content="3;url=/StudentManage/index.jsp">
<link rel="stylesheet" type="text/css"
	href="/StudentManage/css/result.css">
</head>

<body>
	<div id="regState">
		<h1>
			<font color="white">${requestScope.result}</font>
		</h1>
		<h1>
			<font color="white">即将跳转至首页</font>
		</h1>
	</div>
</body>
</html>
