<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table >
	
		<tr>
			<th>Id<th>
			<th>LastName<th>
			<th>Email<th>
		</tr>
	
	<c:forEach var= "student " items = "${studentList}">
	
		<tr>
			<td>${student.id}</td>
			<td>${student.name}</td>
			<td>${student.email}</td>
		</tr>
</c:forEach>
	</table>


</body>
</html>