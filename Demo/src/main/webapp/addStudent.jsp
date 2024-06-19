<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action = "StudentServlet" method ="get">
<input type="hidden" name ="command" value =""AddStudent>
		<input name="FNAME"  type="text" placeholder="Firstname"/>
		<input name="LNAME" type="text" placeholder="LastName"/>
		<input name="EMAIL" type="email" placeholder="Email"/>
		<input type="submit" value="Save" class="save"/>
	</form>
	
	<p>
			<a href="StudentServlet">Back to list</a>
		</p>

</body>
</html>