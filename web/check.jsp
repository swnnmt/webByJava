<%-- 
    Document   : check
    Created on : Feb 17, 2024, 2:08:32 AM
    Author     : mactu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        check
          <c:set var="c" value="${requestScope.err}" />
        <h1>${c}</h1>
        
    </body>
</html>
