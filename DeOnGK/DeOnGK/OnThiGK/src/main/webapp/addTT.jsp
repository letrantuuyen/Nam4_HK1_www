<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Them tin tuc</title>
</head>
<body>
	<form action="TinTucServlet" method="get">
		<input type="hidden" name="command" value="AddTT">
		<table>
			<tr>
				<td><lable>Ma tin tuc</lable></td>
				<td><input type="text" name="maTin"></td>
			</tr>
			<tr>
				<td><lable>Tieu de</lable></td>
				<td><input type="text" name="tieuDe"></td>
			</tr>
			<tr>
				<td><lable>Noi dung tin tuc</lable></td>
				<td><input type="text" name="noiDungTT"></td>
			</tr>
			<tr>
				<td><lable>Lien ket</lable></td>
				<td><input type="text" name="lienKet"></td>
			</tr>
			<tr>
    <td><label>Ma danh muc</label></td>
    <td>
        <select name="maDM">
            <c:forEach items="${danhMucList}" var="danhMuc">
                <option value="${danhMuc.maDM}">${danhMuc.maDM}</option>
            </c:forEach>
        </select>
    </td>
</tr>
				<td><label></label></td>
				<td><input type="submit" value="Save" class="save"></td>
			</tr>
			</tbody>

		</table>
	</form>
	<div style="clear: both;"></div>
	<p>
		<a href="TinTucServlet">Back to list</a>
	</p>
	</div>

</body>
</html>