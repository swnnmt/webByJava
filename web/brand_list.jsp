<%-- 
    Document   : cartegory_list
    Created on : Jan 24, 2024, 7:46:49 AM
    Author     : mactu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>
<%@include file="slider.jsp" %>
<!DOCTYPE html>

<div class="admin-content-right">
    <div class="admin-content-right-cartegory_list">
        <h1>Danh sách loại sản phẩm</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>ID Danh Mục</th>
                <th>Tên Loại Sản Phẩm</th>
                <th>Chỉnh sửa</th>
            </tr>
            <c:forEach items="${requestScope.list}" var="s" >
                <tr>
                    <td>${s.brand_id}</td>
                    <td>${s.cartegory_id}</td>
                    <td>${s.brand_name}</td>
                    <td><a href="update_brand?brand_id=${s.brand_id}">Sửa</a>|<a href="#" onclick="dodelete('${s.brand_id}','${s.brand_name}')">Xóa</a><!-- </form> --></td>
                </tr>
            </c:forEach>
            
        </table>
    </div>
</div>
</section>
</body>
<script>
    function dodelete(brand_id,brand_name){
        if(confirm("Bạn có chắc chắn muốn xóa danh mục "+brand_name)){
            window.location='delete_brand?brand_id='+brand_id;
        }
    }
</script>
</html>