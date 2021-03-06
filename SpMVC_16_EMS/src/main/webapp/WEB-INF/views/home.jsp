<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/views/include/include-header.jspf" %>

<title>MY EMS</title>

</head>
<body>
<header>
	<div class="jumbotron text-center" style="margin-bottom:0">
  		<h1>MY EMS</h1>
	</div>
</header>
<%@ include file="/WEB-INF/views/include/include-nav.jspf" %>

<c:choose>
	<c:when test="${BODY == 'VIEW'}">
		<%@ include file="/WEB-INF/views/body/ems/view.jsp" %>	
	</c:when>
	<c:when test="${BODY == 'WRITE'}">
		<%@ include file="/WEB-INF/views/body/ems/write.jsp" %>	
	</c:when>
	<c:otherwise>
		<%@ include file="/WEB-INF/views/body/ems/list.jsp" %>
		<button class="btn btn-success" id="btn-send" onclick="location.href='${rootPath}/ems/input'">메일보내기</button>	
	</c:otherwise>
</c:choose>




</body>
</html>