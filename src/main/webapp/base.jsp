<%@ page language="java" pageEncoding="UTF-8"%>
<title>JOB</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--ctxPath--%>
<c:set var="ctxPath" value="${pageContext.request.contextPath}" />
<%--项目路径 --%>
<c:set var="path" value="${ctxPath}" />
<%--静态文件目录 --%>
<c:set var="staticPath" value="${ctxPath}/statics" />
<link rel="stylesheet" href="${staticPath}/js/jquery-easyui-1.4.1/themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="${staticPath}/js/jquery-easyui-1.4.1/themes/icon.css" type="text/css"></link>
<script type="text/javascript" src="${staticPath}/js/jquery-easyui-1.4.1/jquery-1.11.1.js"></script>
<script type="text/javascript" src="${staticPath}/js/jquery-easyui-1.4.1/jquery.easyui.js"></script>
<script type="text/javascript" src="${staticPath}/js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
