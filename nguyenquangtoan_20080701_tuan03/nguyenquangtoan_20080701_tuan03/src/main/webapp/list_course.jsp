<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DANH SÁCH SINH VIÊN THAM GIA KHÓA HỌC</title>
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
		<c:forEach var="ites" items="${LISTSVBYKH}">
			<tr>
				<td>${ites.getFirstName()}</td>
				<td>${ites.getLastName()}</td>
				<td>${ites.getEmail()}</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>