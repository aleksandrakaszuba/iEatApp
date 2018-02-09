<%-- 
    Document   : createameal
    Created on : 20-Mar-2017, 9:58:41 PM
    Author     : Ola
--%>

<%@page import="iEatPackage.model.User"%>
<%@page import="java.util.List"%>
<%@page import="iEatPackage.model.Food"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    User user = (User) session.getAttribute("user");

%>
<!DOCTYPE html>
<html>
    <jsp:include page="/template_parts/head.jsp" />
    <title>New Meal</title>
</head>
<a href="LoginServlet.do"></a>
<body>
    <%        if (user.getUsertype().equals(("admin").toLowerCase())) {  %>
    <jsp:include page="/template_parts/menu_admin.jsp" />
    <%
    } else {
    %>    
    <jsp:include page="/template_parts/menu.jsp" />
    <% } %>
    <div class="container">

        <nav class="navbar navbar-default">
            <ul class="nav navbar-nav">
                <li ><a href="ListAllFoodServlet.do" ><i class="fa fa-search"></i> Food</a></li>
                <li class="active"><a href="ListAllMealsServlet.do" >  Meals</a></li>
            </ul>
        </nav>
        <h2>Create new meal</h2>


        <form action="CreateNewMealServlet.do">
            <div class="col-xs-12"> <input  type="submit" class="btn btn-primary btn-large pull-right" style="margin:20px 10px;" href="CreateNewMealServlet.do" value="Save New Meal"> </input></div>

            <div >
                <div class="form-group" style="margin:20px 20px; clear: both;">
                    <label  style="margin:20px 0;"  class="col-sm-2" class="col-sm-2" for="mealName" class="sr-only" >Meal Name</label>
                    <input style="margin:20px 0;"  class="col-sm-10" type="text" name="mealName"  class="form-control" placeholder="Meal Name " required pattern="^[^-\s\.][a-zA-Z 0-9\.]{1,20}"  >
                </div>
                
                <div style="background:#f8f8f8;overflow:auto;padding: 22px;clear: both;">
                    <h5  > Choose food for the meal:</h5>
                    <table class="table table-responsive ">
                        <thead>
                        <th>Name</th>
                        <th> </th>
                        </thead>
                        <tbody>

                            <%
                                List<Food> listOfAllFood = (List) request.getAttribute("listOfAllFood");
                                int listsize = listOfAllFood.size();
                                for (Food f : listOfAllFood) {
                            %>

                            <tr>
                        <input type="hidden" name="foodName<%=f.getId()%>" value="<%=f.getName()%>">
                        <td><input id="<%=f.getId()%>foodcheckbox" name="id<%=f.getId()%>" type="checkbox" class="checkbox"    value="unchecked" >                               
                        <td> <input id="<%=f.getId()%>servingSize" type="number" name="servingSize<%=f.getId()%>" min="1" max="200" step="1" value="1" pattern="^[^-\s][0-9]{1,20}"> <%=f.getServingSize()%></td>
                        </td>   
                        <td class="text-left"><%=f.getName()%> (<%=(f.getServingSize())%>)</td>


                        <%
                            }
                        %>
                        </tbody>

                    </table>
                </div>

        </form>
    </div>

</div>
</div>
</body>
<script>

    for (i = 0; i <<%=listsize%>; i++) {

        id = "#" + i + "foodcheckbox";

        $(id).change(function () {

            $(this).toggleClass("checked");

            console.log(this.name);
            if ($(this).hasClass("checked")) {
                $(this).val("checked");
            } else {

                $(this).val("unchecked");
            }

        });


    }

</script>
<jsp:include page="/template_parts/footer.jsp" />
</html>
