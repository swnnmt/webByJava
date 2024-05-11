<%-- 
    Document   : product
    Created on : Feb 17, 2024, 12:10:40 PM
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
    <link href="Front/CSS/product.css" rel="stylesheet" type="text/css"/>
    
   
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
              
            <li><input placeholder="Tìm kiếm" type="text"><i class="fas fa-search"></i></li>
            <c:set var="account" value="${sessionScope.account_login}" />
             <div class="menu">
            <li> <a class="fa fa-user" ></a>
            <ul class="sub-menu user">
                <li>User name:</li>
                <li>${account.username}</li>
                <li><a href="#" onclick="check('${account.password}')">Chỉnh sửa</a></li>
                  
                </li>
            </ul>
            </li>
        </div>
            <li> <a class="fa fa-paw" href=""></a></li>
            <li> <a class="fa fa-shopping-bag" href="./buyer.html"></a></li>
        </div>
    </header>
        <section class="product">
         <div class="container">
                   <c:set var="cartegory" value="${requestScope.cartegory}" />
        <c:set var="brand" value="${requestScope.brand}" />
         <c:set var="err" value="${requestScope.err}" />
         <c:set var="product" value="${requestScope.product}" />
         <c:set var="product_detail" value="${requestScope.product_detail}" />
         
    <div class="container">
        <div class="product-top row">
            <p><a href="home_front">Trang chủ</a></p>
            <span>&#10230;</span>
            <p><a href="">${cartegory.cartegory_name}</a></p>
            <span>&#10230;</span>
            <p><a href="">${product.product_name}</a></p>
        </div>
    </div>
        <h2>${err}</h2>             
            <div class="product-content row">
                <div class="product-content-left row">
                    
                    <div class="product-content-left-big-img">
                        <img src="Front/img/${product.product_img}" alt="">
                    </div>
                     
                    <div class="product-content-left-small-img">
                        <img src="Front/img/${product_detail.product_img_desc_1}" alt="">
                        <img src="Front/img/${product_detail.product_img_desc_2}" alt="">
                        <img src="Front/img/${product_detail.product_img_desc_3}" alt="">
                        <img src="Front/img/${product_detail.product_img_desc_4}" alt="">
                    </div>
                </div>
                <div class="product-content-right">
                    <div class="product-content-right-product-name">
                        <h1>${product.product_name}</h1>
                        <p style="font-size: 15px">MSP: ${product.product_id}</p>
                    </div>
                    <div class="product-content-right-product-price">
                        <p>${product.product_price_sale} <sup>đ</sup></p>
                    </div>
                    <div class="product-content-right-product-color">
                        <p style="font-size: 20px;"><span style="font-weight: bold; font-size: 20px;">Màu Sắc</span>: ${product_detail.product_color}<span style="color: red;">*</span></p>
                        <div class="product-content-right-product-color-img">
<!--                            <img src="" alt="">-->
                        </div>
                    </div>
            <form action="buy_product" method="post">
           <c:set var="account" value="${sessionScope.account_login}" />
           <input type="text" hidden="" name="user_name" value="${account.username}">
                        <br>
                        <input type="text" hidden="" name="product_id" value="${product.product_id}">
                        <div class="product-content-right-product-size" style="display: flex;">
                        <p style="font-weight: bold;">Size:</p>
                        <select style=" height: 30px; width: 55px" name="product_size">
                            <option value="S">S</option>
                            <option value="M">M</option>
                            <option value="L">L</option>
                            <option value="XL">XL</option>
                            <option value="XXL">XXL</option>
                        </select>
                    </div>
                        <br>
                    <p style="color:#f31313;">Kiểm tra size bạn đã chọn</p>
                     <div class="product-content-right-product-name">
                         <br><!-- comment -->
                        <p style="font-size: 15px">Trong kho: ${product.product_quantity}</p>
                    </div>
                    <br>
                    <div class="quantity">
                        <p style="font-weight: bold;">Số lượng:</p>
                        <input type="number"min="0" max = "${product.product_quantity}"value="1" name="product_quantity">
                    </div>
                    
                    <div class="product-content-right-product-button row">
                        <button type="submit"><i class="fas fa-shopping-cart"></i><p>MUA HÀNG</p></button>
                        <button type="submit"><p>THÊM VÀO GIỎ</p></button>
                    </div>
            </form>
                    <div class="product-content-right-product-icon row">
                        <div class="product-content-right-product-icon-item row">
                            <i class="fas fa-phone-alt"></i>
                            <p>Hotline</p>
                        </div>
                        <div class="product-content-right-product-icon-item row">
                            <i class="fas fa-comments"></i>
                            <p>Chat</p>
                        </div>
                        <div class="product-content-right-product-icon-item row">
                            <i class="fas fa-envelope"></i>
                            <p>Mail</p>
                        </div>
                    </div>
                    <div class="product-content-right-product-qr">
                        <img src="" alt="">
                    </div>
                    <div class="product-content-right-bottom">
                        <div class="product-content-right-bottom-top">
                            &#8744;
                        </div>
                        <div class="product-content-right-bottom-content-big">
                            <div class="product-content-right-bottom-content-title">
                                <div class="product-content-right-bottom-content-title-item gioithieu">
                                     <p class="click active">Giới Thiệu</p>
                                </div>
                                <div class="product-content-right-bottom-content-title-item chitiet">
                                    <p class="click" >Chi Tiết</p>
                                </div>
                                <div class="product-content-right-bottom-content-title-item baoquan">
                                    <p class="click">Bảo Quản</p>
                                </div>   
                            </div>
                            <div class="product-content-right-bottom-content">
                                <div class="product-content-right-bottom-content-gioithieu">
                                    <p class="maincontent-bottom">${product.product_desc}</p>
                                </div>
                                <div class="product-content-right-bottom-content-chitiet">
                                    <p class="maincontent-bottom">${product_detail.product_intro}</p>
                                </div>
                                <div class="product-content-right-bottom-content-baoquan">
                                    <p class="maincontent-bottom">${product_detail.product_prever}</p>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
         </div>
    </section>
                                        <!----------Product related ---------------->
    <section class="product-related">
        <div class="product-related-title">
            <p>Sản phẩm liên quan</p>
        </div>
    <div class="product-related-content row">
            <c:forEach var="list_product_relate" items="${list_product_relate}">
            <div class="product-related-content-item">
                   <img src="Front/img/${list_product_relate.product_img}" alt="">
                   <h1><a href="product_front?cartegory_id=${list_product_relate.cartegory_id}&brand_id=${list_product_relate.brand_id}&product_id=${list_product_relate.product_id}">${list_product_relate.product_name}</a></h1>
                    <p>${list_product_relate.product_price_sale} <sup>đ</sup> <del>${list_product_relate.product_price}<sup>đ</sup> </del></p>
                   <p>_New_</p>
              </div>  
            
            </c:forEach>
    </div>
        
    </section>
  <%@include file="footer.jsp" %>
     <script src="Front/JS/handelProdct.js"></script>