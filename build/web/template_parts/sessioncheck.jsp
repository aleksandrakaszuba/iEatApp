<%-- 
    Document   : sessioncheck
    Created on : 20-Mar-2017, 4:13:30 PM
    Author     : Ola
--%>

<%@page import="iEatPackage.model.User"%>
<%
    if (session == null) {
        // the user *does not* have a valid session; 
        response.sendRedirect("login.jsp");
    } else {
        //session exists
        User user = (User) session.getAttribute("user");
        if (user.getUsertype().equals(("admin").toLowerCase())) {
            out.println("<p> Admin </p>");
        }
        out.println("<p> session time atr:" + session.getCreationTime() + "</p>");
        out.println("<p>session all atr:" + session.getAttributeNames() + "</p>");
        out.println("<p>session email atr:" + user.getName() + "</p>");
    }

%>