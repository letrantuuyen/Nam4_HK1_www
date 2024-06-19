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
    <script src="<c:url value='/resources/js/jquery-3.5.0.min.js' />" ></script>
    <script src="<c:url value='/resources/js/bootstrap.min.js' />" ></script>
    <script src="<c:url value='/resources/js/Baitaplon.min.js' />" ></script>
    <script src="<c:url value='/resources/js/kiemtraform.min.js' />" ></script>
    
    <link rel="icon" href="${pageContext.request.contextPath}/resources//images/logo/Screenshot 2023-04-24 062812.png" type="image/x-icon">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!-- 
    
    <link rel="stylesheet" href="../css//bootstrap.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="../css/style.css" />
    -->

<style>

.product_image{
    height: 300px;
    width:200px;
    }
    
    </style>

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

        <section style="clear: both;">
            <div class="row">
                <div class="col-12 banner_category">
                    <div class="text-banner">
                        Quần áo dành cho bé gái
                    </div>
                </div>
                <%int n=0; %>
                        <c:forEach var="tempProduct" items="${products}">
                         <%
                        if(n<4) {%>        
                        <c:if test="${tempProduct.category.id=='1'}">
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
                        <%n++; %>
                                </c:if>
                                <% }     
                                else 
                                {break;} %>
                        </c:forEach>
                           
               
        </section>
        <br> <br>

        <section style="clear: both;">
            <div class="row">
                <div class="col-12 banner_category">
                    <div class="text-banner">
                         Quần áo dành cho bé trai
                    </div>

                </div>
                
                        <c:forEach var="tempProduct" items="${products}">
                         <%
                        if(n<8) {%>
                        <c:if test="${tempProduct.category.id=='2'}">
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
                        
                        <%n++; %>
                                </c:if>
                                <% }     
                                else 
                                {break;} %>
                        </c:forEach>
        </section>
        
        <br> <br>

        <section style="clear: both;">
            <div class="row">
                <div class="col-12 banner_category">
                    <div class="text-banner">
                         Quần áo dành trẻ sơ sinh
                    </div>

                </div>
                
                        <c:forEach var="tempProduct" items="${products}">
                         <%
                        if(n<12) {%>
                        <c:if test="${tempProduct.category.id=='3'}">
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
                        
                        <%n++; %>
                                </c:if>
                                <% }     
                                else 
                                {break;} %>
                        </c:forEach>
                        
                        <br> <br> <br> <br>

        <section style="clear: both;">
            <div class="row">
                <div class="col-12 banner_category">
                    <div class="text-banner">
                         Phụ kiện cho bé
                    </div>

                </div>
                
                        <c:forEach var="tempProduct" items="${products}">
                         <%
                        if(n<16) {%>
                        <c:if test="${tempProduct.category.id=='4'}">
                               <c:url var="chitietsanphamLink" value="/chitietsanpham">
                                        <c:param name="productId" value="${tempProduct.id}" />
                                </c:url>
                       <div class="col-lg-3 col-xs-12">
                    <div class="option_Category">
             
                        <img src="${tempProduct.image}" alt="" class="product_image">
                        <div class="option_Category_text">
                            <p><a href="${chitietsanphamLink}">${tempProduct.title}</a></p>
                            
                            <p><strong class="price-product"> <h6>${tempProduct.price} ₫</h6>
                            
                            <i @click="addCart('${tempProduct.id}','${tempProduct.title}','${tempProduct.price}','${tempProduct.image}','${tempProduct.status}')"  class="material-icons cart-product">shopping_cart</i>
                            
                            </strong></p>
               
                        </div>
                    </div>
                </div>
                        
                        <%n++; %>
                                </c:if>
                                <% }     
                                else 
                                {break;} %>
                        </c:forEach>
        </section>
        </section>
    </div>
    <div style="clear: both;"></div>
    <jsp:include page="my_footer.jsp"></jsp:include>
     <jsp:include page="sectionJS.jsp"></jsp:include>
</body>
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/Baitaplon.js"></script>


</html>