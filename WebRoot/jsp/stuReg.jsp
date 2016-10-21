<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<title>学生注册</title>
<link rel="stylesheet" type="text/css" href="../css/stuReg.css">
</head>
<body>
	<div id="title">
		<h1 id="h1">学生注册</h1>
	</div>
	<div id="reg">
		<form action="/StudentManage/RegLoginServlet?cmd=stuReg" method="post">
			<table>
				<tr>
					<td>学生姓名：</td>
					<td><input type="text" name="stuName"></td>
				</tr>
				<tr>
					<td>学生学号：</td>
					<td><input type="text" name="stuNum"></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td>男<input type="radio" name="gender" value="male">女<input
						type="radio" name="gender" value="female"></td>
				</tr>
				<tr>
					<td>年龄：</td>
					<td><input type="text" name="age"></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td>确认密码：</td>
					<td><input type="password" name="cfpassword"></td>
				</tr>
				<tr>
					<td><input type="submit" value="提交"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>