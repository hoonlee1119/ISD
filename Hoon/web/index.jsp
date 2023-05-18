<%-- 
    Document   : index
    Created on : 12 May 2023, 2:35:45 pm
    Author     : jaehyeokseong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
          <link rel="stylesheet" type="text/css" href="index.css">
    </head>
    <header>
         <h1>IoT Devices Ordering Application</h1>
      <nav>
        <ul>
       
                    <li><a href="register.jsp">Register</a></li>
                    <li><a href="login.jsp">Login</a></li>
     
        </ul>
      </nav>
        <jsp:include page="/ConnServlet" flush="true"/>
    </header>
    <body>
        <h2 ><em> WELCOME TO IOT BAY</em> </h2>
    </body>
</html>
