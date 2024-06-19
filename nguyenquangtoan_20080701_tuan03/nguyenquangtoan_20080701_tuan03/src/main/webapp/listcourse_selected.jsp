<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course</title>
</head>
<body>
<h1>DS COURSE</h1>
	<form action="StudentCourseController" method="get"">
		<select name="id">
			<c:forEach var="items" items="${LIST_COURSE}">
			<option onclick="window.open('http://localhost:8080/nguyenquangtoan_20080701_tuan03/StudentCourseController?method=VIEWCOUREWITHID&id=${items.getId()}')">${items.getCourseName()}</option>
			</c:forEach>
		</select>
	</form>
	
	<c:forEach var="ites" items="${LISTSVBYKH}">
			<tr>
				<td>${ites.getFirstName()}</td>
				<td>${ites.getLastName()}</td>
				<td>${ites.getEmail()}</td>
			</tr>
		</c:forEach>
</body>

</html>