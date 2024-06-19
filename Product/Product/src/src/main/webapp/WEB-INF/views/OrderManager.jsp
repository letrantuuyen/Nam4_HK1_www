<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<%-- <jsp:include page="layouts/left_sidebar.jsp"/>
		<jsp:include page="layouts/topbar.jsp.jsp"/> --%>
		 <div class="content-page">
            <!-- Start content -->
            <div class="content">
                <div class="container">

                    <div class="row">
                        <div class="col-xs-12">
                            <div class="page-title-box">
                                <h4 class="page-title">Sweet Alert</h4>
                                <ol class="breadcrumb p-0 m-0">
                                    <li>
                                        <a href="#">Adminox</a>
                                    </li>
                                    <li>
                                        <a href="#">Admin UI</a>
                                    </li>
                                    <li class="active">
                                        Sweet Alert
                                    </li>
                                </ol>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </div>
                    <!-- end row -->

                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card-box">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th style="min-width:20%;">Tên sản phẩm</th>
                                            <th>Số lượng</th>
                                            <th>Giá</th>
                                            <td>SDT</td>
                                            <td>Ngày mua</td>
                                            <td>Trạng thái</td>
                                        </tr>
                                    </thead>
                                    <tbody>

                                        <tr>
                                            <td class="middle-align"></td>
                                            <td>
                                                <button type="button" class="btn btn-default waves-effect waves-light btn-sm" id="sa-title">Click me</button>
                                            </td>
                                        </tr>

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

            <footer class="footer text-right">
                2023 © TL Shop.
            </footer>

        </div>


      


    </div>
 


    <!-- jQuery  -->
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/metisMenu.min.js"></script>
    <script src="assets/js/waves.js"></script>
    <script src="assets/js/jquery.slimscroll.js"></script>

    <!-- Sweet-Alert  -->
    <script src="../plugins/sweet-alert2/sweetalert2.min.js"></script>
    <script src="assets/pages/jquery.sweet-alert.init.js"></script>

    <!-- App js -->
    <script src="assets/js/jquery.core.js"></script>
    <script src="assets/js/jquery.app.js"></script>
	</div>
</body>
</html>