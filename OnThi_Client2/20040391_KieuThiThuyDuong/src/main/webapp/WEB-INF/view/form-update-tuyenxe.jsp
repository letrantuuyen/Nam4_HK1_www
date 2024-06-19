<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Update Tuyen Xe</title>
</head>
<body>
	<h3>Form Update Tuyen Xe</h3>

	<form:form action="/20040391_KieuThiThuyDuong/update" method="Post" modelAttribute="tuyenXe">
		<table>
			<form:hidden path="id"/>
			<tr>
				<td>Ten Tuyen Xe</td>
				<td><form:input path="tenTuyenXe" /> <form:errors
						path="tenTuyenXe" /></td>
			</tr>
			<tr>
				<td>Khoang Cach</td>
				<td><form:input path="khoangCach" /> <form:errors
						path="khoangCach" /></td>
			</tr>
			<tr>
				<td>Diem Khoi Hanh</td>
				<td><form:input path="diemKhoiHanh" /> <form:errors
						path="diemKhoiHanh" /></td>
			</tr>
			<tr>
				<td>Diem Den</td>
				<td><form:input path="diemDen" /> <form:errors path="diemDen" />
				</td>
			</tr>
			<tr>
				<td><button type="submit">Submit</button></td>
			</tr>
		</table>
	</form:form>

</body>
</html>