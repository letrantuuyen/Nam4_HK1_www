<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="aaa" modelAttribute="Order"  method="POST">
	HELLO
	<br>
	<a>${phone}</a>
	<br>
	<a>${address}</a>
	<br>
	<a>${quantity}</a>
	<br>
	<a>${theId}</a>
	<a>${product.id}</a>
	<a>${order.id}</a>
	<a>${orderDetail.id}</a>
	</form:form>
</body>
</html>