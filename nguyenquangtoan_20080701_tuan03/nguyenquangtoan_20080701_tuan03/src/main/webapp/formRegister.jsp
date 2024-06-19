<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
	<div>
		<h3>Học Sinh: ${student.getLastName()}</h3>
	</div>
	
	<form action="StudentCourseController">
			<div>
				<input type="hidden" value="${student.getId()}" name="ID" />
			</div>
			<div>
				<input type="hidden" value="REGISTER" name="method" />
			</div>
		<c:forEach var="corse" items="${LIST_COURSER_ON}">
			

			<input type="radio" name="CORSENAME" value="${corse.getId()}">${corse.getCourseName()}
	</c:forEach>
	<input type="submit" value="Dang Ky" >
	</form>
</body>
</html>