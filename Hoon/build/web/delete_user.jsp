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
            String deleted = (String)session.getAttribute("deleted");
        %>
        <h1>Delete User Information: <%=deleted != null ? deleted : ""%></h1>
        <form action="DeleteServlet" method="post">
            <table>
                <td>Email:</td><td><input type="text" name="email" value="${user.email}"></td>
               <td>Password:</td><td><input type="text" name="password" value="${user.password}"></td>
                <tr>
                    <td><input type="submit" value="Delete"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
