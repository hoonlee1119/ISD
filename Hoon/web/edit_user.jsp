<%-- 
    Document   : edit
    Created on : 17 May 2023, 3:04:13 pm
    Author     : jaehyeokseong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.User"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Page</title>
            <link rel="stylesheet" type="text/css" href="main.css">
            <link rel="stylesheet" type="text/css" href="register.css">
    </head>
    <header>
         <h1>User Account Profile</h1>
      <nav>
        <ul>
       
                 <li> <a href="view_user.jsp"> View Profile </a></li>
           <li> <a href="edit_user.jsp"> Edit Profile </a></li>
            <li> <a href="delete_user.jsp"> Delete Profile </a></li>
            <li>   <a href="LogoutServlet">Logout</a><li>
       
     
        </ul>
      </nav>
    </header>
    <body onload="startTime()">
        <%
            User user = (User)session.getAttribute("user");
            String updated = (String)session.getAttribute("updated");
        %>
        <h1>Edit User Information: <%=updated != null ? updated : ""%></h1>
        <form action="UpdateServlet" method="post">
          <div class="container">
               <div class="form-group">
            <input type="text" name="name" value="${user.name}">
          </div>
          <div class="form-group">
            <input type="email" name="email" value="${user.email}">
          </div>
          <div class="form-group">
            <input type="password" name="password" value="${user.password}">
          </div>
          <div class="form-group">
            <input type="text" name="phoneNumber" value="<%=user.getPNO()%>">
          </div>
          <button type="submit">Sign Up</button>
          </div>
        </form>
    </body>
</html>
  