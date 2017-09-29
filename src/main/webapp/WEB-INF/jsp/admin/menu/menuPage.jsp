<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="easyui-layout" data-options="fit:true,border:false">
	
	<div data-options="region:'west',border:true" style="width:200px;">
		<div class="easyui-accordion" data-options="border:false,fit:true">
			<ul id="menu_tree"></ul>
			</div>
	</div>

	<div id="editMenu" data-options="region:'center',border:true" >
		<div data-options="border:true">
			<a onclick="showAddMenuFun()" href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'">添加</a>
		</div>
		
		<div data-options="border:true">
			<form id="editMenuForm" method="post" style="position:absolute,z-index:1">
				<table>
					<tr>
						<th>id</th>
						<td><input id="menuId" name="id" readonly="readonly"/></td>
					</tr>
					<tr>
						<th>名称</th>
						<td><input name="name" class="easyui-validatebox" data-options="required:true" /></td>
					</tr>
					<tr>
						<th>url</th>
						<td><input name="url" type="text"/></td>
					</tr>
					<tr>
						<th>parentMenu</th>
						<td><input id="parentComboBox" name="pid" type="text" class="easyui-validatebox" data-options="required:true" /></td>
					</tr>
					<tr>
						<th>status</th>
						<td><input name="status" type="text" class="easyui-validatebox" data-options="required:true" /></td>
					</tr>
					<tr>
						<th>type</th>
						<td><input name="type" type="text" class="easyui-validatebox" data-options="required:true" /></td>
					</tr>
					<tr>
						<th>description</th>
						<td><input name="description" type="text" /></td>
					</tr>
					<tr>
						<th>createTime</th>
						<td><input name="createTime" type="text" class="easyui-datetimebox" readonly="readonly" /></td>
					</tr>
					<tr>
						<td><a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'" onclick="editMenuFun()">编辑</a></td>
						<td><a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-remove'" onclick="deleteMenuFun()">删除</a></td>
					</tr>
				</table>
			</form>
			
			<form id="addMenuForm" method="post" style="position:absolute,z-index:2">
				<table>
					<tr>
						<th>名称</th>
						<td><input name="name" class="easyui-validatebox" data-options="required:true" /></td>
					</tr>
					<tr>
						<th>url</th>
						<td><input name="url" type="text" /></td>
					</tr>
					<tr>
						<th>parentMenu</th>
						<td><input id="parentComboBox" name="pid" type="text" /></td>
					</tr>
					<tr>
						<th>status</th>
						<td><input name="status" type="text" class="easyui-validatebox" data-options="required:true" /></td>
					</tr>
					<tr>
						<th>type</th>
						<td><input name="type" type="text" class="easyui-validatebox" data-options="required:true" /></td>
					</tr>
					<tr>
						<th>description</th>
						<td><input name="description" type="text" /></td>
					</tr>
					<tr>
						<td><a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-ok'" onclick="addMenuFun()">确认</a></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>

<script language="javascript">
	$('#editMenuForm').css("visibility","hidden");
	$('#addMenuForm').css("visibility","hidden");
	
	$('#editMenuForm').form({
        url : basePath + '/menu/edit',
        onSubmit : function() {
            return $(this).form('validate');
        },
        success : function(result) {
            result = $.parseJSON(result);
            if (result.code == 200) {
            	$('#menu_tree').tree('reload')
            	$.messager.alert('消息', '修改成功', 'message');
            } else {
                $.messager.alert('错误', result.msg, 'error');
            }
        }
    });
	
	$('#addMenuForm').form({
        url : basePath + '/menu/add',
        onSubmit : function() {
            return $(this).form('validate');
        },
        success : function(result) {
            result = $.parseJSON(result);
            if (result.code == 200) {
            	$('#menu_tree').tree('reload')
            	$.messager.alert('消息', '新增成功', 'message');
            } else {
                $.messager.alert('错误', result.msg, 'error');
            }
        }
    });
	
	$('#editMenuForm').find('#parentComboBox').combobox({
		url : basePath + '/menu/getTopMenu',
	    valueField:'id',
	    textField:'name',
	    required:true,
	    loadFilter:function(data){  
			var obj={};  
			obj.id='0';  
			obj.name='根节点'; 
			data.splice(0,0,obj);//在数组0位置插入obj,不删除原来的元素
			return data;  
		}  
	});
	
	$('#addMenuForm').find('#parentComboBox').combobox({
		url : basePath + '/menu/getTopMenu',
	    valueField:'id',
	    textField:'name',
	    required:true,
	    loadFilter:function(data){  
			var obj={};  
			obj.id='0';  
			obj.name='根节点';  
			data.splice(0,0,obj);//在数组0位置插入obj,不删除原来的元素
			return data;  
		}  
	});
	
	var menuTree;
	menuTree = $('#menu_tree').tree({
		url : basePath + '/menu/getMenuTree',
		onClick : function(node){
			$('#editMenuForm').css("visibility","visible");
			$('#addMenuForm').css("visibility","hidden");
			$('#editMenuForm').form("load", basePath + '/menu/getMenu?id=' + node.id);
		}
	});
	
    function editMenuFun() {
    	$('#editMenuForm').submit();
    }
    
    function addMenuFun() {
    	$('#addMenuForm').submit();
    }
	
    function showAddMenuFun() {
    	$('#editMenuForm').css({"visibility":"hidden","position":"absolute","z-index":"1"});
    	$('#addMenuForm').css({"visibility":"visible","position":"absolute","z-index":"999"});
    }
    
    function deleteMenuFun(id) {
    	$.messager.confirm('询问', '您是否要删除当前用户？', function(yes) {
            if (yes) {
				$.post(basePath + '/menu/delete', {
				    id : $("#editMenuForm").find("#menuId").val()
				}, function(result) {
				    if (result.code == 200) {
				        $.messager.alert('提示', result.msg, 'info');
				        menuTree.tree("reload");
						$('#editMenuForm').css("visibility","hidden");
				    }else{
				        $.messager.alert('错误', result.msg, 'error');
				    }
				}, 'JSON');
            }
        });
    }
</script>