function showMessage(msg){
	$.messager.show({
	
	       title:'提示',
	
	       msg:msg,
	
	       timeout:5000,
	
	       showType:'slide'
	
	});
}

function showMessage(msg,timeout){
	$.messager.show({
		
	       title:'提示',
	
	       msg:msg,
	
	       timeout:timeout,
	
	       showType:'slide'
	
	});
}

function convert2DataGrid(data) {
	var dataGrid = {
		total : data.total,
		rows : data.records
	}
	return dataGrid;
}

/**
 * 
 * @requires jQuery
 * 
 * 将form表单元素的值序列化成对象
 * 
 * @returns object
 */
$.serializeObject = function(form) {
    var o = {};
    $.each(form.serializeArray(), function(index) {
        if (o[this['name']]) {
            o[this['name']] = o[this['name']] + "," + this['value'];
        } else {
            o[this['name']] = this['value'];
        }
    });
    return o;
};

/**
 * 
 * 增加formatString功能
 * 
 * 使用方法：$.formatString('字符串{0}字符串{1}字符串','第一个变量','第二个变量');
 * 
 * @returns 格式化后的字符串
 */
$.formatString = function(str) {
    for ( var i = 0; i < arguments.length - 1; i++) {
        str = str.replace("{" + i + "}", arguments[i + 1]);
    }
    return str;
    console.log(str);
};

/**
 * 
 * @requires jQuery,EasyUI
 * 
 * 创建一个模式化的dialog
 * 
 * @returns $.modalDialog.handler 这个handler代表弹出的dialog句柄
 * 
 * @returns $.modalDialog.xxx 这个xxx是可以自己定义名称，主要用在弹窗关闭时，刷新某些对象的操作，可以将xxx这个对象预定义好
 */
$.modalDialog = function(options) {
    if ($.modalDialog.handler == undefined) {// 避免重复弹出
        var opts = $.extend({
            title : '',
            width : 840,
            height : 680,
            modal : true,
            onClose : function() {
                $.modalDialog.handler = undefined;
                $(this).dialog('destroy');
            },
            onOpen : function() {
            }
        }, options);
        opts.modal = true;// 强制此dialog为模式化，无视传递过来的modal参数
        return $.modalDialog.handler = $('<div/>').dialog(opts);
    }
};