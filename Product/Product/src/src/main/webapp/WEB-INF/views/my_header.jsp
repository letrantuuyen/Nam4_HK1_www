<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    



	<header>

        <nav class="navbar fixed-top navbar-expand-lg navbar-light bg-menu">
            <div class="container-fluid">
                <div class="row nav_container">
                    <div class=" col-sm-2 d-block d-sm-none">
                        <button class="navbar-toggler " type="button" data-toggle="collapse"
                            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <a href="#">
                 
                             <img class="logo  " style="width: 65%;margin-left: 20px;" src="resources/images/logo/Screenshot 2023-04-24 063023.png"/>
                        </a>
                    </div>
                                <c:url var="begaiLink" value="danhsachsanphamtheoloai">
                                        <c:param name="theId" value="1" />
                                </c:url>
                                 <c:url var="betraiLink" value="danhsachsanphamtheoloai">
                                        <c:param name="theId" value="2" />
                                </c:url>
                                 
                                 <c:url var="tresosinhLink" value="danhsachsanphamtheoloai">
                                        <c:param name="theId" value="3" />
                                </c:url>
                                 <c:url var="phukienLink" value="danhsachsanphamtheoloai">
                                        <c:param name="theId" value="4" />
                                </c:url>
                    <div class="col-lg-5 col-sm-12 col-xs-12">
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav">
                                <li class="nav-item dropdown">
                                    <a class="nav-link menu-item " href="danhsachsanpham" data-bs-toggle="dropdown">Sản phẩm</a>
                                    <ul class="dropdown-menu sub-menu">
                                        <li><a class="dropdown-item" href="${begaiLink}" >Bé gái</a></li>
                                        <li><a class="dropdown-item" href="${betraiLink}">Bé trai</a></li>
                                        <li><a class="dropdown-item" href="${tresosinhLink}">Trẻ sơ sinh</a></li>
                                    </ul>
                                </li>
                                <li class="nav-item dropdown">
                                    <a class="nav-link menu-item " href="${phukienLink}" data-bs-toggle="dropdown"> Phụ Kiện </a>
                                    
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-2 col-sm-10 col-xs-8 d-none d-sm-block">
                        <a href="${pageContext.request.contextPath}/">
                            <img class="logo  " style="width: 65%;margin-left: 20px;" src="resources/images/logo/Screenshot 2023-04-24 063023.png" />
                        </a>
                    </div>
                    <div class="col-lg-5 col-sm-12 menu_right">
                        <ul class="navbar-nav" style="float: right;">
                            <li class="nav-item dropdown item_menu_right">
                                <a class="nav-link menu-item " href="#" data-bs-toggle="dropdown">Giới thiệu</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link menu-item " href="#" data-bs-toggle="dropdown"> Tài khoản </a>
                                <ul class="dropdown-menu sub-menu">
                                    <li><a class="dropdown-item" href="#">Đăng Ký</a></li>
                                    <li><a class="dropdown-item" href="#">Đăng Nhập </a></li>
                                </ul>
                            </li>
                            
                          <li class="nav-item dropdown item_menu_right">
                                <form action="/timkiem" id="Search" >
                                    <input type="search" placeholder="Search" name="search" style="background: #ededed url(resources/images/logo/search-icon.png) no-repeat 9px center;">
                                </form>
                            </li>
                            <li class="nav-item dropdown item_menu_right">
                                <a class="nav-link menu-item " href="/muahang" data-bs-toggle="dropdown"><i
                                        class="material-icons cart">shopping_cart</i>
                                        <span class="cart-number" v-if="carts.length>0">{{quantity}}</span>
                                          <div class="cart-price" v-if="total != 0">{{formatNumber(total)}}</span>
                                        </a>
                                         
                                    
                                        
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
    </header>
