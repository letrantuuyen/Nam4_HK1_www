<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
</style>
</head>

<header>
	<!-- <div> -->
	<!-- <img alt="" src="D:\OneDrive - Industrial University of HoChiMinh City\Nam 4 HK1\WWW\DeOnGK\DeOnGK\OnThiGK\img\IMG_1019.JPG" style="width: 100%"> -->
	<!-- </div> -->

</header>
<body border: 1px solid black>
	
		<a href='<c:url value="/TinTucServlet?command=GetTTByDM"/>'>Danh sach tin tuc</a> | <a
			href='<c:url value="/TinTucServlet?command=AddTT"/>'>Them tin tuc
			moi</a>
</body>

</html>