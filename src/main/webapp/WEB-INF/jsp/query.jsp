<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/base.jsp"%>

<script language="javascript">

function openPage(pageNo){
	$("#pageNo").attr("value",pageNo);
	$("#testquery").submit();
}

</script>
<div>
	<c:forEach var="element" items="${page.elements}">
		${element.id} &nbsp&nbsp&nbsp&nbsp ${element.name} 
		<br>
	</c:forEach>
	
	<form action="${path}/test/getAllPerPage" method="post" id="testquery" name="testquery">
		第${page.pageNo}页&nbsp&nbsp${totalPages}
		<c:if test="${page.pageNo>1}">
			<input id="buttonprev" type="button" value="上一页" onclick="openPage(${page.pageNo-1})" />
		</c:if>
		
		<c:if test="${page.pageNo<page.totalPages}">
			<input id="buttonnext" type="button" value="下一页" onclick="openPage(${page.pageNo+1})" />
		</c:if>
		
		<input name="pageNo" id="pageNo" type="hidden" value="" />
	</form>
</div>