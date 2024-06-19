<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<input type="button" value="Add Student"
		onclick="window.location.href = 'formAdd' ; return false;" />
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Age</th>
		</tr>
		<tbody>
		<c:forEach var = "x" items= "${students}">
			<tr>
				<td>${x.id}</td>
				<td>${x.name}</td>
				<td>${x.age}</td>
				<td><a href="delete/${x.id}">Delete</a></td>
				<td><a href="showFormForUpdate/${x.id}">Update</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>


</body>
</html>