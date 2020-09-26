<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to Corona-Kit Home</h1>

	<jsp:include page="${pageContext.request.contextPath}/header" />

	<c:if test="${msg != null}">
		<p>
			<strong>${msg }</strong>
	</c:if>
	<hr />
	<a href="${pageContext.request.contextPath}/custom-login"><input
		type="button" value="Login" /></a>
	<hr />
</body>
</html>