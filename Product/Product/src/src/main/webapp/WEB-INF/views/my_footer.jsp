<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<footer>
            <div class="row">
                <div class="col-lg-4 col-sm-12 footer_element">
                    <h5 style="margin-left: 40px;">
                        THÔNG TIN LIÊN HỆ
                    </h5>
                    <p>Số 12 Nguyễn Văn Bảo, Phường 4, Quận Gò Vấp, Tp.HCM
                        <br><br> 037381470
                        <br><br> KidFasion@gmail.com
                        <br><br> KF@T&amp;L.menia
                    </p>
                </div>
                
                <div class="col-lg-4 col-sm-12 footer_element">
                               <c:url var="phukienLink" value="danhsachsanphamtheoloai">
                                        <c:param name="theId" value="4" />
                                </c:url>
                    <h5 style="    margin-left: 110px;">
                        LIÊN KẾT
                    </h5>
                    <ul style="margin-left: 80px;">
                        <br>
                        <li><a href="#">Giới thiệu</a></li>
                        <br>
                        <li><a href="danhsachsanpham">Sản phẩm</a></li>
                        <br>
                        <li><a href="${phukienLink}">Phụ kiện</a></li>
                    </ul>
                </div>
                <div class="col-lg-4 col-sm-12 footer_element">
                    <h5 style="    margin-left: 130px;">
                        LIÊN KẾT HỖ TRỢ
                    </h5>
                    <ul style="margin-left: 100px;">
                        <br>
                        <li><a href="#">Chính sách bảo hành</a></li>
                        <br>
                        <li><a href="#">Chính sách đổi trả</a></li>
                        <br>
                        <li><a href="#">Tư vấn khách hàng</a></li>
                    </ul>
                </div>
                <div class="col-lg-12 col-xs-12">
                    <p style="text-align: center;color: back;">&copy;2023. Công ty KidFasion</p>
                </div>
            </div>

        </footer>
</body>
</html>