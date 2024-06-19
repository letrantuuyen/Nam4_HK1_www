<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Admin</title>
<link
	href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/assets/css/core.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/assets/css/components.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/assets/css/icons.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/assets/css/pages.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/assets/css/menu.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/assets/css/responsive.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="wrapper">
		<jsp:include page="layout/left_sidebar.jsp" />
		<jsp:include page="layout/topbar.jsp" />
		<div class="content-page">
			<!-- Start content -->
			<div class="content">
				<div class="container">

					<div class="row">
						<div class="col-xs-12">
							<div class="page-title-box">
								<h4 class="page-title">Sweet Alert</h4>
								<ol class="breadcrumb p-0 m-0">
									<li><a href="#">KIDShop</a></li>
									<li><a href="#">Admin manager</a></li>
									<li class="active">Sản phẩm</li>
								</ol>
								<div class="clearfix"></div>
							</div>
						</div>
					</div>
					<!-- end row -->

					<div class="row">
						<div class="col-lg-12">
							<div class="card-box">
								<button type="button"
									class="btn btn-sm btn-primary btn-rounded w-md waves-effect waves-light pull-right">
									<a href="/admin/addProduct">Thêm sản phẩm</a>
								</button>
								<h4 class="header-title m-b-30">My Files</h4>



							</div>
							<table class="table">


								<thead>
									<tr>
										<th style="min-width: 10%;">Tên sản phẩm</th>
										<th>Loại</th>
										<th>Giá</th>
										<td>Trạng thái</td>
									</tr>
									<c:forEach var="tempProduct" items="${products}">
										<c:url var="updateLink" value="/admin/loadInfor">
											<c:param name="productId" value="${tempProduct.id}" />
										</c:url>
										<!-- construct an "delete" link with customer id -->
										<c:url var="deleteLink" value="/admin/deleteProduct">
											<c:param name="productId" value="${tempProduct.id}" />
										</c:url>
										<tr>
											<td>${tempProduct.title}</td>
											<td>${tempProduct.category.title}</td>
											<td>${tempProduct.price}</td>
											<td>${tempProduct.status}</td>

											<td>
												<button type="button"
													class="btn btn-default waves-effect waves-light btn-sm "
													id="info_button">
													<a href="${updateLink }">Thông tin</a>
												</button>
											</td>
											<td>
												<button type="button"
													class="btn btn-default waves-effect waves-light btn-sm"
													id="Delete_button">
													<a href="${deleteLink}"
														onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
												</button>
											</td>
										</tr>
									</c:forEach>
								</thead>
								<tbody>



								</tbody>
							</table>

						</div>
						<!-- end card-box -->
					</div>
					<!-- end col -->

				</div>
				<!-- end row -->

			</div>


		</div>
		<!-- content -->

		<footer class="footer text-right"> 2023 © Kidshop </footer>

	</div>





	</div>

 <script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/metisMenu.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/waves.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/jquery.slimscroll.js"></script>

    <!-- Sweet-Alert  -->
    <script src="${pageContext.request.contextPath}../plugins/sweet-alert2/sweetalert2.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/pages/jquery.sweet-alert.init.js"></script>

    <!-- App js -->
    <script src="${pageContext.request.contextPath}/assets/js/jquery.core.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/jquery.app.js"></script>

</body>
</html>