<%-- 
    Document   : login
    Created on : Feb 22, 2024, 12:09:42 AM
    Author     : mactu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="login/logIn.css">
    <script src="https://kit.fontawesome.com/c9f5871d83.js" crossorigin="anonymous"></script>
    <title>WEV_LOGIN</title>
</head>
<body>
   
        <header class="header">
            <nav class="nav">
                <a href="#" target="_blank"> Trang chủ </a>
                <a href="#"> Giới Thiệu </a>
                <a href="#"> Trình Trạng Chung </a>
                <a href="#"> Liên Hệ Tư Vấn </a>
            </nav>
            <div class="search">
                <i class="fa-solid fa-magnifying-glass"></i>
                <i class="fa-solid fa-user"></i>  
            </div>
        </header>
        <div class="background"></div>
        <section class="home">
            <div class="content">
                <a href="#" class="logo"> <i class="fa-solid fa-paper-plane"></i> SMT</a>
                <h2> Welcome!</h2>
                <h3> IVY moda </h3>
               <pre> Thank you for coming to us! </pre>
               <div class="icon">
                <i class="fa-brands fa-instagram"></i>
                <i class="fa-brands fa-facebook"></i>
                <i class="fa-brands fa-twitter"></i>
                <i class="fa-brands fa-github"></i>
               </div>    
            </div>
            <div class="login">
                <h2> Login </h2>
                <form action="login" method="post">
                <div class="input">
                    <input type="text" class="input1" id="username" name="username" placeholder="User name" required  >
                   <i class="fa-solid fa-envelope"></i>
                </div>
                <div class="input">
                    <input type="password" class="input1" id="password" name="password" placeholder="Password" required>
                    <i class="fa-solid fa-lock"></i> 
                </div>
                <div class="button">
                    <button class="btn" type="submit"> Login </button>
                </div>
            </form>
                <div class="sign-up">
                    <p> Don't have an account? </p>
                    <a href="signup"> Sign up</a>
                </div>
            </div>
            <c:set var="not_found" value="${requestScope.not_found1}" />
           
        </section>
        <!-- <script src="./signup_login.js"></script> -->
        <div></div>
        <script>
//         var a="${not_found}";
//         if(confirm(a+" Bạn có cần tạo tài khoản ?")){
//             window.location='signup';
//         }
//         
        </script>
</body>
</html>
