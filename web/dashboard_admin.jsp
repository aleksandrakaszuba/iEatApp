<%-- 
    Document   : myday
    Created on : 19-Mar-2017, 11:23:12 PM
    Author     : Ola
--%>

<%@page import="iEatPackage.model.User"%>
<%@page import="java.util.List"%>
<%@page import = "java.sql.*" %>
<%@page import = "iEatPackage.model.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

    <%
        User user = (User) session.getAttribute("user");
    %>

    <head>
        <jsp:include page="/template_parts/head.jsp" />

        <title>My Day</title>
    </head>

    <body>

        <%
            if (user.getUsertype().equals(("admin").toLowerCase())) {  %>
        <jsp:include page="/template_parts/menu_admin.jsp" />
        <%
        } else {
        %>    
        <jsp:include page="/template_parts/menu.jsp" />
        <% }%>

        <div class="container">

            <div class="col-xs-12 col-sm-6">
                <p> Welcome <%= user.getName()%>
                <h3>Manage Food Database </h3>
                 <p>Add and modify entries in the food database</p>
                 <div><img src="images/Food-Dome-512.png" class="img-rounded " style="width: 40%; height: auto;  padding: 10px; margin: 10px;"></div>
                <a href="ListAllFoodServlet.do" type="button" class="btn btn-primary btn-large">Manage Food Database</a> 
            </div>
         
          <!--  <div class="col-xs-12 col-sm-6">

                <h2>Manage Users Database </h2>
                <p>Some copy</p>
                <img src="..." class="img-rounded"  style="width: 100%; height: 200px; background:#f8f8f8; padding: 10px; margin: 10px;">
                <a href="ListAllFoodServlet.do" type="button" class="btn btn-primary btn-large">Manage Users</a>
            </div>
          -->

        </div>

       
    </body>
    <jsp:include page="/template_parts/footer.jsp" />
</html>
