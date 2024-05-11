<%-- 
    Document   : cartegory
    Created on : Feb 13, 2024, 9:19:28 PM
    Author     : mactu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/style.css"/>
    <script src="http://kit.fontawesome.com/1147679ae7.js" crossorigin="anonymous"></script>
    <title>Document</title>
    <link href="Front/CSS/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="Front/CSS/cartegory.css">
</head>
<body>
    <header>
        <div class="logo">
           <img src="Front/img/logo.png" alt="">
        </div>
        <div class="menu">
         <c:forEach items="${list}" var="s" >
             <li><a href="">${s.cartegory_name}</a>
             <ul class="sub-menu"> 
                 <c:forEach items="${list_brand}" var="b" >
                     <c:if test="${s.cartegory_id==b.cartegory_id}">
                     <li><a href="cartegory_front?cartegory_id=${s.cartegory_id}&brand_id=${b.brand_id}">${b.brand_name}</a></li>
                     </c:if>
                 </c:forEach>
             </ul>
             </li>
         </c:forEach>
        </div>
        <div class="other">
            <c:set var="account" value="${sessionScope.account_login}" />
            <li> <form>
                    <div style="display: flex;">
                          <input placeholder="Tìm kiếm" type="text" name="findding">
                          <input hidden="" name="user_name" value="${account.username}">
                          <button style="margin-bottom: 12px;">
                        <i class="fas fa-search"></i>
                    </button> 
                    </div>
                  
                </form>
            </li>
             <div class="menu">
            <li> <a class="fa fa-user" ></a>
            <ul class="sub-menu user">
                <li>User name:</li>
                <li>${account.username}</li>
                <li><a href="#" onclick="check('${account.password}')">Chỉnh sửa</a></li>
                <c:if test="${account!=null}">
                <li><a href="logout" ">Đăng Xuất</a></li>
                </c:if>
                <c:if test="${account==null}">
                <li><a href="login" ">Đăng Nhập</a></li>
                </c:if>
                </li>
            </ul>
            </li>
        </div>
            <li> <a class="fa fa-paw" href=""></a></li>
       
            <li> <a class="fa fa-shopping-bag" href="./buyer.html"></a></li>
   
           
        </div>
    </header>
    <section class="cartegory">
        <c:set var="cartegory" value="${requestScope.cartegory}" />
        <c:set var="brand" value="${requestScope.brand}" />
         <c:set var="err" value="${requestScope.err}" />
    <div class="container">
        <div class="cartegory-top row">
            <p><a href="home_front">Trang chủ</a></p>
            <span>&#10230;</span>
            <p><a href="">${cartegory.cartegory_name}</a></p>
            <span>&#10230;</span>
            <p><a href="">${brand.brand_name}</a></p>
        </div>
    </div>
        <h2>${err}</h2>
<div class="container">
  <div class="row">
        <!-- left -->
    <div class="cartegory-left">
        <ul>
          <c:forEach items="${list}" var="s" >
              <li class="cartegory-left-li"><a href="#">${s.cartegory_name}</a>
             <ul> 
                 <c:forEach items="${list_brand}" var="b" >
                     <c:if test="${s.cartegory_id==b.cartegory_id}">
                     <li><a href="cartegory_front?cartegory_id=${s.cartegory_id}&brand_id=${b.brand_id}">${b.brand_name}</a>
                     </c:if>
                 </c:forEach>
             </ul>
             </li>
         </c:forEach>
        </ul>
    </div>
         <!------right------->
    <div class="cartergory-right">
    <!-- right top -->
        <div class="cartergory-right-top row">
            <!-- tiêu đề -->
            <div class="cartergory-right-top-item">
                <h3>${brand.brand_name}</h3>
            </div>
        </div>
        <!-- right content -->
        <div class="cartergory-right-content row">
         <c:forEach items="${product_find}" var="product" >
            <c:if test="${product != null}">
                 
                <div class="cartergory-right-content-item">
                    <img src="Front/img/${product.product_img}" alt="">
                    <h1><a href="product_front?cartegory_id=${product.cartegory_id}&brand_id=${product.brand_id}&product_id=${product.product_id}">${product.product_name}</a></h1>
                    <p>${product.product_price_sale} <sup>đ</sup> <del>${product.product_price}<sup>đ</sup> </del></p>
                     <p>_New_</p>
                </div>
             </c:if>
         </c:forEach>
            
          <c:forEach items="${product}" var="product" >
              <c:if test="${product != null}">
                <div class="cartergory-right-content-item">
                    <img src="Front/img/${product.product_img}" alt="">
                    <h1><a href="product_front?cartegory_id=${product.cartegory_id}&brand_id=${product.brand_id}&product_id=${product.product_id}">${product.product_name}</a></h1>
                    <p>${product.product_price_sale} <sup>đ</sup> <del>${product.product_price}<sup>đ</sup> </del></p>
                     <p>_New_</p>
                </div>
               </c:if>
         </c:forEach>
        </div>
    </div>
  </div>
</div>
</section>
<%@include file="footer.jsp" %>
<script src="Front/JS/handelCartegory.js"></script>