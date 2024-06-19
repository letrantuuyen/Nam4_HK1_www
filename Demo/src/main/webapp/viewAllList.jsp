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

<h1>Danh sách sinh viên nè</h1>
<table border =" 1">
<tr>
	
	<th>FirstName</th>
	<th>LastName</th>
	<th>Email</th>
</tr>
<c:forEach var ="i" items ="${StudentList}">
<tr>
		<th>${ i.firstName}</th>
		<th>${ i.lastName}</th>
		<th>${ i.email}</th>
</tr>

</c:forEach>

</table>
<form action="StudentServlet" id ="form-1">
	<input name ="method" value ="AddStudent" type ="hidden"/>
	<input name ="FName" value ="FirstName" />
	<input name ="LName" value ="LastName"/>
	<input name ="Email" value ="Email" />
	<input type="submit" value="Thêm Sinh Viên" id="button-1" />
</form>

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
	
	</tbody>
</table>
<form action="StudentServlet" id ="form-1">
	<input name ="method" value ="AddCourse" type ="hidden"/>
	<input name ="CourseN" value ="CourseName"/>
	<input name ="StatusC" value ="StatusCourse" />
	<input type="submit" value="Thêm Khoa hoc" id="button-1" />
</form>
</body>
</html>