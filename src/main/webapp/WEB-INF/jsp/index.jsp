<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
<script type="text/javascript" src="${staticPath}/js/index.js" charset="utf-8"> </script>
</head>
<body class="easyui-layout">

	<!-- <button onclick="getJson()">getjson</button>
	<button id="getUserMenu">getjson</button>
	<div id="resultdiv"></div>
	 -->

	<div data-options="region:'north',border:false"
		style="overflow: hidden;">
		<div align="center">
			<span class="header" style="height: 500px;"> 欢迎！！！！！！！！！！！！！！</br>
				good</br> hahah</br>
			</span>
		</div>
	</div>

	<div data-options="region:'west',split:true" title="菜单"
		style="width: 250px; overflow: hidden; overflow-y: auto; padding: 0px">
		<div class="well well-small" style="padding: 5px 5px 5px 5px;">
			<ul id="layout_west_tree"></ul>
		</div>
	</div>

	<div data-options="region:'center'" style="overflow: hidden;">
		<div id="index_tabs" class="easyui-tabs" fit="true" border="false"
			plain="true">
			<div title="首页" data-options="iconCls:'fi-home',border:false"
				style="overflow: hidden;">首页</div>
		</div>

	</div>
	<div data-options="region:'south',border:false"
		style="height: 30px; line-height: 30px; overflow: hidden; text-align: center; background-color: #eee">
		Copyright © 2017 power by <a href="Mailto:huyosin@sina.com">MonO</a>
	</div>

</body>
</html>