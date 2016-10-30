<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>所有课程</title>

<link rel="stylesheet" type="text/css"
	href="/StudentManage/css/allClasses.css">
<script type="text/javascript" src="/StudentManage/js/allClasses.js"></script>
</head>

<body>
	<div id="title">
		<h1>所有课程</h1>
	</div>
	<jsp:include page="/jsp/home.jsp"/>
	<div id="result">
		<table id="classTable" align="center">
			<tr>
				<th><font color="black">课程编号</font></th>
				<th><font color="black">课程名</font></th>
				<th><font color="black">课时</font></th>
				<th><font color="black">授课老师编号</font></th>
				<th colspan="2"><font color="black">操作</font></th>
			</tr>
		</table>
	</div>
</body>
</html>
