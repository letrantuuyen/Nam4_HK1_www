<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
								<h4 class="page-title">Thông tin đơn hàng</h4>
								<ol class="breadcrumb p-0 m-0">
									<li><a href="#">KIDShop</a></li>
									<li><a href="#">Quản lý</a></li>
									<li class="active">Thông tin đơn hàng</li>
								</ol>
								<div class="clearfix"></div>
							</div>
						</div>
					</div>
					<!-- end row -->

					<div class="row">
						<div class="col-lg-12">
							<form action="acceptOrDetail" method="post"
								enctype="multipart/form-data">
								<div class="row">
									<div class="col-sm-5">
										<div style="width: 30%">
											<div class="image_display">

												<img alt="sanpham" src="../${orderDetail.product.image}" style="width: 300px">
											</div>
										</div>
									</div>
									<div class="col-sm-7">
										<div class="row">
											<div style="border-bottom: 1px solid black; "><label>Thông tin sản phẩm</label> </div>
											
											<input type="hidden" name="id" value="${orderDetail.id}">
											<div class="form-group">
												<label>Tên sản phẩm</label> <input type="text"
													class="form-control" name="title" value="${orderDetail.product.title}"
													placeholder="Tên sản phẩm" readonly="readonly">
											</div>
											
											<div class="form-group">
												<label>Mô tả</label>
												<textarea class="form-control" name="description"
													placeholder="Mô tả" readonly="readonly" >${orderDetail.product.description}</textarea>
											</div>

											<div class="form-group">
												<label>Loại</label> <input type="text"
													class="form-control" name="type" value="${orderDetail.product.category.title}"
													placeholder="Tên sản phẩm" readonly="readonly" >
											</div>
											<div class="form-group">
												<div class="row">
													<div class="col-sm-4">
														<label>Giá:</label> <input type="number"
															class="form-control" name="price" value="${orderDetail.product.price}"
															placeholder="Giá"  readonly="readonly">

													</div>
													<div class="col-sm-4">
														<label>Số lượng:</label> <input type="number"
															class="form-control" name="quantity" value="${orderDetail.quantity}"
															placeholder="Số lượng" readonly="readonly">

													</div>
													<div class="col-sm-4">
														<label>Tổng tiền:</label> <input type="number"
															class="form-control" name="total" value="${orderDetail.order.total}"
															placeholder="Tổng tiền" readonly="readonly">

													</div>
													
												</div>
											</div>
											
										</div>
										<!-- Thông tin khách hàng -->
										<div class="row">
											<div style="border-bottom: 1px solid black; "><label>Thông tin khách hàng</label> </div>
											<div class="form-group">
												<label>Ngày đặt</label> <input type="date"
													class="form-control" name="date" value="${orderDetail.order.createdAt }"
													placeholder="Ngày đặt" readonly="readonly" >
											</div>
											<div class="form-group">
												<label>Số điện thoại:</label> <input type="number"
													class="form-control" name="phone" value="${orderDetail.order.phone}"
													placeholder="Số điện thoại" readonly="readonly">
											</div>
											<div class="form-group">
												<label>Địa chỉ:</label> <input type="text"
													class="form-control" name="address" value="${orderDetail.order.address }"
													placeholder="Địa chỉ" readonly="readonly">
											</div>
										</div>
										<div style="float: right;">
											<button type="submit" class="btn btn-primary">Chấp nhận</button>
											<button type="reset" class="btn btn-primary">
												<a href="/admin/listProduct" style="color: white;">Hủy</a>
											</button>
										</div>
									</div>
								</div>


							</form>

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