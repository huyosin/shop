<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/base.jsp"%>

<script language="javascript">
	$(function() {
		$('#testDataGrid').datagrid({
			url : basePath + '/test/getAll',
			method : 'POST',
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
			queryParams:{
				pageNo : pageNo
			}
		});
		alert(pageNo);
	}
</script>
<div>
	<table>fdsfdfds</table>
	<table id="testDataGrid" class="easyui-datagrid"></table>
</div>