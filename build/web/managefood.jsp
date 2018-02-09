<%-- 
    Document   : createfood
    Created on : 21-Mar-2017, 2:11:39 PM
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
                <li><a href="ListAllFoodServlet.do" ><i class="fa fa-search"></i> Search Food</a></li>
            </ul>
        </nav>
        <div><a  type="button" class="btn btn-primary btn-large pull-right" data-toggle="modal" data-target="#newfood"> + Create New Food</a></div>
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
        
        <div class="modal fade" id="newfood" tabindex="-1" role="dialog">
            <form action="ManageFoodServlet.do"> 
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>     
                            <p> Food Name: <input  class="" type="text"  name="foodName" required pattern="^[^-\s][a-z A-Z 0-9]{1,20}" title="Min 1, max 20 characters"></p>
                        </div>
                        <div class="modal-body">
                            <input class="hidden" name="id" value="0" required>
                                   <input  class="hidden" type="text"  name="modify" value="false">
                                      <input  class="hidden" type="text"  name="create" value="true">
                            <p>Calories: <input type="text" name="calories"  required  pattern="^[^-\s\.][0-9\.]{1,6}" title="Decimal number, max 6 characters, no space"> kcal </p>
                            <p>Serving: <input type="text" name="serving"   required pattern="^[^-\s0][a-z A-Z 0-9]{1,20}" title="Min 1, max 20 characters"></p>
                             
                            <p>Fats: <input type="text" name="fats" required pattern="^[^-\s\.][0-9\.]{1,6}" title="Decimal number, max 6 characters, no space">g </p>
                            <p>Carbohydrates: <input type="text" name="carbs"  required pattern="^[^-\s\.][0-9\.]{1,6}" title="Decimal number, max 6 characters, no space"> g </p>
                            <p>Proteins: <input type="text" name="proteins"  required pattern="^[^-\s\.][0-9\.]{1,6}" title="Decimal number, max 6 characters, no space">g </p>
                        </div>
                    </div><!-- /.modal-content -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                        <input type="submit" class="btn btn-primary" value="Save">
                    </div>
                </div><!-- /.modal-dialog -->
            </form>
        </div><!-- /.modal -->


        <div class="col-xs-12 col-md-6 col-md-offset-3">
            <form action="SearchServlet.do"
                  <div class="input-group col-md-12">
                    <input name="searchterm" type="text" class="form-control input-lg" placeholder="Search food" />
                    <span class="input-group-btn">
                        <button a href="SearchServlet.do" class="btn btn-info btn-lg" type="submit">
                            <i class="fa fa-search" aria-hidden="true"></i>
                        </button>
                    </span>

            </form>
        </div> 
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
                        <form action="ManageFoodServlet.do"> 
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4><%=f.getName()%> </h4>
                                <input  class="hidden" type="text"  name="foodName" value="<%=f.getName()%>">
                                      <input  class="hidden" type="text"  name="modify" value="true">
                                      <input  class="hidden" type="text"  name="create" value="false">
                                    
                              <!--  <input type="text"  name="newFoodName" value="<%=f.getName()%>" required pattern="^[^-\s].*">-->

                            </div>
                            <div class="modal-body">
                                <input class="hidden" name="id" value="<%=f.getId()%>">
                                <p>Calories: <input type="text" id="<%=f.getId()%>caloriesfield"name="calories"  value="<%=f.getCalories()%>" required pattern="^[^-\s\.0][0-9\.]{1,6}" title="Decimal number, max 6 characters, no space"> kcal </p>
                                <p>Serving: <input type="text" id="<%=f.getId()%>servingfield" name="serving" value="<%=f.getServingSize()%>" required pattern="^[^-\s\.0][a-z A-Z 0-9]{1,20}" title="Min 1, max 20 characters"></p>
                                <p>Fats: <input type="text" id="<%=f.getId()%>fatsfield" name="fats" value="<%=f.getFats()%>" required pattern="^[^-\s\.][0-9\.]{1,6}" title="Decimal number, max 6 characters, no space">g </p>
                                <p>Carbohydrates: <input type="text" id="<%=f.getId()%>carbsfield" name="carbs" value="<%=f.getCarbs()%>"required pattern="^[^-\s\.][0-9\.]{1,6}" title="Decimal number, max 6 characters, no space"> g </p>
                                <p>Proteins: <input type="text" id="<%=f.getId()%>proteinsfield" name="proteins" value="<%=f.getProteins()%>"required pattern="^[^-\s\.][0-9\.]{1,6}" title="Decimal number, max 6 characters, no space">g </p>
                            </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                        <input type="submit" class="btn btn-primary" value="Save">
                    </div>

                    </form>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->


<tr> <td class="text-left"><%=f.getName()%> (<%=(f.getServingSize())%>)</td>
    <td class="text-right"><a data-toggle="modal" data-target="#<%=f.getId()%>food">
            <i class="fa fa-pencil" aria-hidden="true"></i></a></td></tr>
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
