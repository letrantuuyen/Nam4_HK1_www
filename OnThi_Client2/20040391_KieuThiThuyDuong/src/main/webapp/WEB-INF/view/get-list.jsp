<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Get List - Home Page</h3>
	<table border="1">
		<thead>
			<tr>
				<th>Ten Tuyen Xe</th>
				<th>Khoang Cach</th>
				<th>Diem Khoi Hanh</th>
				<th>Diem Den</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tx" items="${tuyenXes}">
				<tr>
					<td>${tx.tenTuyenXe}</td>
					<td>${tx.khoangCach}</td>
					<td>${tx.diemKhoiHanh}</td>
					<td>${tx.diemDen}</td>
					<td><a href="show-form-update/${tx.id}">Update</a> <a
						href="delete/${tx.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="show-form-add">Add Student</a>

</body>
</html>