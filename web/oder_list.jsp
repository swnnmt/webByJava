<%-- 
    Document   : oder_list
    Created on : Apr 23, 2024, 2:35:34 PM
    Author     : mactu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>
<%@include file="slider.jsp" %>
<!DOCTYPE html>

<div class="admin-content-right">
    <div class="admin-content-right-cartegory_list">
        <h1>Danh sách Oder</h1>
        <table>
            <tr>
                <th>Mã Đơn</th>
                <th>Tên khách hàng </th>
                <th>Mã hàng</th>
                <th>Số lượng</th>
                <th>Số điện thoại</th>
                <th>Địa chỉ</th>
                <th>Giá</th> 
            </tr>
            <c:forEach items="${requestScope.list}" var="s" >
                <tr>
                    <td>${s.id_done}</td>
                    <td>${s.name_custom}</td>
                    <td>${s.product_id}</td>
                    <td>${s.product_quantity}</td>
                    <td>${s.phone_number}</td>
                    <td>${s.address} ${s.districts} ${s.province}</td>
                    <td>${s.product_done_price}</td>
                </tr>
            </c:forEach>
            
        </table>
    </div>
</div>
</section>
</body>
</html>