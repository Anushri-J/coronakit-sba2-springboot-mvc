<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin products List</title>
</head>
<body>
<jsp:include page="/header" />
	<h3>Products</h3>
	<c:choose>
		<c:when test="${products==null || products.isEmpty() }">
			<p>No Products Found</p>
		</c:when>
		<c:otherwise>
			<table border="1" cellspacing="5px" cellpadding="5px">
				<tr>
					<th>Id</th>
					<th>Product Name</th>
					<th>Cost</th>
					<th>Product Description</th>
				</tr>
				<c:forEach items="${products }" var="item">
					<tr>
					<td>${item.id }</td>
					<td>${item.productName }</td>
					<td>${item.cost }</td>
					<td>${item.productDescription }</td>
					<td>
                        <a href="${pageContext.request.contextPath }/admin/deleteItem?productId=${item.id }">DELETE</a> <span>|</span>
                    </td>
				</tr>				
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>