<%-- 
    Document   : logout_val.jsp
    Created on : 17-Mar-2017, 6:53:18 PM
    Author     : Ola
--%>

<%@ page import ="java.sql.*" %>
<%
session.setAttribute("email", null);
session.invalidate();
response.sendRedirect("login.jsp");


  

%>
