<%-- 
    Document   : index
    Created on : 6-Mar-2017, 7:50:24 PM
    Author     : Ola
--%>
<%@page import="iEatPackage.model.User"%>
<%@page import = "java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session != null) {

        User user = (User) session.getAttribute("user");
        if (user == null) {
            // out.println("<p> session time atr:" + session.getCreationTime() + "</p>");
        } else {
            //user and session exists
            response.sendRedirect("MyDayServlet.do");
        }
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/template_parts/head.jsp" />
        <title>iEat App</title>
    </head>

    <body id="home" >
        <jsp:include page="/template_parts/menu_general.jsp" />
        <div  >

            <div class="container" >
                <div style=" text-shadow: 1">
                    <h1 style="color:white" class="text-shadow">Welcome to <span style="color:orange">iEat</span></h1>
                    <h3 style="color:white; "class=" text-shadow"><span>Start your journey to healthier eating</span></h3>
                    <br>
                    <p style="color:white"  class="lead text-shadow bullet"><i class="fa fa-check-circle " aria-hidden="true"></i>  Determine your daily caloric needs</p> 
                    <p style="color:white"  class="lead text-shadow bullet"><i class="fa fa-check-circle  " aria-hidden="true"></i>  Log your meals and track your calorie intake</p> 
                    <p style="color:white"  class="lead text-shadow bullet"><i class="fa fa-check-circle  " aria-hidden="true"></i>  Save your favorite meals</p> 
                    <p style="color:white"  class="lead text-shadow bullet"><i class="fa fa-check-circle  " aria-hidden="true"></i>  Tracks your progress towards your goals</p>           
                    <a href="register.jsp" class="btn btn-lg btn-primary " style="margin:30px 0px ; background: #7db965; padding: 11px 29px;
                       font-size: 21px;">Get started</a> 
                </div>
            </div>
        </div>



    </body>
</html>
