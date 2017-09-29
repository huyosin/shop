// 判断时候在Iframe框架内,在则刷新父页面
//if (self != top) {
//    parent.location.reload(true);
//    if (!!(window.attachEvent && !window.opera)) {
//        document.execCommand("stop");
//    } else {
//        window.stop();
//    }
//}

$(function () {
    // 登录
    $('#loginform').form({
        url: basePath + '/login',
        success:function(data){
            var result = JSON.parse(data);
        	if(result.code == 200){
        		window.location.href = basePath + "/index";
        	}else{
        		showMessage(result.msg);
        	}
        }
    });
});

function submitForm() {
	$('#loginform').submit();
}

function clearForm() {
	$('#loginform').form('clear');
}
