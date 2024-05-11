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
                <th>Ảnh 1</th>
                <th>Ảnh 2</th>
                <th>Ảnh 3</th>
                <th>Ảnh 4</th>
                <th>Màu sắc</th>
                <th>chi tiết</th>
                <th>Bảo quản</th>
                <th>Edit </th>
            </tr>
            <c:forEach items="${requestScope.list}" var="s" >
                <tr>
                    <td>${s.product_id}</td>
                    <td>${s.product_img_desc_1}</td>
                    <td>${s.product_img_desc_2}</td>
                    <td>${s.product_img_desc_3}</td>
                    <td>${s.product_img_desc_4}</td>
                    <td>${s.product_color}</td>
                    <td>${s.product_intro}</td>
                    <td>${s.product_prever}</td>
                    <td><a href="update_product_detail?product_id=${s.product_id}">*Sửa</a> <br><a href="#" onclick="dodeleteProduct_detail('${s.product_id}')">*Xóa</a></td>
                </tr>
            </c:forEach>
            
        </table>
    </div>
</div>
</section>
</body>
<script>
    function dodeleteProduct_detail(product_id, product_name){
        if(confirm("Bạn có chắc chắn muốn xóa chi tiết ")){
            window.location='delete_product_detail?product_id='+product_id;
        }
    }
</script>
</html>