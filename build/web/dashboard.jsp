<%-- 
    Document   : dashboard
    Created on : 6-Mar-2017, 10:28:52 PM
    Author     : Ola
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/template_parts/head.jsp" />
    <title>My Day</title>
</head>
<body>
    <jsp:include page="/template_parts/menu.jsp" />
    <div  class="container">
    <jsp:include page="/template_parts/dash_nav.jsp" />
    
        <div>
            <h1>{{message}}</h1>
            <hr>
            <b>Hi, Eric {{name}}! </b>Your budget: {{budget}}, 
            Consumed today: {{caloriesused}} ,  
            Left: {{caloriesleft}}  


            <script type="text/javascript">
                google.charts.load("current", {packages: ["corechart"]});
                google.charts.setOnLoadCallback(drawChart);
                function drawChart() {
                    var data = google.visualization.arrayToDataTable([
                        ['Calories', 'Hours per Day'],
                        ['Used calories', 1200],
                        ['Available calories', 130]
                    ]);

                    var options = {
                        colors: ['#f6c7b6', '#f8f8f8'],
                        'pieSliceText': 'value',
                        pieHole: 0.5,
                    };

                    var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
                    chart.draw(data, options);
                }
            </script>
            
            <div id="donutchart" style="width: 800px; height: 400px;"></div>
        </div>
     <br>
    <a href="#food" type="button" class="btn btn-primary btn-large">Add Food</a>
    </div>
   
    <jsp:include page="/template_parts/footer.jsp" />
