<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form action="saveCustomer" modelAttribute="customer" method="post">

		<table>
			<tbody>

				<tr>
					<td><label>FirstName</label></td>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td><label>LastName</label></td>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td><label>Email</label></td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Save" class="save"></td>
				</tr>
			</tbody>

		</table>

	</form:form>


</body>
</html>