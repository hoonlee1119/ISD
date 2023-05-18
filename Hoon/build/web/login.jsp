<%-- 
    Document   : login
    Created on : 12 May 2023, 2:45:23 pm
    Author     : jaehyeokseong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" type="text/css" href="login.css">
    </head>
    <body onload="startTime()">
        <%
            String existErr = (String)session.getAttribute("existErr");
            String emailErr = (String)session.getAttribute("emailErr");
            String passErr = (String)session.getAttribute("passErr");
        %>
        
        <h1>Login Page</h1>
        
        <form action="LoginServlet" method="post">
             <div class="container">
         <div class="text-center">
           <label for="username">Email:</label>
            <input type="text" placeholder="<%=(emailErr != null ? emailErr : "Enter email")%>", name="email" required>
            <label for="password">Password:</label>
            <input type="password" placeholder="<%=(passErr != null ? passErr : "Enter password")%>" name="password" required>
          
            <input type="submit" value="Sign In">
            <br>
            <br>
                <a href="CancelRegisterServlet">Cancel</a>
            </div>
             </div>
        </form>
        
    </body>
</html>
