<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
$(function() {
    $('#testAddForm').form({
        url : basePath + '/test/add',
        onSubmit : function() {
            return $(this).form('validate');
        },
        success : function(result) {
            result = $.parseJSON(result);
            if (result.code == 200) {
                parent.$.modalDialog.openner_dataGrid.datagrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_dataGrid这个对象，是因为test.jsp页面预定义好了
                parent.$.modalDialog.handler.dialog('close');
            } else {
                parent.$.messager.alert('错误', result.msg, 'error');
            }
        }
    });
    
});
</script>
<div>
	<form id="testAddForm" method="post">
		<table class="grid">
			<tr>
				<td>名称</td>
				<td>
					<input name="name" type="text" placeholder="请输入名称" class="easyui-validatebox" data-options="required:true" >
				</td>
			</tr>
			<tr>
				<td>Date</td>
				<td>
					<input name="date" type="text" class="easyui-datebox"  />
				</td>
			</tr>
			<tr>
				<td>MDate</td>
				<td>
					<input name="mdate" type="text" class="easyui-datetimebox" />
				</td>
			</tr>
		</table>
	</form>
</div>