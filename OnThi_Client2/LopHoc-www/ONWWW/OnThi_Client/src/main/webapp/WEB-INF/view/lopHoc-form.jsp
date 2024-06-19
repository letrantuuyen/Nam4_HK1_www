<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<title>Save Customer</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	<div id="container">
		<h3>Edit LopHoc</h3>
		<form:form action="saveLopHoc" modelAttribute="lopHoc"
			method="POST">
			<!-- need to associate this data with customer id -->
			<form:hidden path="maLopHoc"/>
			<table>
				<tbody>
					<tr>
						<td><label>tenLopHoc :</label></td>
						<td><form:input path="tenLopHoc" value="${lopHoc.tenLopHoc}" /></td>
					</tr>
					<tr>
						<td><label>tenNha:</label></td>
						<td><form:select path="tenNha">
								<form:option value="A" label="A"></form:option>
								<form:option value="B" label="B"></form:option>
								<form:option value="C" label="C"></form:option>
								<form:option value="D" label="D"></form:option>
								<form:option value="E" label="E"></form:option>
							</form:select></td>
					</tr>
					<tr>
						<td><label>buoiHoc:</label></td>
						<td><form:select path="buoiHoc">
								<form:option value="sang" label="sang"></form:option>
								<form:option value="chieu" label="chieu"></form:option>
								<form:option value="ban tru" label="ban tru"></form:option>
							</form:select></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		<div></div>
		<p>
			<a href="${pageContext.request.contextPath}/">Back to List</a>
		</p>
	</div>
</body>

</html>
