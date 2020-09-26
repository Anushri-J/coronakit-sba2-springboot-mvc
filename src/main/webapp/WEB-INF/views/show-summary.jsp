<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@ taglib prefix="c"
	uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
	<c:choose>
		<c:when test="${coronaKit==null }">
			<p>Nothing to Order!</p>
		</c:when>
		<c:otherwise>
		<p>Corona Kit ID ${coronaKit.id}</p>
		 <p> OrderDate  ${coronaKit.orderDate}</p>
		 <p> Delivery Address  ${coronaKit.deliveryAddress}</p>
		 <p>Total Amount  ${coronaKit.totalAmount}</p>
		</c:otherwise>
	</c:choose>

</body>
</html>