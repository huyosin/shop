$(function() {    
	$('#layout_west_tree').tree({
		url : basePath + '/menu/getUserMenuTree',
//		loadFilter : function(data) {
//			console.log(JSON.stringify(data));
//			return data;
//			//return convert2MenuTreeList(data);
//		},
		onClick : function(node) {
			if(node.attributes && node.attributes.url){
				var url = node.attributes.url;
				var opts = {
					title : node.text,
					closable : true,
					fit : true
				};
				if( url.indexOf("http") == -1 ){
					url = basePath + url;
				}
				opts.href = url;
				addTab(opts);
			}
//			if(node.attributes){
//				var url = node.attributes;
//				var opts = {
//					title : node.text,
//					closable : true,
//					fit : true
//				};
//				if( url.indexOf("http") == -1 ){
//					url = basePath + url;
//				}
//				opts.href = url;
//				addTab(opts);
//			}
		}
	});
});

function addTab(opts) {
	var index_tabs = $('#index_tabs');
	if (index_tabs.tabs('exists', opts.title)) {
		index_tabs.tabs('select', opts.title);
	} else {
		index_tabs.tabs('add', opts);
	}
}

//function convert2MenuTree(menu) {
//	var menuTree = {
//		id : menu.id,
//		text : menu.name,
//		checked : 'false',
//		iconCls : ''
//	}
//	if(menu.url && menu.url.length != 0){
//		menuTree.attributes = menu.url;
//	}
//	if (menu.childMenus.length != 0) {
//		menuTree.children = convert2MenuTreeList(menu.childMenus);
//		menuTree.state = 'closed';
//	} else {
//		menuTree.children = [];
//		menuTree.state = '';
//	}
//	console.log(menuTree);
//	return menuTree;
//}
//
//function convert2MenuTreeList(data) {
//	var menus = [];
//	$.each(data, function(index, menu) {
//		menus[index] = convert2MenuTree(menu);
//	});
//	return menus;
//}