<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tin Tức</title>
</head>
<body>
	<h1>Danh sách Tin Tức</h1>
	<table border="1">
		<tr>
			<th>Ma TT</th>
			<th>Tieu de</th>
			<th>Noi dung</th>
			<th>Lien ket</th>
			<th>Ma DM</th>
		</tr>
		<c:forEach var="tt" items="${ttList }">
			<tr>
				<td>${tt.maTT}</td>
				<td>${tt.tieuDe}</td>
				<td>${tt.noiDungTT}</td>
				<td>${tt.lienKet}</td>
				<td>${tt.maDM}</td>
			</tr>
		</c:forEach>
	</table>
	
	 <c:choose>
    <c:when test="${not empty ttList}">
        <c:forEach var="tt" items="${ttList}">
            <c:url var="deleteLink" value="TinTucServlet">
                <c:param name="command" value="DeleteTT"></c:param>
                <c:param name="maTT" value="${tt.maTT}"></c:param>
            </c:url>
            <tr>
                <td>${tt.maTT}</td>
                <td>${tt.tieuDe}</td>
                <td>${tt.noiDungTT}</td>
                <td>${tt.lienKet}</td>
                <td>${tt.maDM}</td>
                <td> 
                    <a href="${deleteLink}"
                       onclick="if(!(confirm('Are you sure you want to delete this student?'))) return false">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <tr>
            <td colspan="6">No data available</td>
        </tr>
    </c:otherwise>
</c:choose>
	

	<p>
		<a href="TinTucServlet">Back to list</a>
	</p>
</body>
</html>
