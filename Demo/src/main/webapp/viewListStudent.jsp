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

<h1>Danh sach sinh vien ne</h1>
	<table border =" 1", width ="100%">
		<tr>
			<th>ID</th>
			<th>First Name </th>
			<th>Last Name </th>
			<th>Email </th>
		</tr>
		<tbody>
		<c:forEach var ="i" items = "${StudentList}">
			<tr>
				<td>${i.id}</td>
				<td>${i.firstName}</td>
				<td>${i.lastName}</td>
				<td>${i.email}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<input type ="button" value = "Add student" onclick = "window.location.href='addStudent.jsp'; return false;" class="add-student-button" />

</body>
</html>