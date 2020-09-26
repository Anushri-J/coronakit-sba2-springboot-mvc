<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping cart</title>
</head>
<body>
	<c:choose>
		<c:when test="${kits==null || kits.isEmpty() }">
			<p>No Products Found</p>
		</c:when>
		<c:otherwise>
			<form:form action="${pageContext.request.contextPath}/user/checkout"
				method="POST">

				<table border="1" cellspacing="5px" cellpadding="5px">
					<tr>
						<th>Product Id</th>
						<th>Quantity</th>
						<th>Amount</th>
					</tr>
					<c:forEach items="${kits }" var="item">
						<input type="hidden" name="kitId" value="${item.id}" />
						<tr>
							<td>${item.productId }</td>
							<td>${item.quantity }</td>
							<td>${item.amount }</td>
						</tr>
					</c:forEach>
				</table>
				<br />
				<span>Delivery Address</span>
				<input name="deliveryAddress" type="textBox">
				<br />
				<span>Order Date</span>
				<input type="text" name="orderDate" readOnly
					value="26-09-2020 13:04" />
				<p></p>
				<button>Checkout</button>
			</form:form>
		</c:otherwise>
	</c:choose>
</body>
</html>