<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Price Item</th>
		</tr>
		<c:forEach var="cart_item" items="${cart}">
			<tr>
				<td>${cart_item.getProduct().name}</td>
				<td>${cart_item.getProduct().price}</td>
				<td>${cart_item.getQuantity()}</td>
				<td>${cart_item.getQuantity() * cart_item.getProduct().price}</td>
			</tr>
		</c:forEach>
		<tr>
			<td>Total : <c:out value="${sessionScope.total}" /></td>
		</tr>
	</table>
	<a href="getAllProducts">Product List</a>
</body>
</html>