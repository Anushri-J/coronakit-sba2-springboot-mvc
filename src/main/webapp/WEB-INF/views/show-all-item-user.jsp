<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show all items users</title>
</head>
<body>
<jsp:include page="/header" />
	<h3>Products Available</h3>
	<h4>Select the products you want to buy and click on Add to Cart</h4>
	<form:form action="${pageContext.request.contextPath}/user/show-kit" method="POST">
	<c:choose>
		<c:when test="${products==null || products.isEmpty() }">
			<p>No Products Found</p>
		</c:when>
		<c:otherwise>
			<table border="1" cellspacing="5px" cellpadding="5px">
				<tr>
					<th>Id</th>
					<th>Product Name</th>
					<th>Product Description</th>
					<th>Cost</th>
					<th>Quantity</th>
				</tr>
				<c:forEach items="${products }" var="item">
					<tr>
					<td><input type="checkbox" name=${item.id} /> </td> 
					<td>${item.productName }</td>
					<td>${item.productDescription }</td>
					<td>${item.cost }</td>
					<td><input type="number" name=${item.id}_quantity value="1" /></td>
				</tr>				
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
	<br/>
	<br/>
	<input type="submit" value="Add to Cart" />
	</form:form>	
</body>
</html>