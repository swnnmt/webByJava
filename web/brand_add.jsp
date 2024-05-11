<%-- 
    Document   : brand_add
    Created on : Jan 29, 2024, 7:37:57 AM
    Author     : mactu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@include file="slider.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <div class="admin-content-right">
            <div class="admin-content-right-cartegory_add">
                <h1>Thêm loại sản phẩm (test)</h1>
                <br>
                <form action="add_brand" method="post">
                    <select name="cartegory_id" id="">
                        <option value="#">-Chọn danh mục</option>
                        <c:forEach items="${requestScope.list}" var="s">
                            <option value="${s.cartegory_id}">${s.cartegory_name}</option>  
                        </c:forEach>
                    </select>
                <br>
                <br>
                    <input required name="brand_name" type="text" placeholder="Nhập tên loại sản phẩm">
                    <button type="submit">Thêm</button>
                </form>
            </div>
        </div>
    </section>
</body>
</html> 
</html>
