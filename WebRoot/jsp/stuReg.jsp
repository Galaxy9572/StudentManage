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
<link rel="stylesheet" type="text/css"
	href="/StudentManage/css/stuReg.css">
	<script type="text/javascript" src="/StudentManage/js/stuReg.js"></script>
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
					<td><input type="text" name="stuName"  id="stuName" onblur="checkStuName()"></td>
					<td id="stuName_info"></td>
				</tr>
				<tr>
					<td>学生学号：</td>
					<td><input type="text" name="stuNum" id="stuNum" onblur="checkStuNum()"></td>
					<td id="stuNum_info"></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td>男<input type="radio" name="gender" value="male" checked="checked">女<input
						type="radio" name="gender" value="female"></td>
				</tr>
				<tr>
					<td>年龄：</td>
					<td><input type="text" name="age" id="age" onblur="checkAge()"></td>
					<td id="age_info"></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="password"  id="password" onblur="checkPassword()"></td>
					<td id="password_info"></td>
				</tr>
				<tr>
					<td>确认密码：</td>
					<td><input type="password" name="cfpassword"  id="cfpassword"  onblur="confirmPassword()"></td>
					<td id="cfpassword_info"></td>
				</tr>
				<tr>
					<td colspan="2"><hr></td>
				</tr>
				<tr>
					<td><input type="submit" value="注册"></td><td><input type="reset" value="重置" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>