<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>KIDS FASION</title>
    
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"  rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/resources/css/style.css"  rel="stylesheet" type="text/css">

    
    <link rel="icon" href="${pageContext.request.contextPath}/resources//images/logo/Screenshot 2023-04-24 062812.png" type="image/x-icon">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<body id="app">
    <jsp:include page="my_header.jsp"></jsp:include>
    <div class="container container_slider" style="margin-top: 5%;">
        <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <div class="row">
                        <div class="col-12">
                            <a href="../html/chitietdongho.html"><img class="d-block w-100 h-20 slider_image"
                                    src="resources/images/logo/Screenshot 2023-04-24 060704.png" alt="First slide"></a>
                        </div>

                    </div>
                </div>
                <div class="carousel-item ">
                    <div class="row">
                        <div class="col-12">
                            <a href="../html/chitietdongho.html"><img class="d-block w-100 h-20 slider_image"
                                    src="resources/images/logo/Screenshot 2023-04-24 071434.png" alt="First slide"></a>

                        </div>
                        <div class="col-4 bg_text_content">

                        </div>
                    </div>
                </div>
                <div class="carousel-item ">
                    <div class="row">
                        <div class="col-12">
                            <a href="../html/chitietdongho.html"><img class="d-block w-100 h-20 slider_image"
                                src="resources/images/logo/Screenshot 2023-04-24 080856.png" alt="First slide"></a>
                        </div>
                        <div class="col-4 bg_text_content">
                        </div>
                    </div>
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>

        <div class="container-fluid" style="margin-top: 4%;padding-top: 10px;">
            <div><i style="font-weight: bold;">Trang Chủ / Sản phẩm</i></div>
            <section style="clear: both;">
                <div class="row">
                    <div class="col-12 banner_category">
                        <div class="text-banner">
                            Sản phẩm
                        </div>

                    </div>
                    
                        <c:forEach var="tempProduct" items="${products}">
                           
                        
                                <c:url var="chitietsanphamLink" value="/chitietsanpham">
                                        <c:param name="productId" value="${tempProduct.id}" />
                                </c:url>
                        <div class="col-lg-3 col-xs-12">
                    <div class="option_Category">
             
                        <img src="${tempProduct.image}" alt="" class="product_image">
                        <div class="option_Category_text">
                            <p><a href="${chitietsanphamLink}">${tempProduct.title}</a></p>
                            
                            <p><strong class="price-product"> <h6>{{formatNumber(${tempProduct.price})}} ₫</h6>
                            
                            <i @click="addCart('${tempProduct.id}','${tempProduct.title}','${tempProduct.price}','${tempProduct.image}','${tempProduct.status}')"  class="material-icons cart-product">shopping_cart</i>
                            
                            </strong></p>
               
                        </div>
                    </div>
                </div>
                        
                        
                                
                                
                        </c:forEach>
            </section>

        </div>
        <div style="clear: both;"></div>
        <jsp:include page="my_footer.jsp"></jsp:include>
</body>
    <jsp:include page="sectionJS.jsp"></jsp:include>


</html>