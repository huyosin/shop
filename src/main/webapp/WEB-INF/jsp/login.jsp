<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>用户登录-MonO-专业的java学习培训平台</title>
<meta name="keywords" content="MonO JAVA研发">
<meta name="description" content="JAVA研发！">
<script type="text/javascript" src="${staticPath}/js/login.js"
	charset="utf-8"></script>
<style type="text/css">
.login_item {
	margin: 10px auto;
}

.login_item span {
	display: inline-block;
	width: 60px;
	text-align: right;
}
</style>

</head>
<body>
	<div id="win" class="easyui-window" title="Login"
		style="width: 350px; height: 200px;" collapsible='false'
		minimizable='false' maximizable='false' closable='false'
		draggable='false' resizable='false'>
		<form id='loginform' style="padding: 10px 20px 10px 40px;"
			method="post">
			<!-- 
		<p>Name: <input id="loginName" name="loginName" style="padding:1px;text-align:left;" type="text"></p>
		<p>Password: <input id="password" name="password" style="padding:1px;text-align:left;" type="password"></p>
		<div style="padding:5px;text-align:center;">
			<a href="#" class="easyui-linkbutton" icon="icon-ok" onclick="submitForm()">Login</a>
			<a href="#" class="easyui-linkbutton" icon="icon-cancel" onclick="clearForm()">Cancel</a>
		</div>
		 -->
			<div class="login_item">
				<span>用户名：</span><input type="text" name="loginName"
					class="easyui-validatebox"
					data-options="required:true,missingMessage:'请填写登录名'" />
			</div>
			<div class="login_item">
				<span>密 码：</span><input type="password" name="password"
					class="easyui-validatebox"
					data-options="required:true,missingMessage:'请填写密码'" />
			</div>
			<div style="padding: 5px; text-align: center;">
				<a href="#" class="easyui-linkbutton" icon="icon-ok"
					onclick="submitForm()">Login</a> <a href="#"
					class="easyui-linkbutton" icon="icon-cancel" onclick="clearForm()">Cancel</a>
			</div>
		</form>
	</div>
</body>
</html>
