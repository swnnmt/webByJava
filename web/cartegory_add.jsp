<%-- 
    Document   : cartegory_add
    Created on : Jan 24, 2024, 6:10:12 AM
    Author     : mactu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@include file="slider.jsp" %>

<div class="admin-content-right">
            <div class="admin-content-right-cartegory_add">
                <h3>${requestScope.error}</h3>
                <h1>Thêm danh mục</h1>
                <form action="add" method="post" >
                    <input name="cartegory_name" type="text" placeholder="Nhập tên danh mục">
                    <button type="submit">Thêm</button>
                </form>
            </div>
        </div>
    </section>
</body>
</html> 
