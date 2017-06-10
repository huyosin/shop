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
        success:function(result){
            window.location.href = basePath + result;
        }
    });
});

function submitForm() {
	$('#loginform').submit();
}

function clearForm() {
	$('#loginform').form('clear');
}
