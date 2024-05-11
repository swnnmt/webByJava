<%-- 
    Document   : delivery
    Created on : Feb 29, 2024, 7:43:46 AM
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
    <link rel="stylesheet" href="Front/CSS/delivery.css">
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
            <li><input placeholder="Tìm kiếm" type="text"><i class="fas fa-search"onclick=""></i></li>
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
                <setion class="delivery">
        <div class="container">
            <div class="delivery-top-wrap">
                <div class="delivery-top">
                    <div class="delivery-top-delivery delivery-top-item">
                      <i class="fas fa-shopping-cart"></i>
                    </div>
                    <div class="delivery-top-adress delivery-top-item">
                      <i class="fas fa-map-marker-alt"></i>
                    </div>
                    <div class="delivery-top-payment delivery-top-item">
                      <i class="fas fa-money-check-alt"></i>
                    </div>
                  </div>
            </div>
        </div>
        <c:set var="account" value="${sessionScope.account_login}" />
        <c:set var="buy_product" value="${requestScope.buy_product}" />
         <c:set var="product" value="${requestScope.product}" />
        <div class="container">
            <div class="delivery-content row">
                <div class="delivery-content-left">
                     <p>Vui lòng chọn địa chỉ giao hàng</p>
                     <div class="delivery-content-left-dangnhap row">
                        <i class="fas fa-sign-in-alt"></i>
                        <p>Đăng nhập nếu bạn đã có tài khoản của IVY</p>
                     </div>
                    <div class="delivery-content-left-khachle row">
                        <input checked name="loaikhach"type="radio">
                        <p><b>Khách lẻ</b> (nếu bạn không muốn lưu lại thông  tin)</p>
                    </div>
                    <div class="delivery-content-left-dangky row">
                        <input  name="loaikhach"type="radio">
                        <p> Đăng ký tạo tài khoản mới <a href="signup" style="font-weight: bold">tại đây</a> </p>
                    </div>
          
         <form action="product_done" method="post">
                <div class="delivery-content-left-input-top row">
                        <div class="delivery-content-left-input-top-item">
                            <label for="">Họ tên <span style="color: aqua;">*</span></label>
                            <input name="name_custom"type="text" style="height: 30px;"required>
                        </div>
                        <div class="delivery-content-left-input-top-item">
                            <label for="">Số điện thoại<span style="color: aqua;">*</span></label>
                            <input name="phone_number"type="text" style="height: 30px;"required>
                        </div>
                        <div class="delivery-content-left-input-top-item">
                            <label for="">Tỉnh/TP<span style="color: aqua;">*</span></label>
                            <input name="province"type="text" style="height: 30px;"required>
                        </div>
                        <div class="delivery-content-left-input-top-item">
                            <label for="">Quận/Huyện<span style="color: aqua;">*</span></label>
                            <input name="districts"type="text" style="height: 30px;" required>
                        </div>
                </div>
                    <div class="delivery-content-left-input-bottom">
                        <div class="delivery-content-left-input-bottom-item">
                            <label for="">Địa chỉ<span style="color: aqua;">*</span></label>
                            <input name="address" type="text" style="height: 30px;"required>
                        </div>
                    </div>
            <div>
                <input name="username" hidden="" type="text" value="${buy_product.username}">
                <input name="product_id" hidden=""  type="text" value="${buy_product.product_id}">
                <input name="product_size" hidden="" type="text" value="${buy_product.product_size}">
                <input name="product_quantity" hidden=""  type="text" value="${buy_product.product_quantity}">
                <input name="product_done_price"  hidden="" type="text" value="${buy_product.product_quantity*product.product_price_sale+(buy_product.product_quantity*product.product_price_sale*10/100)}">
            </div>
                <div class="delivery-content-left-button row">
                     <a href="home_front"><span>&#171;</span><p>Tiếp tục mua sắm</p></a>
                     
                     
                     <button type="submit" ><p style="font-weight: bold;">THANH TOÁN VÀ GIAO HÀNG</p></button>
                    </div>
               </div>
       </form>
                <div class="delivery-content-right">
                    
                        <table>
                            <tr>
                                <th>Tên Sản Phẩm</th>
                                <th>Giá gốc</th>
                                <th>Giá Giảm</th>
                                <th>Số Lượng</th>
                                <th>Thành Tiền</th>
                            </tr>
                            <tr>
                                <td>${product.product_name}</td>
                                <td>${product.product_price}</td>
                                <td>${product.product_price_sale}</td>
                                <td>${buy_product.product_quantity}</td>
                                <td><p>${buy_product.product_quantity*product.product_price_sale} <sup>đ</sup></p></td>
                            </tr>
                            <tr>
                                <td style="font-weight: bold;" colspan="3">Tổng</td>
                                <td style="font-weight: bold;" ><p>${buy_product.product_quantity*product.product_price_sale}<sup>đ</sup></p</td>
                            </tr>
                            <tr>
                                <td style="font-weight: bold;" colspan="3">Thuế VAT</td>
                                <td style="font-weight: bold;" ><p>${buy_product.product_quantity*product.product_price_sale*10/100} <sup>đ</sup></p</td>
                            </tr>
                            <tr>
                                <td style="font-weight: bold;" colspan="3">Tổng Tiền Hàng</td>
                                <td style="font-weight: bold;" ><p>${buy_product.product_quantity*product.product_price_sale+(buy_product.product_quantity*product.product_price_sale*10/100)} <sup>đ</sup></p</td>
                            </tr>
                        </table>
                </div>
            </div>
        </div>
    </setion>
<%@include file="footer.jsp" %>
<c:set var="submited" value="${requestScope.submited}" />
 
<c:if test="${submited!= null}">
        <script>
            if(confirm("Bạn đã thanh toán thành công bạn muốn tiếp tục mua hàng chứ ?")){
                window.location='cartegory_front?cartegory_id=${submited.cartegory_id}&brand_id=${submited.brand_id}&user_name=${account.username}';
            }
            else{
                window.location='home_front';
            }
        </script>
</c:if>
<c:set var="err" value="${requestScope.err}" />
<c:if test="${err==0}">
    <script>
        alert("Thanh toán thất bại vui lòng thử lại");
         window.location='product_front?cartegory_id=${submited.cartegory_id}&brand_id=${submited.brand_id}&product_id=${submited.product_id}';
    </script>
</c:if>