<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User home</title>
</head>
<body>
<h1>Welcome</h1>
	<h2>Select the action to perform</h2>
	<a href="${pageContext.request.contextPath}/home">Home</a>
	<span>|</span>
	<a href="${pageContext.request.contextPath}/user/show-list">Items
		List</a>
	<span>|</span>
	<a href="${pageContext.request.contextPath}/logout">Log Out</a>

	<c:choose>
		<c:when test="${msg!=null}">
			<h2>${msg }</h2>
		</c:when>
	</c:choose>	
</body>
</html>