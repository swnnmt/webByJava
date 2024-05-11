<%-- 
    Document   : cartegory_update
    Created on : Jan 27, 2024, 4:34:18 AM
    Author     : mactu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@include file="slider.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="admin-content-right">
            <div class="admin-content-right-cartegory_add">
                <h1>Sửa danh mục</h1>
                <c:set var="up" value="${requestScope.update}"/> 
                <form action="update" method="post" >
                   ID: <input name="cartegory_id" type="text" value="${up.cartegory_id}" >
                   <br>
                   Name:<input name="cartegory_name" type="text" value="${up.cartegory_name}" >
                    <button type="submit">save</button>
                </form>
            </div>
        </div>
    </section>
</body>
</html> 
