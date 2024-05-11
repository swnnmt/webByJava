<%-- 
    Document   : product_detail_add
    Created on : Feb 18, 2024, 7:28:13 PM
    Author     : mactu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>
<%@include file="slider.jsp" %>
<html>
    <body>
     <div class="admin-content-right">
     <div class="admin-content-right-product_add">
     <h1>Thêm chi tiết sản phẩm</h1>
     <form action="add_product_detail" method="post">
     <c:set var="product" value="${requestScope.product}" />
    <label for="">Mã sản phẩm <span style="color: red;">*</span></label>
    <input name="product_id" required type="text" value="${product.product_id}">
    <label for="">Tên sản phẩm <span style="color: red;">*</span></label>
    <input name="product_name" required type="text" value="${product.product_name}">
    <label for="">Ảnh chi tiết 1 <span style="color: red;">*</span></label>
    <input name="product_img_desc_1" required type="file" >
    <label for="">Ảnh chi tiết 2 <span style="color: red;">*</span></label>
    <input name="product_img_desc_2" required type="file" >
    <label for="">Ảnh chi tiết 3 <span style="color: red;">*</span></label>
    <input name="product_img_desc_3" required type="file" >
    <label for="">Ảnh chi tiết 4 <span style="color: red;">*</span></label>
    <input name="product_img_desc_4" required type="file" >
    <label for="">Màu sản phẩm <span style="color: red;">*</span></label>
    <input name="product_color" required type="text">
    <label for="">Giới thiệu sản phẩm <span style="color: red;">*</span></label><br>
    <textarea require name="product_intro" id="" cols="20" rows="10" placeholder="Giới thiệu" name=""></textarea><br>
    <label for="">Cách bảo quản sản phẩm <span style="color: red;">*</span></label><br>
    <textarea require name="product_prever" id="" cols="20" rows="10" placeholder="Bảo quản" name=""></textarea>
    <br>
    <button type="submit">Thêm</button>
    </form>
    </div>
</div>
    </body>
    
</html>
