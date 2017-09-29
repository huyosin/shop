<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script language="javascript">
$('#testEditForm').form({
    url : basePath + '/test/edit',
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

$('#testEditForm').form('load', basePath + '/test/getTest?id=' + ${id});
</script>

<form id="editMenuForm" method="post">
	<table>
		<tr>
			<th>id</th>
			<td><input id="menuId" name="id" readonly="readonly"/></td>
		</tr>
		<tr>
			<th>名称</th>
			<td><input name="name" placeholder="请输入名称" /></td>
		</tr>
		<tr>
			<th>url</th>
			<td><input name="url" type="text"/></td>
		</tr>
		<tr>
			<th>parentMenu</th>
			<td><input id="parentComboBox" name="pid" type="text" /></td>
		</tr>
		<tr>
			<th>status</th>
			<td><input name="status" type="text" /></td>
		</tr>
		<tr>
			<th>type</th>
			<td><input name="type" type="text" /></td>
		</tr>
		<tr>
			<th>description</th>
			<td><input name="description" type="text" /></td>
		</tr>
		<tr>
			<th>createTime</th>
			<td><input name="createTime" type="text" class="easyui-datebox" /></td>
		</tr>
		<tr>
			<td><a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'" onclick="editMenuFun()">编辑</a></td>
			<td><a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-remove'" onclick="deleteMenuFun()">删除</a></td>
		</tr>
	</table>
</form>