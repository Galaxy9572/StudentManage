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

<title>学生信息</title>
<link rel="stylesheet" type="text/css"
	href="/StudentManage/css/stuInfo.css">
<script type="text/javascript" src="/StudentManage/js/stuInfo.js"></script>
</head>

<body>
	<div id="title">
		<h1 id="h1">学生信息</h1>
	</div>
	<div id="info" align="center">
		<form action="/StudentManage/StudentOperateServlet?cmd=updateStuInfo" method="post">
			<table>
				<tr>
					<td>学生姓名：</td>
					<td><input type="text" name="stuName" id="stuName" value="${sessionScope.user.stuName }"
						onblur="checkStuName()"></td>
					<td id="stuName_info"></td>
				</tr>
				<tr>
					<td>学生学号：</td>
					<td><input type="text" name="stuNum" id="stuNum" disabled="disabled" value="${sessionScope.user.stuNum }"
						onblur="checkStuNum()"></td>
					<td id="stuNum_info"></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td><input type="text" name="gender" id="gender" value="${sessionScope.user.gender }"></td>
				</tr>
				<tr>
					<td>年龄：</td>
					<td><input type="text" name="age" id="age"  value="${sessionScope.user.age }" onblur="checkAge()"></td>
					<td id="age_info"></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="password" id="password" value="${sessionScope.user.password }"
						onblur="checkPassword()"></td>
					<td id="password_info"></td>
				</tr>
				<tr>
					<td colspan="2"><hr></td>
				</tr>
				<tr>
					<td><input type="submit" value="修改" ></td>
					<td><input type="reset" value="重置" /></td>
				</tr>
				<tr>
					<td><input type="button" value="查看所选课程"  onclick="listSelectedClasses()"/></td>
					<td><input type="button" value="选课" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
