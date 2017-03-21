<%-- 
    Document   : daylog
    Created on : 19-Mar-2017, 11:23:22 PM
    Author     : Ola
--%>

<%@page import="java.util.List"%>
<%@page import="iEatPackage.model.*"%>

<%@page import = "java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
<!DOCTYPE html>
<html>
    <jsp:include page="/template_parts/head.jsp" />
    <title>My Day</title>
</head>
<body>
  
    <jsp:include page="/template_parts/menu.jsp" />
    <div class="container">
        <div  >
            <jsp:include page="/template_parts/dash_nav.jsp" />
            <div>
                <h1>Day Log</h1>
                <hr> 
                List of today consumed food
            </div>


            <table class="table table-responsive  " style="font-size: 1em">
                <thead>

                <th class="text-left">Name</th>
                <th class="text-right">Quantity</th>
                <th class="text-right">Carbs</th>
                <th class="text-right">Proteins</th>
                <th class="text-right">Fat</th>
                <th class="text-right">Total</th>
                </thead> 

                <tbody>
                    <%
                        int caloriesTotal = 0;
                        int proteinsTotal = 0;
                        int fatsTotal = 0;
                        int carbsTotal = 0;
                        List<QuantifiedFood> listOfConsumedFood = (List) request.getAttribute("listOfConsumedFood");

                        for (QuantifiedFood f : listOfConsumedFood) {
                            caloriesTotal += f.getFood().getCalories() * (f.getQuantity());
                            carbsTotal += f.getFood().getCarbs() * (f.getQuantity());
                            proteinsTotal += f.getFood().getProteins() * (f.getQuantity());
                            fatsTotal += f.getFood().getFats() * (f.getQuantity());
                    %>
                    <tr> <td class="text-left"><%=f.getFood().getName()%></td>
                        <td class="text-right"> <%=  f.getQuantity()%></td>

                        <td class="text-right"> <%= f.getFood().getCarbs() * (f.getQuantity())%></td>
                        <td class="text-right"> <%= f.getFood().getProteins() * (f.getQuantity())%></td>
                        <td class="text-right"> <%= f.getFood().getFats() * (f.getQuantity())%></td>
                        <td class="text-right"> <%= f.getFood().getCalories() * (f.getQuantity())%></td>
                    </tr>
                    <%
                        }
                    %>

                </tbody>
                <tfoot>

                <th class="text-left"> </th>
                <th class="text-right"> </th>
                <th class="text-right"><%= carbsTotal%></th>
                <th class="text-right"><%= proteinsTotal%></th>
                <th class="text-right"><%= fatsTotal%></th>
                <th class="text-right"><%= caloriesTotal%></th>
                </tfoot> 
            </table>
            <br>
             <a href="ListAllFoodServlet.do" type="button" class="btn btn-primary btn-large">Add Food</a>
        </div>


</body>
</html>
