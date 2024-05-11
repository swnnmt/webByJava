<%-- 
    Document   : account_user
    Created on : Feb 29, 2024, 12:10:51 AM
    Author     : mactu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="login/signup.css" rel="stylesheet" type="text/css"/>
<link href="login/logIn.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://kit.fontawesome.com/1147679ae7.js" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/c9f5871d83.js" crossorigin="anonymous"></script>
        <title>JSP Page</title>
    </head>
    <body>
        
        <c:set var="account" value="${sessionScope.account_login}" />
        <H1 style="text-align: center; color: chocolate">HELLO ${account.username} <i class="fas fa-grin-hearts"></i></i> </H1>
        
        <div class="background"></div>
            <section class="home">
    <div class="SignUp">
        <h2> SIGN UP </h2>
        <form action="account_update" method="post">
            <input type="text" hidden="" name="id_account" value="${account.id_account}" required>
        <div class="input">
            <input type="text" class="input1"  name="username" value="${account.username}" required>
           <i class="fa-solid fa-envelope"></i>
        </div>
        <div class="input">
            <input type="text" class="input1"  name="email" value="${account.email}" required>
           <i class="fa-solid fa-envelope"></i>
        </div>
        <div class="input">
            <input type="password" class="input1" id="passwordField"  name="password" value="${account.password}" required>
            <i onclick="togglePassword()" class="far fa-eye"></i>
        </div>
        <div class="button">
            <button class="btn" type="submit" > SAVE </button>
        </div>
       </form>
    </div>
    </div>
</section>
    </body>
<script > 
    function togglePassword() {
    var passwordField = document.getElementById("passwordField");
    if (passwordField.type === "password") {
        passwordField.type = "text";
    } else {
        passwordField.type = "password";
    }
}
</script>
</html>
