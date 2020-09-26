<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@ taglib prefix="c"
	uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Final Order Summary</title>
</head>
<body>
<body>
<h2>Thanks for shopping with us</h2>
<h3>Here is your order summary</h3>
	<c:choose>
		<c:when test="${coronaKit==null }">
			<p>Nothing to Order!</p>
		</c:when>
		<c:otherwise>
		<table border="1" cellspacing="5px" cellpadding="5px">
		        <tr>
					<th>Corona Kit ID</th>
					<th>OrderDate</th>
					<th>Delivery Address</th>
					<th>Total Amount</th>
				</tr>
		     <tr>
		      <td>${coronaKit.id}</td>
		      <td>${coronaKit.orderDate} </td>
		      <td>${coronaKit.deliveryAddress}</td>
		      <td>${coronaKit.totalAmount}</td>
		    </tr>
		</c:otherwise>
	</c:choose>

</body>
</html>