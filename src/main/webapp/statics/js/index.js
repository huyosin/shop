$(function() {
	$('#layout_west_tree').tree({
		url : basePath + '/menu/getUserMenu',
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
				url = basePath + url;
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