<%-- 
    Document   : header
    Created on : Feb 5, 2024, 9:25:28 AM
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
</head>
<body>
    
    <header>
        <div class="logo">
           <img src="Front/img/logo.png" alt="">
        </div>
        <div class="menu">
         <c:forEach items="${list}" var="s" >
             <c:set var="account" value="${sessionScope.account_login}" />
             <li><a href="">${s.cartegory_name}</a>
             <ul class="sub-menu"> 
                 <c:forEach items="${list_brand}" var="b" >
                     <c:if test="${s.cartegory_id==b.cartegory_id}">
                     <li><a href="cartegory_front?cartegory_id=${s.cartegory_id}&brand_id=${b.brand_id}&user_name=${account.username}">${b.brand_name}</a></li>
                     </c:if>
                 </c:forEach>
             </ul>
             </li>
         </c:forEach>
        </div>
        <div class="other">
            <c:set var="account" value="${sessionScope.account_login}" />
            <li><input placeholder="Tìm kiếm" type="text"><i class="fas fa-search"></i></li>
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
            
 <section id="slider">
            <div class="aspect-ratio-169">
                <img src="Front/img/c3dd04ac664b34d4e34f51c16573d1f7.jpg" alt="">
                <img src="Front/img/d0f3481e225bb9bd41e79eca88b1cf67.jpg" alt="">
                <img src="Front/img/bb2bdd4a04fb1200d172f4841ba23110.jpg" alt="">
                <img src="Front/img/14278a699545b1d2a97c85c9fbcf4cee.jpg" alt="">
            </div>
            <div class="dot-container">
                <div class="dot active"></div>
                <div class="dot"></div>
                <div class="dot"></div>
                <div class="dot"></div>
            </div>
    </section>
    <!-- sản phẩm liên quan -->
    <section class="product-related">
        <div class="product-related-title row">
            <div class="product-related-title-item woman">
                <p class="click active-related">IVY for Woman</p>
            </div>
            <div class="product-related-title-item men">
                <p class="click">IVY for Men</p>
            </div>
            <div class="product-related-title-item baby">
                <p class="click">IVY for Baby</p>
            </div>
            
        </div>
        <div class="product-woman">
        <div class="product-related-img-woman row">
           
            <c:forEach var="list_product_woman" items="${list_product_woman}">
            <div class="product-related-img-woman-item">
                   <img src="Front/img/${list_product_woman.product_img}" alt="">
                   <h1><a href="product_front?cartegory_id=${list_product_woman.cartegory_id}&brand_id=${list_product_woman.brand_id}&product_id=${list_product_woman.product_id}">${list_product_woman.product_name}</a></h1>
                    <p>${list_product_woman.product_price_sale} <sup>đ</sup> <del>${list_product_woman.product_price}<sup>đ</sup> </del></p>
                   <p>_New_</p>
              </div>  
            
            </c:forEach>
        </div>
        </div>
        <div class="product-men">
            <div class="product-related-img-men row">
                 <c:forEach var="list_product_men" items="${list_product_men}">
            <div class="product-related-img-woman-item">
                   <img src="Front/img/${list_product_men.product_img}" alt="">
                   <h1><a href="product_front?cartegory_id=${list_product_men.cartegory_id}&brand_id=${list_product_men.brand_id}&product_id=${list_product_men.product_id}">${list_product_men.product_name}</a></h1>
                    <p>${list_product_men.product_price_sale} <sup>đ</sup> <del>${list_product_men.product_price}<sup>đ</sup> </del></p>
                   <p>_New_</p>
              </div>  
            
            </c:forEach>

            </div>
        </div>
        <div class="product-baby">
                <div class="product-related-img-baby row">
                         <c:forEach var="list_product_bayby" items="${list_product_bayby}">
            <div class="product-related-img-woman-item">
                   <img src="Front/img/${list_product_bayby.product_img}" alt="">
                   <h1><a href="product_front?cartegory_id=${list_product_bayby.cartegory_id}&brand_id=${list_product_bayby.brand_id}&product_id=${list_product_bayby.product_id}">${list_product_bayby.product_name}</a></h1>
                    <p>${list_product_bayby.product_price_sale} <sup>đ</sup> <del>${list_product_bayby.product_price}<sup>đ</sup> </del></p>
                   <p>_New_</p>
              </div>  
            
            </c:forEach>

                </div>
            </div>
    </section>
<%@include file="footer.jsp" %>
</body>
<script src="Front/JS/handelIndex.js"></script>
<script>
    function check(passwword){
       var confirmPassWord = prompt('xác nhận mật khẩu của bạn');
       if(confirmPassWord==passwword){
           window.location='account_update';
       }
    }
</script>
</html>