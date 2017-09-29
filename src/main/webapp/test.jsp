<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/base.jsp"%>

<script language="javascript">
	$(function() {
		$('#testDataGrid').datagrid({
			url : basePath + '/test/getAll',
			method : 'POST',
			pagination : true,
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			columns : [ [ {
				field : 'id',
				title : 'id',
				width : 100
			}, {
				field : 'name',
				title : 'Name',
				width : 100
			} ] ],
			loadFilter : function(data) {
				return convert2DataGrid(data);
			}
		});
	});

	function convert2DataGrid(data) {
		var testGrid = {
			total : data.totalElements,
			rows : data.elements
		}
		return testGrid;
	}

	function openPage(pageNo) {
		$('#testDataGrid').datagrid({
			queryParams : {
				pageNo : pageNo
			}
		});
		alert(pageNo);
	}
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',fit:true,border:false">
		<table id="testDataGrid" data-options="fit:true,border:false"></table>
	</div>
</div>