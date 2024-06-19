<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LISTSTUDENT</title>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>
	<table>
		<tr>
			<th>HỌ</th>
			<th>TÊN</th>
			<th>EMAIL</th>
		</tr>
		<c:forEach var="ites" items="${LIST_STUDENT}">
			<tr>
				<td>${ites.getFirstName()}</td>
				<td>${ites.getLastName()}</td>
				<td>${ites.getEmail()}</td>
				<td><a href="?method=ADDSTUDENTCORSE&id=${ites.getId()}">Thêm Khóa Học</a></td>
				<td><a href="?method=GETCOURSE&id=${ites.getId()}">Xem Danh Sách Khóa Học</a></td>
			</tr>
		</c:forEach>

	</table>
	<form action="StudentCourseController" id="form-1">
		<input name="method" value="ADDSTUDENT" type="hidden" /> 
		<input name="FNAME"  type="text" placeholder="Firstname"/>
		<input name="LNAME" type="text" placeholder="LastName"/>
		<input name="EMAIL" type="email" placeholder="Email"/>
		<input type="submit" value="Thêm Sinh Viên" id="button-1" />
	</form>
	<table>
		<tr>
			<th>KHOA HOC</th>
			<th>TRANG THAI</th>

		</tr>
		<c:forEach var="ites" items="${LIST_COURSER}">
			<tr>
				<td>${ites.getCourseName()}</td>
				<td>${ites.getStatusCourse()}</td>
				<td><a href="?method=GOUPDATE&id=${ites.getId()}">Thao tác</a></td>
				<td><a href="?method=VIEWCOURSE&id=${ites.getId()}">Xem
						Danh Sách Sinh Viên Tham gia Khóa Học</a></td>
			</tr>
		</c:forEach>
	</table>

	<form action="StudentCourseController" id="form-1" method="POST">
		<input name="method" value="ADDCOURSE" type="hidden" />
		<input name="NAME"  type="text" placeholder="Khoa Hoc"/>
		<input name="STATUS" type="text" placeholder="Trang Thai"/>
		 <input
			type="submit" value="Thêm Khóa Học " id="butto" />
	</form>
	
	
	<form action="StudentCourseController">
	<input type="hidden" name="method" value="VIEWCOURE">
		<button>Go to list Course</button>
	</form>
</body>
</html>