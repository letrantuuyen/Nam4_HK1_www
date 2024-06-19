<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get List</title>
</head>
<body>
	<h3>Get List - Home Page</h3>
	<table border="1">
		<thead>
			<tr>
				<th>Name</th>
				<th>Address</th>
				<th>Phone</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="s" items="${students}">
				<tr>
					<td>${s.name}</td>
					<td>${s.address}</td>
					<td>${s.phone}</td>
					<td>
						<a href="show-form-update/${s.id}">Update</a>
						<a href="delete/${s.id}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a href="show-form-add">Add Student</a>
</body>
</html>