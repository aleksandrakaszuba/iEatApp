<%-- 
    Document   : userdataformresult
    Created on : 14-Mar-2017, 1:46:04 PM
    Author     : Ola
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/template_parts/head.jsp" />
    <title>User information result page</title>
</head>
<body>
   
    <jsp:include page="/template_parts/menu.jsp" />
    <div class="container">
    <h1>Summary:</h1>
    <%
            //  dailyCaloriesAllowance =  request.getAttribute("dailyCaloriesAllowance");
            Object dailyCaloriesAllowance =  request.getAttribute("dailyCaloriesAllowance");
          
            out.println("<p>Your daiy callories allowance is: " + dailyCaloriesAllowance + "</p>");
        
       

    %>
    </div>
    </body>
</html>
