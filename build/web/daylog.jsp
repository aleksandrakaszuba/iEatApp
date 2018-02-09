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
    User user = (User) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
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
    <% } %>

    <div class="container">
        <div>
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
                    <%  int caloriesTotal = 0;
                        int proteinsTotal = 0;
                        int fatsTotal = 0;
                        int carbsTotal = 0;
                        List<QuantifiedFood> listOfConsumedFood = (List) request.getAttribute("listOfConsumedFood");
                        List<Meal> listOfAllConsumedMeals = (List) request.getAttribute("listOfAllConsumedMeals");

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
                        for (Meal m : listOfAllConsumedMeals) {
                            carbsTotal += m.getCarbs();
                            proteinsTotal += m.getProteins();
                            fatsTotal += m.getFats();
                            caloriesTotal += m.getCalories();
                    %>

                    <tr> 
                        <td class="text-left"><%=m.getName()%></td>
                        <td class="text-right">1</td>
                        <td class="text-right"><%= m.getCarbs()%></td>
                        <td class="text-right"><%= m.getProteins()%></td>
                        <td class="text-right"><%= m.getFats()%></td>
                        <td class="text-right"><%=m.getCalories()%></td>
                    </tr>
                    <% }
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
