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
	<input type="button" value="them"
	onclick="window.location.href='showFormForAdd'; return false;" class="add-button">
	<table>
		<tr>
			<th>Ma Lop</th>
			<th>Ten Lop</th>
			<th>Ten nha</th>
			<th>Buoi hoc</th>
			<th>Action</th>
		</tr>
		<c:forEach var="temp" items="${lopHocs }">
			<c:url var="updateLink" value="/showFormForUpdate">
				<c:param name="maLopHoc" value="${temp.maLopHoc }"></c:param>
			</c:url>
			<c:url var="deleteLink" value="/delete">
				<c:param name="maLopHoc" value="${temp.maLopHoc }"></c:param>
			</c:url>
			<tr>
				<td>${temp.maLopHoc}</td>
				<td>${temp.tenLopHoc}</td>
				<td>${temp.tenNha}</td>
				<td>${temp.buoiHoc}</td>
				<td>
					<a href="${updateLink }">Update</a>
					<a href="${deleteLink }">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>