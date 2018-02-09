<%-- 
    Document   : login
    Created on : 6-Mar-2017, 9:03:10 PM
    Author     : Ola
--%>

<%@page import="iEatPackage.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/template_parts/head.jsp" />
        <title>Login</title>
    </head>
    <body>
             <jsp:include page="/template_parts/menu_general.jsp" />
    <div class="container">
    
        <div class="col-xs-12 col-md-6 col-md-offset-3">

            <p>New to iEat? <a href="register.jsp">Register here</a> and start making and meeting your goals!</p>
           
            <form action="LoginServlet.do" class="form-login" class="text-left">
                 <h1 class="h2">Log in</h1>
                 <div class="bg-danger">
                <% 
                    String errorclass;
                    Object errormessage = (String) request.getAttribute("errormessage");
                    if(errormessage!=null){
                         errorclass = "has-error";
                    out.println("<p class=''>" + errormessage + "</p>");
                    
                    }else{
                    errorclass="";
                    }
                %>
            </div>
                <div class="form-group <%= errorclass %>">
                    <label class="control-label" for="username" >Email</label>
                    <input type="text" id="username" name="username" class="form-control" placeholder="Email"  autofocus="">
                </div>
                <div class="form-group <%= errorclass %>">
                    <label class="control-label" for="password" class="text-left" >Password</label>
                    <input type="text"  id="password" placeholder="Password"  name="password" class="form-control"     >
                </div>
                <br>
                <input class="btn btn-lg btn-primary  " type="submit" value="Login">
            </form>
        </div>
    </div>


    <jsp:include page="/template_parts/footer.jsp" />