<%-- 
    Document   : product_add
    Created on : Feb 13, 2024, 11:36:19 PM
    Author     : mactu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>
<%@include file="slider.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <div class="admin-content-right">
    <div class="admin-content-right-product_add">
        <h1>Thêm sản phẩm</h1>
        <form action="add_product" method="post" >
            <label for="">Nhập tên sản phẩm <span style="color: red;">*</span></label>
            <c:set var="product_name" value="${requestScope.product_name}" />
             <input name="product_name" id="product_name" required type="text" value="${product_name}">
            <!-- Đổ các danh mục từ dbs -->
            <label for="">chọn danh mục <span style="color: red;">*</span></label>
            <select name="cartegory_id" id="cartegory" onchange="clickOnCartegory()" >
             <c:set var="cartegory" value="${requestScope.cartegory}" />
             <option value="${cartegory.cartegory_id}">${cartegory.cartegory_name}</option>
            <c:forEach items="${requestScope.list}" var="s">
                            <option value="${s.cartegory_id}">${s.cartegory_name}</option>  
            </c:forEach> 
            </select>
            <label for="">chọn loại sản phẩm <span style="color: red;">*</span></label>
            <select name="brand_id" id="brand">
            <option value="#">--Loại sản phẩm </option>
            <c:forEach items="${requestScope.list_brand}" var="b">
                            <option value="${b.brand_id}">${b.brand_name}</option>  
            </c:forEach> 
            </select>
            <label for="">Số lượng sản phẩm <span style="color: red;">*</span></label>
            <input name="product_quantity" required type="text">
            <label for="">Giá sản phẩm <span style="color: red;">*</span></label>
            <input name="product_price" required type="text">
            <label for="">Giá khuyến mãi <span style="color: red;">*</span></label>
            <input name="product_price_sale" required type="text">
            <label for="">Mô tả sản phẩm <span style="color: red;">*</span></label><br>
            <textarea require name="product_desc" id="" cols="30" rows="10" placeholder="Nhập mô tả" name=""></textarea>
            <br>
            <label for="">Ảnh sản phẩm <span style="color: red;">*</span></label>
            <input name="product_img" required type="file" >
<!--            <label for="">Ảnh mô tả <span style="color: red;">*</span></label>
            <input name="product_img_desc" required multiple type="file">-->
            <button type="submit">Thêm</button>
        </form>
    </div>
</div>
</section>
    </body>
</html>
<script>
    function clickOnCartegory(){
        var product_name = document.getElementById("product_name").value;
        var cartegory_id = document.getElementById("cartegory").value;
        console.log(product_name);
        console.log(cartegory_id);
        window.location="add_product?cartegory_id="+cartegory_id+"&product_name="+encodeURIComponent(product_name);
    }
</script>
