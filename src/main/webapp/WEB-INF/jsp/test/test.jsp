<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'north',border:false">
		<form id="searchTestForm">
			<table>
				<tr>
					<th>名称:</th>
					<td><input name="name" placeholder="请输入名称" /></td>
					<th>创建时间:</th>
					<td>
						<input name="createdateStart" type="text" class="easyui-datebox" />至 
						<input name="createdateEnd" type="text" class="easyui-datebox" /> 
						<a href="javascript:void(0);" class="easyui-linkbutton" onclick="searchTestFun();">查询</a> 
						<a href="javascript:void(0);" class="easyui-linkbutton" onclick="cleanTestFun();">清空</a>
					</td>
				</tr>
			</table>
		</form>
	</div>

	<div data-options="region:'center',border:false">
		<table id="testDataGrid" data-options="fit:true,border:true"></table>
	</div>
</div>

<div id="testToolbar" style="display:none">
    <shiro:hasPermission name="/test/add">
        <a onclick="addTestFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'">添加</a>
    </shiro:hasPermission>
</div>

<script language="javascript">
	var testDataGrid;
	$(function() {

		testDataGrid = $('#testDataGrid').datagrid({
			url : basePath + '/test/selectTestVoPage',
			method : "POST",
			fit : true,
			striped : true,
			rownumbers : false,
			pagination : true,
			pageNumber : 1,
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			columns : [ [ {
				field : 'id',
				title : 'ID',
				width : '30',
				sortable : true
			}, {
				field : 'name',
				title : 'Name',
				width : '100',
				sortable : true
			}, {
				field : 'date',
				title : 'Date',
				width : '70',
				sortable : true
			}, {
				field : 'mdate',
				title : 'Mdate',
				width : '120',
				sortable : true
			} , {
				field : 'action',
                title : '操作',
                width : 130,
                formatter : function(value, row, index) {
                    var str = '';
                    str += '<shiro:hasPermission name="/test/edit">';
                    str += $.formatString('<a href="javascript:void(0)" class="test-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'fi-pencil icon-blue\'" onclick="editTestFun(\'{0}\');" >编辑</a>', row.id);
                    str += '</shiro:hasPermission>';
                   	str += '<shiro:hasPermission name="/test/delete">';
                    str += '|';
                    str += $.formatString('<a href="javascript:void(0)" class="test-easyui-linkbutton-del" data-options="plain:true,iconCls:\'fi-x icon-red\'" onclick="deleteTestFun(\'{0}\');" >删除</a>', row.id);
                    str += '</shiro:hasPermission>';
                    return str;
                }
			} ] ],
			loadFilter : function(data) {
				return convert2DataGrid(data);
			},
            onLoadSuccess:function(data){
                $('.test-easyui-linkbutton-edit').linkbutton({text:'编辑',iconCls: 'icon-edit'});
                $('.test-easyui-linkbutton-del').linkbutton({text:'删除',iconCls: 'icon-remove'});
            },
            toolbar : '#testToolbar'
		});
	});

	function searchTestFun() {
		testDataGrid.datagrid('load', $.serializeObject($('#searchTestForm')));
	}

	function cleanTestFun() {
		$('#searchTestForm input').val('');
		testDataGrid.datagrid('load', {});
	}
	
    function editTestFun(id) {
        if (id == undefined) {
            var rows = testDataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {
            testDataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.modalDialog({
            title : '编辑',
            width : 500,
            height : 300,
            href : basePath + '/test/editPage?id=' + id,
            buttons : [ {	 
	            	text : '确定',
					handler : function() {
						parent.$.modalDialog.openner_dataGrid = testDataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
						var f = parent.$.modalDialog.handler.find('#testEditForm');
						f.submit();
					}
                }]
        });
    }
    
    function addTestFun() {
        parent.$.modalDialog({
            title : '添加',
            width : 500,
            height : 300,
            href : basePath + '/test/addPage',
            buttons : [ {
                text : '添加',
                handler : function() {
                    parent.$.modalDialog.openner_dataGrid = testDataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#testAddForm');
                    f.submit();
                }
            } ]
        });
    }
    
    function deleteTestFun(id) {
        if (id == undefined) {//点击右键菜单才会触发这个
            var rows = testDataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {//点击操作里面的删除图标会触发这个
        	testDataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.messager.confirm('询问', '您是否要删除当前用户？', function(yes) {
            if (yes) {
				$.post(basePath + '/test/delete', {
				    id : id
				}, function(result) {
				    if (result.code == 200) {
				        parent.$.messager.alert('提示', result.msg, 'info');
				        testDataGrid.datagrid('reload');
				    }
				}, 'JSON');
            }
        });
    }
</script>