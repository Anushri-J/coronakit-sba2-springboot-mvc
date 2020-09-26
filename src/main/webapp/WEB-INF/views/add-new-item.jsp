<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new product</title>
</head>
<jsp:include page="${pageContext.request.contextPath }/header" />
<form:form action='${isNew?pageContext.request.contextPath.concat("/admin/product-save"):pageContext.request.contextPath.concat("/admin/product-save") }' method="POST" modelAttribute="item">
		<div>
			<form:label path="id">Id: </form:label>
			<form:input type="number" path="id" readonly="${!isNew}"/>
			<form:errors path="id"/>
		</div>
		<div>
			<form:label path="productName">productName: </form:label>
			<form:input type="text" path="productName" />
			<form:errors path="productName"/>
		</div>
		<div>
			<form:label path="cost">Cost: </form:label>
			<form:input type="integer" path="cost" />
			<form:errors path="cost"/>			
		</div>
		<div>
			<form:label path="productDescription">Product Description: </form:label>
			<form:input type="text" path="productDescription" />
			<form:errors path="productDescription"/>		
		</div>
		<button>SAVE</button>		
	</form:form>
<body>
</body>
</html>