<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" isELIgnored="false" session="false" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--ctxPath--%>
<c:set var="ctxPath" value="${pageContext.request.contextPath}" />
<%--项目路径 --%>
<c:set var="path" value="${ctxPath}" />
<%--静态文件目录 --%>
<c:set var="staticPath" value="${ctxPath}/statics" />

<link rel="stylesheet" href="${staticPath}/js/jquery-easyui-1.3.4/themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="${staticPath}/js/jquery-easyui-1.3.4/themes/icon.css" type="text/css"></link>
<script type="text/javascript" src="${staticPath}/js/jquery-easyui-1.3.4/jquery.min.js"></script>
<script type="text/javascript" src="${staticPath}/js/jquery-easyui-1.3.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${staticPath}/js/jquery-easyui-1.3.4/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${staticPath}/js/My97DatePicker/WdatePicker.js"></script>
<!-- [通用JS] -->
<script type="text/javascript" src="${staticPath}/js/base.js"></script>
<%-- [自定义样式] --%>
<link rel="stylesheet" type="text/css" href="${staticPath}/css/shop.css" />
<script type="text/javascript">
    var basePath = "${path}";
</script>