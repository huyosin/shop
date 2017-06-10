<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/base.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>用户登录-MonO-专业的java学习培训平台</title>
    <meta name="keywords" content="MonO JAVA研发">
    <meta name="description" content="JAVA研发！">
    <script type="text/javascript" src="${staticPath}/js/login.js" charset="utf-8"></script>
</head>
<body>
<div id="win" class="easyui-window" title="Login" style="width:300px;height:180px;">
	<form id='loginform' style="padding:10px 20px 10px 40px;" method="post">
		<p>Name: <input id="loginName" name="loginName" style="padding:1px;text-align:left;" type="text"></p>
		<p>Password: <input id="password" name="password" style="padding:1px;text-align:left;" type="password"></p>
		<div style="padding:5px;text-align:center;">
			<a href="#" class="easyui-linkbutton" icon="icon-ok" onclick="submitForm()">Login</a>
			<a href="#" class="easyui-linkbutton" icon="icon-cancel" onclick="clearForm()">Cancel</a>
		</div>
	</form>
</div>
</body>
</html>
