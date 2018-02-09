<%-- 
    Document   : foodlist
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
     

        <nav class="navbar navbar-default">
            <ul class="nav navbar-nav">
                <li class="active"><a href="ListAllFoodServlet.do" ><i class="fa fa-search"></i> Food</a></li>
                <li><a href="ListAllMealsServlet.do" >  Meals</a></li>
            </ul>
        </nav>

        <div class="col-xs-12 col-md-6 col-md-offset-3">

            <form action="SearchServlet.do"
                  <div class="input-group col-md-12">
                    <input name="searchterm" type="text" class="form-control input-lg" placeholder="Search food" />
                    <span class="input-group-btn">
                        <button a href="SearchServlet.do" class="btn btn-info btn-lg" type="submit">
                            <i class="fa fa-search" aria-hidden="true"></i>
                        </button>
                    </span>
                </div> 
            </form>

            <table class="table table-responsive ">
                <thead>
                <th>Name</th>
                <th> </th>
                </thead>
                <tbody>

                    <%
                        List<Food> listOfAllFood = (List) request.getAttribute("listOfAllFood");

                        for (Food f : listOfAllFood) {
                    %>

                <div class="modal fade" id="<%=f.getId()%>food" tabindex="-1" role="dialog">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <form action="ConsumeServlet.do"> 
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4><%=f.getName()%> </h4>
                                    <input class="hidden" name="foodName" value="<%=f.getName()%>">
                                        
                                </div>
                                <div class="modal-body">

                                    <p >Calories: <span id="<%=f.getId()%>caloriesfield"><%=f.getCalories()%></span> kcal  </p>

                                    <div>Serving selection</div>
                                    
                                    <p><input id="<%=f.getId()%>serving" type="number" name="serving" min="1" max="200" step="1" value="1" required pattern="^[0-9]{1,4}\.[0-9]{1,2}"> <%=f.getServingSize()%></p>
                                    <div>Fats: <span id="<%=f.getId()%>fatsfield"><%=f.getFats()%></span>g | 
                                        Carbohydrates: <span id="<%=f.getId()%>carbsfield"><%=f.getCarbs()%></span>g | 
                                        Proteins: <span id="<%=f.getId()%>proteinsfield"><%=f.getProteins()%></span>g 
                                    </div>
                                    <script>
                                        
                                        $("#<%=f.getId()%>serving").on("change paste keyup", function() {
                                        $("#<%=f.getId()%>caloriesfield").text($(this).val() * (<%=f.getCalories()%>));
                                         $("#<%=f.getId()%>proteinsfield").text($(this).val() * (<%=(int)f.getProteins()%>));
                                          $("#<%=f.getId()%>carbsfield").text($(this).val() * (<%=(int)f.getCarbs()%>));
                                           $("#<%=f.getId()%>fatsfield").text($(this).val() * (<%=(int)f.getFats()%>));
                                        });
                                         
                                      
                                    </script>
                                        
                                        
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                                    <input type="submit" class="btn btn-primary" value="Add food to your day ">
                                </div>

                            </form>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal-dialog -->
                </div><!-- /.modal -->


                <tr> <td class="text-left"><%=f.getName()%> (<%=(f.getServingSize())%>)</td>
                    <td class="text-right"><a data-toggle="modal" data-target="#<%=f.getId()%>food">
                            <i class="fa fa-plus" aria-hidden="true"></i> Add</a></td></tr>
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
