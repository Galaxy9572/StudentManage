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

<title>学生选课</title>
<link rel="stylesheet" type="text/css"
	href="/StudentManage/css/selectClass.css">
<script type="text/javascript" src="/StudentManage/js/selectClass.js"></script>
</head>

<body>
	<div id="title">
		<h1>学生选课</h1>
	</div>
	<jsp:include page="/jsp/home.jsp"/>
	<div id="result">
		<table id="classTable" align="center">
			<tr>
				<th><font color="white">课程编号</font></th>
				<th><font color="white">课程名</font></th>
				<th><font color="white">课时</font></th>
				<th><font color="white">授课老师编号</font></th>
				<th colspan="2"><font color="white">操作</font></th>
			</tr>
		</table>
	</div>
</body>
</html>
