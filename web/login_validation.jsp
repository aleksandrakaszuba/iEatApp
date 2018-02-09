<%-- 
    Document   : login
    Created on : 6-Mar-2017, 10:40:41 PM
    Author     : Ola
--%>

<%@ page import ="java.sql.*" %>
<%@ page language="java" import="java.util.*"%>
<%@ page language="java" import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/template_parts/head.jsp" />
    <title>Login</title>
</head>
<body>

    <jsp:include page="/template_parts/menu.jsp" />
    <div class="container">
        <%
            String email = request.getParameter("username");
            String password = request.getParameter("password");
            String name;
            String usertype;
          //  String allowance;
          
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ieat_users.db", "ieat", "codeislife");
            Statement st = con.createStatement();
            ResultSet result;
            result = st.executeQuery("SELECT * FROM USERS ");
            while (result.next()) {
        %>
        <li><%= result.getString("name")%> <%= result.getString("password")%> <%= result.getString("email")%>
        </li> <%
            }

            ResultSet rs;
            rs = st.executeQuery("SELECT * FROM USERS where EMAIL='" + email + "' and password='" + password + "'");
            if (rs.next()) {
                name = rs.getString("name");
                usertype = rs.getString("usertype");
               // allowance = rs.getString("allowance");
                session.setAttribute("email", email);
                session.setAttribute("name", name);
                session.setAttribute("usertype", usertype);
              
                    
                //response.sendRedirect("validation_db/succesrjsp");
                out.println("<h2> Welcome, " + session.getAttribute("name") + "</h2>");
                //out.println("pass " + password);

               
                out.println("<p> session time atr:" + session.getCreationTime() + "</p>");
                out.println("<p>session all atr:" + session.getAttributeNames() + "</p>");
                out.println("<p>session email atr:" + session.getAttribute("email") + "</p>");
                out.println("<p>session name  atr:" + session.getAttribute("name") + "</p>");
                out.println("<p>session usertype  atr:" + session.getAttribute("usertype") + "</p>");
                out.println("<p> Success <a href='success.jsp'>Success page</a>" + "</p>");
                out.println("<p> <a href='logout.jsp'>Log out</a>" + "</p>");

            } else {
                out.println("Invalid password <a href='login.jsp'>try again</a>");
            }
             con.close();

        %>

    </div>

    <jsp:include page="/template_parts/footer.jsp" />