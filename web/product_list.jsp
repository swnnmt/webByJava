<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>
<%@include file="slider.jsp" %>
<!DOCTYPE html>

<div class="admin-content-right">
    <div class="admin-content-right-cartegory_list">
        <c:set var="e" value="${requestScope.err}" />
        <h1>${e}</h1>
        <h1>Danh sách loại sản phẩm</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>Tên sản phẩm</th>
                <th>ID danh mục</th>
                <th>ID loại sản phẩm</th>
                <th>Số lượng</th>
                <th>Giá sản phẩm</th>
                <th>Giá khuyến mãi</th>
                <th>Ảnh sản phẩm</th>
                <th>Mô tả sản phẩm</th>
                <th>Edit</th>
            </tr>
            <c:forEach items="${requestScope.list}" var="s" >
                <tr>
                    <td>${s.product_id}</td>
                    <td>${s.product_name}</td>
                    <td>${s.cartegory_id}</td>
                    <td>${s.brand_id}</td>
                    <td>${s.product_quantity}</td>
                    <td>${s.product_price}</td>
                    <td>${s.product_price_sale}</td>
                    <td>${s.product_img}</td>
                    <td>${s.product_desc}</td>
                    <td><a href="update_product?product_id=${s.product_id}">*Sửa</a> <br><a href="#" onclick="dodeleteProduct('${s.product_id}','${s.product_name}')">*Xóa</a><br><a href="add_product_detail?product_id=${s.product_id}">*Chi tiết</a><!-- </form> --></td>
                </tr>
            </c:forEach>
            
        </table>
    </div>
</div>
</section>
</body>
<script>
    function dodeleteProduct(product_id, product_name){
        if(confirm("Bạn có chắc chắn muốn xóa danh mục "+product_name)){
            window.location='delete_product?product_id='+product_id;
        }
    }
</script>
</html>