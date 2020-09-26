<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@taglib
	uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
</head>
<body>
	<h1>This is Admin dashboard</h1>
	<h2>Select the action to perform</h2>
	<a href="${pageContext.request.contextPath}/home">Home</a>
	<span>|</span>
	<a href="${pageContext.request.contextPath}/admin/product-list">Items
		List</a>
	<span>|</span>
	<a href="${pageContext.request.contextPath}/admin/product-entry">Add
		New</a>
	<span>|</span>
	<a href="${pageContext.request.contextPath}/logout">Log Out</a>

	<c:choose>
		<c:when test="${msg!=null}">
			<h2>${msg }</h2>
		</c:when>
	</c:choose>
</body>
</html>