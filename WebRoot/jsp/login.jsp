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
<script>
	function r() {
		var teacherID = document.getElementById("teacherID");

		var pass = document.getElementById("password");
		if (teacherID.value == "") {
			alert("请输入教师编号");
			teacherID.focus();
			return;
		}
		if (pass.value == "") {
			alert("请输入密码");
			return;

		}
		return true;
	}
</script>
</head>
<body>
	<form>
		<table>
			<tr>
				<td>身份：</td>
				<td>老师<input type="radio" value="T" name="ID">学生<input
					type="radio" value="S" name="ID"></td>
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
				<td colspan="2"><input type="button" value="登 录" onclick="r();" />
					<input type="reset" value="重 置" /></td>
			</tr>

		</table>
	</form>
</body>
</html>