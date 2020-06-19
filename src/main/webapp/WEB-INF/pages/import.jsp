<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
    String systemName = "管理系统";
    String basePath = request.getContextPath();
%>

<c:set var="systemName" value="<%=systemName%>"/>
<c:set var="basePath" value="<%=basePath%>"/>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>


