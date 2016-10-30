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

<title>添加新课程</title>

<link rel="stylesheet" type="text/css"
	href="/StudentManage/css/addClass.css">

</head>

<body>
	<div id="title">
		<h1 id="h1">添加新课程</h1>
	</div>
	<jsp:include page="/jsp/home.jsp"/>
	<div id="add">
		<form action="/StudentManage/ClassOperateServlet?cmd=addClass" method="post">
			<table>
				<tr>
					<td>课程编号：</td>
					<td><input type="text" name="classID"></td>
				</tr>
				<tr>
					<td>课程名：</td>
					<td><input type="text" name="className"></td>
				</tr>
				<tr>
					<td>课时：</td>
					<td><input type="text" name="classNum"></td>
				</tr>
				<tr>
					<td>授课老师编号：</td>
					<td><input type="text" name="teacherID"></td>
				</tr>
				<tr>
					<td colspan="2"><hr></td>
				</tr>
				<tr>
					<td><input type="submit" value="确认" name="yes"></td>
					<td><input type="reset" value="重置" name="reset"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
