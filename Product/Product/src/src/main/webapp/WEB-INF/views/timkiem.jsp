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
    <div  class="container container_slider" style="margin-top: 5%;" style="margin-top: 4%;padding-top: 30px;">
        <div><i style="font-weight: bold;">Trang Chủ / Tìm kiếm</i></div>
        <section style="clear: both;">
            <div class="row">
                <div class="col-12 banner_category">
                    <div class="text-banner">
                      Các sản phẩm tìm thấy :
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
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/Baitaplon.js"></script>

</html>