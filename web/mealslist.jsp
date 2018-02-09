<%-- 
    Document   : mealslist
    Created on : 20-Mar-2017, 9:58:41 PM
    Author     : Ola
--%>

<%@page import="iEatPackage.model.QuantifiedFood"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.ArrayList"%>
<%@page import="iEatPackage.model.Meal"%>
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
    <title>Login</title>
</head>
<a href="LoginServlet.do"></a>
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
       
        <nav class="navbar navbar-default">
            <ul class="nav navbar-nav">
                <li><a href="ListAllFoodServlet.do" ><i class="fa fa-search"></i> Food</a></li>
                <li class="active"><a href="ListAllMealsServlet.do"  >  Meals</a></li>
            </ul>
        </nav>
        </div>
        <div class="col-xs-12 col-md-12 ">
              <div class="col-xs-12"style="margin-top:20px">
                <%
                    String alertclass;
                    Object errormessage = (String) request.getAttribute("errormessage");
                    Object successmessage = (String) request.getAttribute("successmessage");
                    if (errormessage != null) {
                        alertclass = "has-error";
                        out.println(" <div class='alert alert-danger' ><p class=''>" + errormessage + "</p></div>");

                    }
                    if (successmessage != null) {
                        alertclass = "alert alert-success";
                        out.println("<div class='alert alert-success fade in alert-dismissable'><p class=''>" + successmessage + "</p>");

                    } else {
                        alertclass = "";
                    }
                %>
            </div>
           
            
            <div class="col-xs-12">  <a  type="button" class="btn btn-primary btn-large pull-right" style="margin:20px 10px;" href="ListAllFoodForMeals.do"> + Create New Meal</a> </div>


            <table class="table table-responsive ">
                <thead>
                <th>Name</th>
                <th> </th>
                </thead>
                <tbody>
                    <%
                        List<Meal> listOfAllMeals = (List) request.getAttribute("listOfAllMeals");
                      

                        for (Meal m : listOfAllMeals) {
                    %>
                    <tr> <td class="text-left"><%=m.getName()%>   </td>
                        <td class="text-right"><a data-toggle="modal" data-target="#<%=m.getId()%>meal">
                                <i class="fa fa-plus" aria-hidden="true"></i> Add</a></td></tr>



                <div class="modal fade" id="<%=m.getId()%>meal" tabindex="-1" role="dialog">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <form action="ConsumeMealServlet.do"> 
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4><%=m.getName()%> </h4>
                                    <input class="hidden" name="mealName" value="<%=m.getName()%>">
                                   <!-- <a data-toggle="modal" data-target="#<%=m.getId()%>meal">
                                <i class="fa fa-plus" aria-hidden="true"></i> Edit Meal's Ingredients</a>-->
                                </div>
                                <div class="modal-body">
                                    <div class="meal_ingredients_table">
                                        <div><span>Food Name</span><span>Qty</span><span>Calories</span></div>
                                    <%
                                        Set<QuantifiedFood> listOfAllMealFoods = m.getFood();

                                        for (QuantifiedFood f : listOfAllMealFoods) {
                                            out.println("<div><span>" + f.getFood().getName() + "</span><span> " + f.getQuantity() + "</span><span> " + f.getQuantity()*f.getFood().getCalories() + "</span></div>");
                                        }
                                    %>
                                    </div>
                                    <div>Meal's total calories: <span class="text-bold"><%=m.getCalories() %> kcal</span></div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                                    <input type="submit" class="btn btn-primary" value="Add meal to your day">
                                </div>

                            </form>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal-dialog -->
                </div><!-- /.modal -->

                <%
                    }
                %>


                </tbody>

            </table>

        </div>
    </div>
</body>
<jsp:include page="/template_parts/footer.jsp" />
</html>
