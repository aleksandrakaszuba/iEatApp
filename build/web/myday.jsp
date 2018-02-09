<%-- 
    Document   : myday
    Created on : 19-Mar-2017, 11:23:12 PM
    Author     : Ola
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
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
        <title>Dashboard</title>
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
            <%   
    
                LocalDate localDate = LocalDate.now();//For reference
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy, MM, dd");
                String formatedDate = localDate.format(formatter);
              

                //  List<QuantifiedFood> listOfConsumedFood = (List) request.getAttribute("listOfConsumedFood");
                Integer dailyCaloriesAllowance = (Integer) request.getAttribute("dailyCaloriesAllowance");
                int[] caloriesList = (int[]) request.getAttribute("caloriesList");
                Integer caloriesTotal = (Integer) request.getAttribute("caloriesTotal");
                Integer proteinsTotal = (Integer) request.getAttribute("proteinsTotal");
                Integer fatsTotal = (Integer) request.getAttribute("fatsTotal");
                Integer carbsTotal = (Integer) request.getAttribute("carbsTotal");
                String basemsg;
                String displaymsg;
                String budgettype;
                String baseColor;
                String additionalColor;
                int displayCaloriesbase;
                int displayCalories;

                if (dailyCaloriesAllowance - caloriesTotal < 0) { 
                    displayCalories = Math.abs(caloriesTotal - dailyCaloriesAllowance);
                    displayCaloriesbase = 0;
                    displaymsg = "Calories over budget";
                    basemsg = "Allowance";
                    budgettype = "Calories over budget";
                    baseColor = "#bce8f1";
                    additionalColor = "fuchsia";
                } else {
                    displayCalories = dailyCaloriesAllowance - caloriesTotal;
                    displayCaloriesbase = caloriesTotal;
                    displaymsg = "Calories under budget (available)";
                    basemsg = "Consumed calories";
                    budgettype = "Calories under budget";
                    baseColor = "#bce8f1";
                    additionalColor = "#b6d957";
                }
            %>
            <div  >
                <div>
                    <div class="row">
                        <!--   <div class="col-xs-12  "><h1 class="h3">Dashboard</h1></div>-->
                        <div class="col-xs-12  ">
                            <a href="ListAllFoodServlet.do" type="button" class="btn btn-primary btn-large pull-right "  ><i class="fa fa-plus" aria-hidden="true"></i> Add Food</a>
                        </div>
                    </div>
                    <div class="row" class="clearfix">
                        <div class="col-xs-12">
                            <h4>Hi, <%=user.getName()%>! </h4>
                        </div>
                    </div>
                    <div> <hr></div>
                    <h2>Today's Statistics</h2>

                    <div id="calories lead" class="col-xs-12 col-sm-6">
                        <br><p style="background:aliceblue; padding: 15px; border-radius: 15px; font-size: 15px;" class=" ">Your calories allowance: <span class="text-bold"><%=dailyCaloriesAllowance%> kcal</span> <br>
                            Total calories consumed: <span class="text-bold"> <%=caloriesTotal%> kcal </span><br>
                            <%=budgettype%>: <span class="text-bold"> <%= Math.abs(dailyCaloriesAllowance - caloriesTotal)%> kcal</span></p>
                        <div id="calorieschart" style=" width: 500px; height: 400px;"></div>
                    </div>
                    <div id="nutrients" class="col-xs-12 col-sm-6">
                        <br><p style="background:aliceblue; padding: 15px; border-radius: 15px; font-size: 15px;" >Proteins:<span class="text-bold"> <%=proteinsTotal%> g</span> <br> 
                            Fats: <span class="text-bold"><%=fatsTotal%> g </span><br> 
                            Carbs:<span class="text-bold"> <%=carbsTotal%> g</span> </p>
                        <div id="nutrientschart" style=" width: 500px; height: 400px;"></div>

                    </div>
                </div>
            </div>
            <div class="col-xs-12"><hr>
                <h2>History</h2> 
                <div id="historychart" style=" width: 800; height: 400px;"></div>
            </div>

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
                    colors: ['<%=baseColor%>', '<%=additionalColor%>'],
                    'pieSliceText': 'value',
                     pieSliceTextStyle: {
            color: 'black',
          },
                    // backgroundColor: '#f8f8f8',
                    pieHole: 0.4

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
                    ['Fats', <%=fatsTotal%>]
                ]);
                var options = {
                    colors: ['orange', 'gold', 'lightgrey'],
                    // backgroundColor: '#f8f8f8',
                    'pieSliceText': 'value',
                    pieHole: 0.4
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

            google.charts.load('current', {packages: ['corechart', 'bar']});
            google.charts.setOnLoadCallback(drawHistory);

            function drawHistory() {

                var data = new google.visualization.DataTable();


                data.addColumn('date', 'Day');
                data.addColumn('number', 'Calories Intake');
                data.addRows([
                    [new Date(<%=(localDate.minusDays(6)).format(formatter)%>), <%=caloriesList[6]%>],
                    [new Date(<%=(localDate.minusDays(5)).format(formatter)%>), <%=caloriesList[5]%>],
                    [new Date(<%=(localDate.minusDays(4)).format(formatter)%>), <%=caloriesList[4]%>],
                    [new Date(<%=(localDate.minusDays(3)).format(formatter)%>), <%=caloriesList[3]%>],
                    [new Date(<%=(localDate.minusDays(2)).format(formatter)%>), <%=caloriesList[2]%>],
                    [new Date(<%=(localDate.minusDays(1)).format(formatter)%>), <%=caloriesList[1]%>],
                    [new Date(<%=localDate.format(formatter)%>),<%=caloriesList[0]%>],
                ]);

                var options = {
                    bar: {groupWidth: "95%"},
                    colors: ['<%=baseColor%>'],
                    title: 'Calories intake statistics',
                    hAxis: {
                        title: 'Day',
                        format: 'MMM d, y'
                    },
                    vAxis: {
                        title: 'Calories'
                    }
                };

                var chart = new google.visualization.ColumnChart(
                        document.getElementById('historychart'));

                chart.draw(data, options);
            }
        </script>
    </body>
    <jsp:include page="/template_parts/footer.jsp" />
</html>
