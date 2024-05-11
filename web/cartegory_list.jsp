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
        <h1>Danh sách danh mục</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>Tên danh mục</th>
                <th>Chỉnh sửa</th>
            </tr>
            <c:forEach items="${requestScope.list}" var="s" >
                <tr>
                    <td>${s.cartegory_id}</td>
                    <td>${s.cartegory_name}</td><td><a href="update?cartegory_id=${s.cartegory_id}">Sửa</a>|<a href="#" onclick="dodelete('${s.cartegory_id}','${s.cartegory_name}')">Xóa</a><!-- </form> --></td>
                </tr>
            </c:forEach>
            
        </table>
    </div>
</div>
</section>
</body>
<script>
    function dodelete(cartegory_id,cartegory_name){
        if(confirm("Bạn có chắc chắn muốn xóa danh mục "+cartegory_name)){
            window.location='delete?cartegory_id='+cartegory_id;
        }
    }
</script>
</html>