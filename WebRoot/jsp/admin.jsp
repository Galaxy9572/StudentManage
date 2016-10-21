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
<title>系统管理</title>
<link rel="stylesheet" type="text/css"
	href="/StudentManage/css/admin.css">
	<script type="text/javascript" src="/StudentManage/js/admin.js"></script>
</head>

<body>
	<div id="title">系统管理</div>
	<div id="manage">
		<table>
			<tr>
				<th colspan="3">学生管理</th>
			</tr>
			<tr>
				<td>按学号查找：</td>
				<td><input type="text" id="findSByNum"></td>
				<td><input type="button" id="bt_findSByNum" value="查找" onclick="sendToServer()"></td>
			</tr>
			<tr>
				<td>按姓名查找：</td>
				<td><input type="text" id="findSByName">
				<td><input type="button" id="bt_findSByName" value="查找"></td>
			</tr>
			<tr>
				<td>按学号删除学生：</td>
				<td><input type="text" id="delSByNum"></td>
				<td><input type="button" id="bt_delSByNum" value="删除"></td>
			</tr>
			<tr><td colspan="3"><hr></td></tr>
			<tr>
				<th colspan="3">老师管理</th>
			</tr>
			<tr>
				<td>按编号查找：</td>
				<td><input type="text" id="findTByNum"></td>
				<td><input type="button" id="bt_findTByNum" value="查找"></td>
			</tr>
			<tr>
				<td>按姓名查找：</td>
				<td><input type="text" id="findTByName"></td>
				<td><input type="button" id="bt_findTByName" value="查找"></td>
			</tr>
			<tr>
				<td><input type="button" id="bt_newT" value="添加新老师"></td>
			</tr>
			<tr><td colspan="3"><hr></td></tr>
			<tr>
				<th colspan="3">课程管理</th>
			</tr>
			<tr>
				<td><input type="button" id="listAll" value="查看所有课程"></td>
			</tr>
			<tr>
				<td><input type="button" id="addClass" value="添加新课程"></td>
			</tr>
		</table>
	</div>
</body>
</html>
