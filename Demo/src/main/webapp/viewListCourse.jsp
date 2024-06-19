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

<h1>Danh sach khoa hoc ne</h1>
<table border =" 1">
	<tr>
		<th>ID</th>
		<th>CourseName</th>
		<th>StatusCourse</th>
	</tr>
	<tbody>
	<c:forEach var ="i" items = "${CourseList}">
	<tr>
		<td>${i.id}</td>
		<td>${i.courseName}</td>
		<td>${i.statusCourse}</td>
	</tr>
	</c:forEach>
	
	</tbody>r
</table>

</body>
</html>