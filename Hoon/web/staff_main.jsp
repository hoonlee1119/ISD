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
        <title>Main Page</title>
        <link rel="stylesheet" type="text/css" href="main.css">
         <%
            User user = (User)session.getAttribute("user");
        %>
    </head>
     <header>
         <h1>IoT Devices Management</h1>
      <nav>
        <ul>
       
            <li> <a href="userprofile.jsp">Account Profile</a></li>
            <li>   <a href="LogoutServlet">Logout</a><li>
       
     
        </ul>
      </nav>
        <jsp:include page="/ConnServlet" flush="true"/>
    </header>
    
    <body onload="startTime(); resetSearch();">
    </body>
</html>
