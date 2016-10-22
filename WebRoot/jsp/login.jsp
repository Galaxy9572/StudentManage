<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>登录</title>
<link rel="stylesheet" type="text/css" href="../css/login.css">
<script type="text/javascript" src="/StudentManage/js/login.js"></script>
</head>
<body>
	<div id="title">
		<h1 id="h1">登录</h1>
	</div>
	<div id="login">
		<form action="/StudentManage/RegLoginServlet" method="post" id="form">
			<table>
				<tr>
					<td>身份：</td>
					<td>老师<input type="radio" value="T" name="ID"  id="teacher">学生<input
						type="radio" value="S" name="ID" id="student"></td>
				</tr>
				<tr>
					<td>编号（学号）：</td>
					<td><input type="text" name="ID" id="ID"></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="password" id="password"></td>
				</tr>
				<tr>
					<td colspan="2"><hr></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="登 录"
						onclick="login();" /> <input type="reset" value="重 置" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>