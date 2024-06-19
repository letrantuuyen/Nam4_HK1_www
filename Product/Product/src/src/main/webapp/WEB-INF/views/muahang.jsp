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
    .inputId{
    background-color:white;
    border-color:white;
    border-style: solid;
    width: 40px;
    }
    </style>
<body id="app">


  
     <jsp:include page="my_header.jsp"></jsp:include>
     
    <div class="container " style="margin-top: 4%;padding-top: 30px;">
   
        <div><i style="font-weight: bold;">Trang Chủ / Mua hàng</i></div>
        <section style="clear: both;">
            <div class="row">
                <div class="col-12 banner_category">
                    <div class="text-banner">
                        Danh sách giỏ hàng
                    </div>

                </div>
                <div class="col-12">
                    <table class="table table-light">
                        <thead class="thead-light">
                            <tr>
                                <th>#</th>
                                <th>Tên sản phẩm</th>
                                <th>Hình ảnh</th>
                                <th>Số lượng</th>
                                <th>Giá</th>
                       
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="item in carts">
                                <td>{{item.id}} </td>
                                <td>{{item.title}}</td>
                                <td><img style="width: 100px;height: 100px;"
                                        :src="'/'+item.image" />
                                </td>
                                
                                <td>
                                            <div >
                                                <input v-model="item.quantity" @change="changeCartQuantity(item.quantity,item.id)"  type="number" class="form-control" 
                                                :value="item.quantity"
                                                    aria-describedby="emailHelp" placeholder="0" name="quantity">     
                                                    <span class="text-danger" id="error_phone"></span>                                              
                                            </div>
                                </td>   
                                
                                <td>{{formatNumber(item.quantity*item.price)}} </td>
                
                            </tr>
                            
                        </tbody>
                    </table>
                    <c:if test='${success.equalsIgnoreCase("true")}'>
                    <div class="alert alert-success">Bạn đã đặt hàng thành công</div>
                    </c:if>
                
                  
                              <c:if test='${success.equalsIgnoreCase("false")}'>
                    <div class="alert alert-danger">Có lỗi xảy ra</div>
                    </c:if>
                
                    <div class="row">
                        <div class="col-7">
                             <div style="width: 100%;">
                                <div class="row">
                                    <div class="col-12">
            
                                        <br>
                                      <form:form method="POST"
							action="/dathang"
							modelAttribute="category">
                                             <input  id="txt_phone" type="hidden" class="form-control" 
                                      value="true"
                                                   name="success"> 
                                      <input  id="txt_phone" type="hidden" class="form-control" 
                                      :value="JSON.stringify(carts)"
                                                   name="products">
                                                    <input  id="txt_phone" type="hidden" class="form-control" 
                                      :value="total"
                                                   name="total">
                                            <br>
                                            <div class="form-group col-12" >
                                                <input v-model="phone" id="txt_phone" type="text" class="form-control" 
                                                    aria-describedby="emailHelp" placeholder="Số điện thoại" name="phone">
                                                    <p class="text-danger text-left" v-if="phoneRequired" id="error_phone">Bạn chưa nhập số điện thoại</p>
                                                    
                                                        <p class="text-danger text-left" v-if="phoneValid" id="error_phone">Số điện thoại không hợp lệ</p>
                                            </div>
                                            <br>
                                            <div class="form-group col-12" >
                                                <input  v-model="address" id="txt_address" type="text" class="form-control" 
                                                    aria-describedby="emailHelp" placeholder="Địa chỉ" name="address">
                                            <span class="text-danger" v-if="addressRequired" id="error_phone">Bạn chưa nhập địa chỉ</span>
                                            </div>
                                            <br>
                                            <div class="form-group col-12" >
                                                <input id="txt_note" type="text" name="message" class="form-control" 
                                                    aria-describedby="emailHelp" placeholder="Ghi chú">
                                                    <span class="text-danger" id="error_address"></span>
                                            </div>
                                            
                                            
                                            <br>
                                            <div class="form-check">
                                            </div>
                                            
                                            <button @click="submit($event)" style="margin-left: 18px;" type="submit"   class="btn btn-primary" onclick="" >Đặt hàng</button>
                                 </form:form>
            
                                          <br>
                                        <div id="thongbao_loi" style="display: none;"  class="alert alert-danger">
                                                Vui lòng kiểm tra lại
                                        </div>
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                         <div class="col-5">
                         	<div class="row">
                         		 <div class="col-6">
                         		 Tổng tiền:
                         		 </div>
                         		  <div class="col-6">
                         		{{formatNumber(total)}}
                         		 </div>
                         	</div>
                         </div>
                    </div>
                   
                </div>
            </div>


        </section>

    </div>
    <div style="clear: both;"></div>

    <jsp:include page="my_footer.jsp"></jsp:include>

</body>
    <jsp:include page="sectionJS.jsp"></jsp:include>
</html>