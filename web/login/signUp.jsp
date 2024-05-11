<%-- 
    Document   : signUp
    Created on : Feb 20, 2024, 11:52:05 AM
    Author     : mactu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="login/logIn.css">
    <script src="https://kit.fontawesome.com/c9f5871d83.js" crossorigin="anonymous"></script>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>WEV_SIGNUP</title>
    <link rel="stylesheet" href="login/signup.css">
</head>
<body>
    <div class="background"></div>
    <section class="home">
    <div class="SignUp">
        <h2> SIGN UP </h2>
        <form action="signup" method="post">
        <div class="input">
            <input type="text" class="input1" id="username" placeholder="User name" name="username" required>
           <i class="fa-solid fa-envelope"></i>
        </div>
        <div class="input">
            <input type="text" class="input1" id="email" name="email" placeholder="Email" required>
           <i class="fa-solid fa-envelope"></i>
        </div>
        <div class="input">
            <input type="password" class="input1" id="password" name="password" placeholder="Password" required>
            <i class="fa-solid fa-lock"></i> 
        </div>
        <div class="input">
            <c:set var="err" value="${requestScope.err}" />
            <input type="password" class="input1" id="confirmPassword" placeholder="Confirm paswword" name="password_confirm" required>
            <p style="color:red ">${err}</p>
            <i class="fa-solid fa-lock"></i> 
        </div>
        <div class="button">
            <button class="btn" type="submit" > SignUp </button>
        </div>
       </form>
       <div class="button" style="margin-top: 10px;">
        <a href="./logIn.html"><button class="btn"> Login </button></a>
    </div>
    </div>
    </div>
</section>
</body>
