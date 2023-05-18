<%-- 
    Document   : register
    Created on : 12 May 2023, 2:45:15 pm
    Author     : jaehyeokseong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
        <link rel="stylesheet" type="text/css" href="register.css">
    </head>
    <body onload="startTime()">
        <%
            String existErr = (String)session.getAttribute("existErr");
            String emailErr = (String)session.getAttribute("emailErr");
            String passErr = (String)session.getAttribute("passErr");
            String nameErr = (String)session.getAttribute("nameErr");
        %>
          <div class="container">
        <h1>User Registration</h1>
        <form method="post" action="RegisterServlet">
          <div class="form-group">
            <input type="text" name="name" placeholder="name" required>
          </div>
          <div class="form-group">
            <input type="email" name="email" placeholder="email" required>
          </div>
          <div class="form-group">
            <input type="password" name="password" placeholder="password" required>
          </div>
          <div class="form-group">
            <input type="text" name="phoneNumber" placeholder="phone number" required>
          </div>
            <br>
            <br>
          <button type="submit" name="">Sign Up</button>
          
          <br>
          <br>
          <a href="CancelRegisterServlet" class="button"> Cancel </a>
   </form>
        </form>
    </div>
    </body>
</html>
