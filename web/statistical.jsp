<%-- 
    Document   : statistical
    Created on : Mar 3, 2024, 6:41:26 AM
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
    <style>
        body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
}

.container {
    width: 1000px;
    height: 800px;
    margin: 20px auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

h2 {
    text-align: center;
}

.section {
    margin-top:20px; 
    margin-bottom: 20px;
}
.product{
    display: flex;
    justify-content: space-around;
}
.customer{
    display: flex;
    justify-content: space-around;
}
h3 {
    margin-bottom: 10px;
}

.data {
    font-weight: bold;
    color: #007bff;
}

ul {
    padding-left: 20px;
}

    </style>
    <body>
      
       <div class="container" >
    <h2>Statistical Report</h2>
  <div class="product">
      <c:set var="best" value="${requestScope.best}" />
      <c:set var="name_best" value="${requestScope.name_best}" />
    <div class="section">
        <h3>Most Sold Product</h3>
        <p>Product ID: <span class="data">${best.product_id}</span></p>
        <p>Product Name: <span class="data">${name_best.product_name}</span></p>
        <p>Total Quantity Sold: <span class="data">${best.total_quantity_sold}</span></p>
    </div>

    <div class="section">
        <h3>Top 3 Selling Products</h3>
        <ul>
            <c:forEach var="top3best" items="${requestScope.top3bestproduct}">
            <li>Product Id: ${top3best.product_id} - Total Quantity Sold: <span class="data">${top3best.total_quantity_sold}</span></li>
            </c:forEach>
        </ul>
    </div>
</div>
    <div class="customer">
        
    <div class="section">
         <c:set var="bestcustomer" value="${requestScope.bestcustomer}" />
        <h3>Top Buyer</h3>
        <p>Username: <span class="data">${bestcustomer.username}</span></p>
        <p>Total Products Bought: <span class="data">${bestcustomer.total_products_bought}</span></p>
    </div>

    <div class="section">
        <h3>Top 3 Buyers</h3>
        <ul>
            <c:forEach var="top3bestcustomer" items="${requestScope.top3bestcustomer}">
            <li>Product Id: ${top3bestcustomer.username} - Total Quantity Sold: <span class="data">${top3bestcustomer.total_products_bought}</span></li>
            </c:forEach>
        </ul>
    </div>
 </div>
   <div class="product">
        <c:set var="leat" value="${requestScope.leat}" />
      <c:set var="name_leat" value="${requestScope.name_leat}" />
    <div class="section">
        <h3>Least Sold Product</h3>
        <p>Product ID: <span class="data">${leat.product_id}</span></p>
        <p>Product Name: <span class="data">${name_leat.product_name}</span></p>
        <p>Total Quantity Sold: <span class="data">${leat.total_quantity_sold}</span></p>
    </div>

    <div class="section">
        <h3>Top 3 Leasting Products</h3>
        <ul>
            <c:forEach var="top3least" items="${requestScope.top3leastproduct}">
            <li>Product Id: ${top3least.product_id} - Total Quantity Sold: <span class="data">${top3least.total_quantity_sold}</span></li>
            </c:forEach>
        </ul>
    </div>
</div>
</div>

</body>
</html>