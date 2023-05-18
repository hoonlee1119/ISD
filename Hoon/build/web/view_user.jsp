<%-- 
    Document   : main
    Created on : 17 May 2023, 2:34:48 pm
    Author     : jaehyeokseong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.User"%>
<!DOCTYPE html>
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Profile Page</title>
        <link rel="stylesheet" type="text/css" href="main.css">
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
        <jsp:include page="/ConnServlet" flush="true"/>
    </header>
             <%    
       User user = (User)session.getAttribute("user");
       String name = user.getName();
       String email = user.getEmail();
       String password = user.getPassword();
       String pno = user.getPNO();
        %>
    <body onload="startTime(); resetSearch();">
         <h1>User Account Details</h1>
         <form action="ViewUserServlet" method="post">
         <table>
            <tr>
                <td>Name:</td>
                <td><%= name%></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><%= email%></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><%= password%></td>
            </tr>
            <tr>
                <td>Phone Number:</td>
                <td><%= pno%></td>
            </tr>
        </table>
         </form>
    </body>
</html>
    
        
       