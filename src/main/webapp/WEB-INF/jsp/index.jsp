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
<body  class="easyui-layout">
	<div data-options="region:'north',border:true,split:true">
		<div align="center">
			<span class="header"> 欢迎！！！！！！！！！！！！！！</br>
				good</br> hahah</br>
			</span>
		</div>
	</div>

	<div data-options="region:'west',border:true,split:true" title="菜单" style="width: 250px; overflow: hidden; overflow-y: auto; padding: 0px">
    	<div class="easyui-accordion" data-options="border:false,fit:true"> 
			<ul id="layout_west_tree"></ul>
		</div>
	</div>
	
	<div data-options="region:'center',border:true">
		<div id="index_tabs" class="easyui-tabs" data-options="border:false,fit:true">
			<div title="首页" data-options="iconCls:'fi-home',border:true,closable:false">首页</div>
		</div>
	</div>
	
	<div data-options="region:'south',border:true,split:true" style="height: 25px;"><div align="center">
			Copyright 2017 power by <a href="Mailto:huyosin@sina.com">MonO</a>
		</div>
	</div>
</body>
</html>