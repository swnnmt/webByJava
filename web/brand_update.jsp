<%-- 
    Document   : brand_update
    Created on : Jan 30, 2024, 3:30:48 AM
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
                <h1>Sửa loại sản phẩm</h1>
                <br>
                <c:set var="up" value="${requestScope.update}"/>
                <c:set var="a" value="${requestScope.a}"/>
                <form action="update_brand" method="post">
                    <select name="cartegory_id" id="">
                        <option value="${a.cartegory_id}">${a.cartegory_name}</option>
                        <c:forEach items="${requestScope.list}" var="s">
                            <option value="${s.cartegory_id}">${s.cartegory_name}</option>  
                        </c:forEach>
                    </select>
                <br>
                <br>
                <input name="brand_id" type="hidden" value="${up.brand_id}">
                <br>
                <input required name="brand_name" type="text" value="${up.brand_name}">
                    <button type="submit">Save</button>
                </form>
            </div>
        </div>
    </section>
</body>
</html> 
</html>
