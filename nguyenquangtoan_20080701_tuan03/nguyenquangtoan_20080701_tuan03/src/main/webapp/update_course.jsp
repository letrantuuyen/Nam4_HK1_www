<%@page import="entity.Course"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="StudentCourseController" method="get">

		<label> <%
 Course c = (Course) request.getAttribute("course");
 String status = c.getStatusCourse();
 
 boolean check = false;
 if (c.getStatusCourse().equals("ON")) {
 	check = true;
 }
 
 if(check){
	 out.print(" <input name='id' value='"+c.getId()+"' type='hidden'><input name='method' value='UPDATE' type='hidden'><input type='radio' name='STATUS' value='ON' checked> ON </label> <label> <input type='radio' name='STATUS' value='OFF'>OFF</label> <button type='submit'>Cập Nhập</button>");
 }
 else{
	 out.print(" <input name='id' value='"+c.getId()+"' type='hidden'><input name='method' value='UPDATE' type='hidden'><input type='radio' name='STATUS' value='ON' > ON </label> <label> <input type='radio' name='STATUS' value='OFF' checked>OFF</label> <button type='submit'>Cập Nhập</button>");
 }
 %> 


</body>
</html>