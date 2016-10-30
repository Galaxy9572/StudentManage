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

<title>修改课程信息</title>


<link rel="stylesheet" type="text/css"
	href="/StudentManage/css/modifyClass.css">
<script type="text/javascript" src="/StudentManage/js/modifyClass.js"></script>
</head>

<body>
	<div id="title">
		<h1 id="h1">修改课程信息</h1>
	</div>
	<jsp:include page="/jsp/home.jsp"/>
	<div id="add">
		<table>
			<tr>
				<td>课程编号：</td>
				<td><input type="text" name="classID" id="classID"
					disabled="disabled" value="${sessionScope.classBean.classID}"></td>
			</tr>
			<tr>
				<td>课程名：</td>
				<td><input type="text" name="className" id="className"
					value="${sessionScope.classBean.className}"></td>
			</tr>
			<tr>
				<td>课时：</td>
				<td><input type="text" name="classNum" id="classNum"
					value="${sessionScope.classBean.classNum}"></td>
			</tr>
			<tr>
				<td>授课老师编号：</td>
				<td><input type="text" name="teacherID" id="teacherID"
					value="${sessionScope.classBean.teacherID}"></td>
			</tr>
			<tr>
				<td colspan="2"><hr></td>
			</tr>
			<tr>
				<td><input type="submit" value="确认" name="yes" onclick="modify()"></td>
				<td><input type="reset" value="重置" name="reset"></td>
			</tr>
		</table>
		</div>
</body>
</html>
