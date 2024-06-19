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
    <style>
        .banner_category {
            font-size: 25px;
            margin-top: 20px;
            text-transform: none;
        }

        .detail h1 {
            font-size: 23px;
            font-weight: bold;
            line-height: 28px;
            margin-top: 15px;
            margin-bottom: 15px;
            font-family: Arial, Helvetica, sans-serif;
            color: #333;
        }

        .detail p {
            color: #333;
            text-align: justify;
            line-height: 20px;
            margin-top: 20px;
            margin-bottom: 20px;
            font-size: 18px;
        }

        .text-banner:hover {
            color: #333;
        }
        button.btn a{
            color: white;
            list-style: none;
            text-decoration: none;
        }
        .pic{
         height: 400px;
         width: 400px;
          }

.product_image{
    height: 300px;
    width:200px;
    }
    </style>

<body id="app">
    <jsp:include page="my_header.jsp"></jsp:include>
   <form:form action="chitietsanpham" modelAttribute="product" method="GET">
   <form:hidden path="id" />

    
    <div class="container" style="margin-top: 5%;padding-top: 20px;">
        <div><i style="font-weight: bold;">Trang Chủ / ${product.category.title}</i></div>
        <section style="clear: both;">
            <div class="row">
                <div class="col-12 banner_category">
                    <div class="text-banner" >
                        <a>${product.title}</a>                  
                    </div>
                </div>
                <div class="col-lg-7 col-sm-12" style="padding-top: 50px;">
                    <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <div class="row">
                                    <div class="col-sm-12">
                                        <img class="pic"
                                            src="${product.image}" alt="First slide">
                                    </div>
                                </div>
                            </div>
                            
                            
                        </div>
                        
                    </div>
                </div>
                <div class="col-lg-5 col-sm-12">
                    <p style="font-size: 25px;text-align: left;"> <strong
                            style="color: rgb(148, 46, 46);">{{formatNumber(${product.price})}} ₫ </strong></p>
                    <ul class="parameter ">
                        <li class="p226477 g16521_16522"><span class="ctsp"><b>Tên sản phẩm:</b> </span>
                            <div><a>${product.title}</a></div>
                        </li>
                        
                        <li class="p226477 g16531"><span class="ctsp"> <b> Trạng thái:</b></span>
                            <div>${product.status}</div>
                        </li>
                        <!--  
                        <li class="p226477 g16529"><span><b> Kết nối với hệ điều hành:</b></span>
                            <div>Android 5.0 trở lên, iOS 9 trở lên</div>
                        </li>
                        <li class="p226477 g16524"><span><b> Mặt</b>:</span>
                            <div>Kính cường lực Gorrilla Glass Dx+</div>
                        </li>
                        <li class="p226477 g16525"><span><b>Đường kính mặt:</b> </span>
                            <div>41 mm</div>
                        </li>
                        -->
                        <li class="p226477 g16534" style="text-align: justify;"><span class="ctsp"><b>Mô tả sản phẩm:</b></span>
                            <div><a>${product.description}</a>
                            </div>
                        </li>
                    </ul>
                                <c:url var="muangayLink" value="/muahangngay">
                                        <c:param name="productId" value="${product.id}" />
                                </c:url>
                    <button class="btn btn-primary" style="margin-top: 20px;
                        margin-bottom: 20px;
                        margin-left: 30px;
                        background-color: rgb(59, 56, 56);
                        color: white;
                        border: rgb(59, 56, 56);"><a href="${muangayLink}">MUA NGAY</a> 
                    </button>
                        <button @click="addCart('${product.id}','${product.title}','${product.price}','${product.image}','${product.status}')"
                        class="btn btn-primary" type="button" style="margin-left:5px"> 
                          <i   class="material-icons cart">shopping_cart</i></button>
                </div>
            </div>
        </section>
        <section style="clear: both;">
            <div class="row">
                <div class="col-12 banner_category">
                    <div class="text-banner">
                        Sản phẩm liên quan
                    </div>

                </div>
                <%int n=0; %>
                        <c:forEach var="tempProduct" items="${products}">
                         <%
                        if(n<4) {%>        
                        <c:if test="${tempProduct.category.id==product.category.id && tempProduct.id!= product.id}">
                                <c:url var="chitietsanphamLink" value="/chitietsanpham">
                                        <c:param name="productId" value="${tempProduct.id}" />
                                </c:url>
                        <div class="col-lg-3 col-xs-12">
                    <div class="option_Category">
             
                        <img src="${tempProduct.image}" alt="" class="product_image">
                        <div class="option_Category_text">
                            <p><a href="${chitietsanphamLink}">${tempProduct.title}</a></p>
                            
                            <p ><strong class="price-product" >{{formatNumber(${tempProduct.price})}} ₫</strong></p>
                        
                         
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
    </div>

    <div style="clear: both;"></div>
    <jsp:include page="my_footer.jsp"></jsp:include>
    </form:form>
</body>
    <jsp:include page="sectionJS.jsp"></jsp:include>

</html>