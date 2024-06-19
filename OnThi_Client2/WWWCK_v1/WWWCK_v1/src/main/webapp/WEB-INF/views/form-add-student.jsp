<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Add Student</title>
</head>
<body>
	<h3>Form Add Student</h3>
	<form:form action="/WWWCK_v1/insert" method="Post" modelAttribute="student">
		<table>
			<tr>
				<td>Name</td>
				<td>
					<form:input path="name" />
					<form:errors path="name" />
				</td>
			</tr>
			<tr>
				<td>Address</td>
				<td>
					<form:input path="address" />
					<form:errors path="address" />
				</td>
			</tr>
			<tr>
				<td>Phone</td>
				<td>
					<form:input path="phone" />
					<form:errors path="phone" />
				</td>
			</tr>
			<tr>
				<td><button type="submit">Submit</button></td>
			</tr>
		</table>
	</form:form>
</body>
</html>