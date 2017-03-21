<%-- 
    Document   : myday
    Created on : 19-Mar-2017, 11:23:12 PM
    Author     : Ola
--%>

<%@page import="java.util.List"%>
<%@page import = "java.sql.*" %>
<%@page import = "iEatPackage.model.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    /* if ((session.getAttribute("email") == null) || (session.getAttribute("email") == "")) {
        response.sendRedirect("login.jsp");
    } else if ((session.getAttribute("email") != null) || (session.getAttribute("profile") == "incomplete")) {
        response.sendRedirect("userdataform.jsp");
    }*/

    User user = (User) session.getAttribute("user");

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
        <%
            Integer dailyCaloriesAllowance = (Integer) request.getAttribute("dailyCaloriesAllowance");
            
            String basemsg;
            String displaymsg;
            String budgettype;
            int displayCaloriesbase;
            int displayCalories;
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
            }
              if( dailyCaloriesAllowance - caloriesTotal <0 ){
                  
                  displayCalories = caloriesTotal - dailyCaloriesAllowance;
                  displayCaloriesbase = caloriesTotal;
                  displaymsg = "Calories over budget";
                    basemsg = "All calories consumed today";
                    budgettype = "Over budget";
              }else{
                   displayCalories = dailyCaloriesAllowance - caloriesTotal ;
                    displayCaloriesbase = caloriesTotal;
                    displaymsg = "Calories under budget (available)";
                    basemsg = "Consumed calories";
                    budgettype = "Under budget";
              }
        %>
        <div  >
            <div>
                <div class="row">
                    <div class="col-xs-12  "><h1 class="h3">My Day</h1></div>
                    <div class="col-xs-12  ">
                        <a href="ListAllFoodServlet.do" type="button" class="btn btn-primary btn-large pull-right "  >Add Food</a>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <jsp:include page="/template_parts/mydaymenu.jsp" />
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <h4>Hi, <%=user.getName()%>! </h4>
                    </div>
                </div>
                <div id="calories">
                    <br><p style="background:aliceblue; padding: 5px;">Your budget: <%=dailyCaloriesAllowance%> kcal ,
                        Consumed: <%=caloriesTotal%> kcal,
                        <%=budgettype%>: <%=dailyCaloriesAllowance - caloriesTotal%> kcal</p>
                    <div id="calorieschart" style=" width: 800px; height: 400px;"></div>
                </div>
                <div id="nutrients">
                    <br><p style="background:aliceblue; padding: 5px;">Proteins: <%=proteinsTotal%> g, 
                        Fats: <%=fatsTotal%> g, 
                        Carbs: <%=carbsTotal%> g </p>
                    <div id="nutrientschart" style=" width: 800px; height: 400px;"></div>

                </div>
            </div>
        </div>
        <br>
        <a href="ListAllFoodServlet.do" type="button" class="btn btn-primary btn-large">Add Food</a>
        <br>

    </div>

    <script type="text/javascript">
        // Load Charts and the corechart package.
        google.charts.load('current', {'packages': ['corechart']});

        // Draw the pie chart for calories.
        google.charts.setOnLoadCallback(drawCaloriesChart);

        // Draw the pie chart for nutrients.
        google.charts.setOnLoadCallback(drawNutrientsChart);

        function drawCaloriesChart() {
            var data = google.visualization.arrayToDataTable([
                
                
                ['Calories', 'Hours per Day'],
                ['<%=basemsg%>', <%=displayCaloriesbase%>],
                ['<%=displaymsg%>', <%=displayCalories%>]
               
                
            ]);
            var options = {
                colors: ['#9cf5da', '#bbefe8'],
                'pieSliceText': 'value',
                 // backgroundColor: '#f8f8f8',
                pieHole: 0.3
                 
            };

            // Instantiate and draw the chart for calories.
            var chart = new google.visualization.PieChart(document.getElementById('calorieschart'));
            chart.draw(data, options);
        }
        function drawNutrientsChart() {
            var data = google.visualization.arrayToDataTable([
                ['Nutrients', 'Hours per Day'],
                ['Proteins', <%=proteinsTotal%>],
                ['Carbs', <%=carbsTotal%>],
                ['Proteins', <%=proteinsTotal%>]
            ]);
            var options = {
                colors: ['#e6c0dd', '#bbefe8', '#d4eafd'],
               // backgroundColor: '#f8f8f8',
                'pieSliceText': 'value',
                pieHole: 0.3 
            };

            // Instantiate and draw the chart for calories.
            var chart = new google.visualization.PieChart(document.getElementById('nutrientschart'));
            chart.draw(data, options);

        }

       // $("#nutrients").fade(0.1);
        $("#caloriesInMyDay").click(function () {
            $("#nutrients").hide();
            $("#calories").show();
        });
        $("#nutrientsInMyDay").click(function () {
            $("#nutrients").show();
            $("#calories").hide();

        });


    </script>
</body>
<jsp:include page="/template_parts/footer.jsp" />
</html>
