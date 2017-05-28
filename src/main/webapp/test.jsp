<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test Ajax Json</title>
<%@ include file="/base.jsp"%>

<script type="text/javascript">
	/*
	 function getJson() {
	 var xhr;
	 if (window.ActiveXObject) {
	 xhr = new ActiveXObject('Microsoft.XMLHTTP');
	 } else if (window.XMLHttpRequest) {
	 xhr = new XMLHttpRequest();
	 } else {
	 throw new Error('Ajax is not supported by this browser');
	 }
	
	 //1
	 xhr.onreadystatechange = function(event) {
	 if (xhr.readyState == 4) {
	 if ((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304) {
	 var str = xhr.responseText;
	 alert(eval(str));
	 } else {
	 alter("Request was unsuccessful:" + xhr.status);
	 }
	 }
	 }
	
	 //2
	 xhr.onload = function(event) {
	 if ((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304) {
	 var str = xhr.responseText;
	 alert(JSON.parse(str));	//JSON.stringify
	 } else {
	 alter("Request was unsuccessful:" + xhr.status);
	 }
	 }

	 xhr.open("GET", "/shop/menu/getUserMenu", true);//建立和服务器的连接，true是异步
	 xhr.send(null);//发送请求 
	 }
	 */

	/*
	$(function() {
		$("#getUserMenu").click(function(event) {
			$.getJSON("/shop/menu/getUserMenu", null, function(response) {
				var result = "";
				for(var menu in response){
					result += "id:" + response[menu].id + " name:" + response[menu].name + "</br>";
				}
				alert(result);
				$("#resultdiv").html(result);
			});
		});
	 */

	/*
	$(function() {
		$("#getUserMenu").click(function(event) {
			$.getJSON("/shop/menu/getUserMenu", null, function(response) {
				alert(response);
				$("#resultdiv").html(response);
			});
		});
	});
	 */

	$(function() {
		$('#layout_west_tree').tree({
			url : '${path}/menu/getUserMenu',
			loadFilter : function(data) {
				return convert2MenuTreeList(data);
			},
			onClick : function(node) {
				var opts = {
					title : node.text,
					border : false,
					closable : true,
					fit : true,
					iconCls : node.iconCls
				};
				var url = node.attributes;
				if (url && url.indexOf("http") == -1) {
					url = '${path}' + url;
					opts.content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
					addTab(opts);
				}
			}
		});
	});

	function addTab(opts) {
		var t = $('#index_tabs');
		if (t.tabs('exists', opts.title)) {
			t.tabs('select', opts.title);
		} else {
			t.tabs('add', opts);
		}
	}

	function convert2MenuTree(menu) {
		var menuTree = {
			id : menu.id,
			text : menu.name,
			checked : 'false',
			attributes : menu.url,
			iconCls : ''
		}
		if (menu.childs.length != 0) {
			menuTree.children = convert2MenuTreeList(menu.childs);
			menuTree.state = 'closed';
		} else {
			menuTree.children = [];
			menuTree.state = '';
		}
		return menuTree;
	}

	function convert2MenuTreeList(data) {
		var menus = [];
		$.each(data, function(index, menu) {
			menus[index] = convert2MenuTree(menu);
		});
		return menus;
	}
</script>

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