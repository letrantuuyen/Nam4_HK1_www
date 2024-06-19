<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="c"%>>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	 <c:form action="updateStudent" modelAttribute="student" method="post">
        <table>
                <tr>
					<td>Name</td>
					<td>
						<c:input path="name" />
						<c:errors path="name" />
					</td>
				</tr>
				<tr>
					<td>Age</td>
					<td>
						<c:input path="age" />
						<c:errors path="age" />
					</td>
				</tr>
				
                <tr>
                    <td><input type="submit" value="Save" class="save"></td>
                </tr>
        </table>
    </c:form>

</body>
</html>