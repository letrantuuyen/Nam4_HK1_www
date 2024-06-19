<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Product Tracker App</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>FooBar University</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Student -->
			
			<input type="button" value="Add Product" 
				   onclick="window.location.href='add-product-form.jsp'; return false;"
				   class="add-student-button"
			/>
			
			<table>
			
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Price</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempProduct" items="${PRODUCT_LIST}">
					
					<!-- set up a link for each student -->
					<c:url var="tempLink" value="ProductControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="productId" value="${tempProduct.id}" />
					</c:url>

					<!--  set up a link to delete a student -->
					<c:url var="deleteLink" value="ProductControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="productId" value="${tempProduct.id}" />
					</c:url>																		
					<tr>
						<td> ${tempProduct.name} </td>
						<td> ${tempProduct.description} </td>
						<td> ${tempProduct.email} </td>
						<td> 
							<a href="${tempLink}">Update</a> 							 | 
							<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this Product?'))) return false">
							Delete</a>	
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
</body>
</html>








