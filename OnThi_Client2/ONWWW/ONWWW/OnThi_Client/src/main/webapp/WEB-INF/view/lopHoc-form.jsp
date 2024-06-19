<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>	
	<form:form action="saveLopHoc" modelAttribute="lopHoc" method="POST">
		<form:hidden path="maLopHoc"/>
		<tr>
			<td><label>Ten Lop Hoc</label> </td>
			<td>
				<form:input path="tenLopHoc"/>
				<form:errors path="tenLopHoc" cssClass="error"></form:errors>
			</td>
		</tr>
		<tr>
			<td><label>Ten nha</label> </td>
			<td>
				<form:select path="tenNha">
					<form:option value="A" label="A"></form:option>
					<form:option value="B" label="B"></form:option>
					<form:option value="C" label="C"></form:option>
					<form:option value="D" label="D"></form:option>
					<form:option value="E" label="E"></form:option>
				</form:select>
			</td>
		</tr>
		<tr>
			<td><label>Buoi hoc</label> </td>
			<td>
				<form:select path="buoiHoc">
					<form:option value="sang" label="sang"></form:option>
					<form:option value="chieu" label="chieu"></form:option>
					<form:option value="ban tru" label="ban tru"></form:option>
				</form:select>
			</td>
		</tr>
		<tr>
			<td><label></label> </td>
			<td>
				<input type="submit" value="Save">
			</td>
		</tr>
	</form:form>
	
</body>
</html>