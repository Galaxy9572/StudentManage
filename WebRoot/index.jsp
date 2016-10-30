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

<title>学生课程管理系统</title>  
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>

<body>
	<div id="title">
		<h1 id="h1">学生课程管理系统</h1>
	</div>
	<jsp:include page="jsp/home.jsp"/>
	<div id="function">
		<table id="table">
			<tr>
				<td><a href="jsp/stuReg.jsp"><font color="#000">学生注册</font></a></td>
				<td><a href="jsp/teacherReg.jsp"><font color="#000">老师注册</font></a></td>
			</tr>
			<tr>
				<td colspan="2"><hr></td>
			</tr>
			<tr>
				<td colspan="2"><a href="jsp/login.jsp"><font color="#000">登录</font></a></td>
			</tr>
			<tr>
				<td colspan="2"><hr></td>
			</tr>
			<tr>
				<td colspan="2"><a href="jsp/admin.jsp"><font color="#000">管理员入口</font></a></td>
			</tr>
		</table>
	</div>
</body>
</html>
