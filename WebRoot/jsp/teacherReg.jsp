<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<title>老师注册</title>
</head>

<body>
	<form action="/StudentManage/RegLoginServlet?cmd=teacherReg" method="post">
		<table>
			<tr>
				<td>教师编号：</td>
				<td><input type="text" name="teacherID" ></td>
			</tr>
			<tr>
				<td>姓名：</td>
				<td><input type="text" name="teacherName"></td>
			</tr>
			<tr>
				<td>性别：</td>
				<td><input type="radio" value="male" name="gender">男<input
					type="radio" value="female" name="gender">女</td>
			</tr>
			<tr>
				<td>年龄：</td>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<td>教授专业：</td>
				<td><input type="text" name="major"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>确认密码：</td>
				<td><input type="password" name="cfpassword" onblur=a1()></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="确认" name="yes"
					onclick=a2()> <input type="reset" value="重置"
					name="reset"></td>
			</tr>
		</table>
	</form>
</body>
</html>
