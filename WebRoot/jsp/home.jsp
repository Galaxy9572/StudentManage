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
<base href="<%=basePath%>">

<title>回到首页</title>
<link rel="stylesheet" type="text/css"
	href="/StudentManage/css/home.css">

</head>

<body>
	<div id="nav">
		<a id="home" href="/StudentManage/index.jsp"><font color="#000">首页</font></a>
		<div id="user">
			<c:if test="${sessionScope.id == 'student'}">
			当前用户：<a id="auser" href="jsp/stuInfo.jsp"><font color="#000">${sessionScope.user.stuName}</font></a>
			</c:if>
			<c:if test="${sessionScope.id == 'teacher'}">
			当前用户：<a id="auser" href=""><font color="#000">${sessionScope.user.teacherName}</font></a>
			</c:if>
		</div>
	</div>
</body>
</html>
