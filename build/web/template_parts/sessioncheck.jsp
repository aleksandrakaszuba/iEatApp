<%-- 
    Document   : sessioncheck
    Created on : 20-Mar-2017, 4:13:30 PM
    Author     : Ola
--%>

<%
    /* if ((session.getAttribute("email") == null) || (session.getAttribute("email") == "")) {
        response.sendRedirect("login.jsp");
    } else if ((session.getAttribute("email") != null) || (session.getAttribute("profile") == "incomplete")) {
        response.sendRedirect("userdataform.jsp");
    }*/
    
    User user = (User)session.getAttribute("user");

    out.println("<p> session time atr:" + session.getCreationTime() + "</p>");
    out.println("<p>session all atr:" + session.getAttributeNames() + "</p>");
    out.println("<p>session email atr:" + user.getName() + "</p>"); 
%>