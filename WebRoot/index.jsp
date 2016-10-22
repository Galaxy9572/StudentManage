<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<base href="<%=basePath%>">

<title>学生课程管理系统</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>

<body>
	<div id="title">
		<h1 id="h1">学生课程管理系统</h1>
	</div>
	<div id="function">
		<table id="table">
			<tr>
				<td><a href="jsp/stuReg.jsp">学生注册</a></td>
				<td><a href="jsp/teacherReg.jsp">老师注册</a></td>
			</tr>
			<tr>
				<td colspan="2"><hr></td>
			</tr>
			<tr>
				<td colspan="2"><a href="jsp/login.jsp">登录</a></td>
			</tr>
			<tr>
				<td colspan="2"><hr></td>
			</tr>
			<tr>
				<td colspan="2"><a href="jsp/admin.jsp">管理员入口</a></td>
			</tr>
		</table>
	</div>
</body>
</html>
