<%-- 
    Document   : myaccount
    Created on : 7-Mar-2017, 12:24:47 AM
    Author     : Ola
--%>



<%@page import="java.util.List"%>
<%@page import = "java.sql.*" %>
<%@page import = "iEatPackage.model.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <%
        User user = (User) session.getAttribute("user");
       
    %>
<!DOCTYPE html>
<html>
    <jsp:include page="/template_parts/head.jsp" />
    <title>User information</title>
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
      
  
    <div class="col-xs-12 col-md-8 col-md-offset-2">
          <h1 class="h2">My Account</h1>

        <form action="MyAccount.do" id="userdataform"  class="form-horizontal">
            <div class="form-group">
            <label class="col-sm-3" for="username" class="sr-only"  >Your Name</label>
            <input class="col-sm-9"  type="text" name="username" class="form-control" value="<%=user.getName() %>" autofocus="" required pattern="^[^-\s][a-zA-Z0-9 ]{1,20}">
            </div>
             <div class="form-group">
            <label class="col-sm-3" for="currentweight" class="sr-only"  >Your Weight (kg)</label>
            <input class="col-sm-9" type="number" name="userweight" id="userweight" class="form-control" required placeholder="Your weight (kg)" value="<%=user.getWeight() %>" autofocus=""  min="30" max="350" step="1" pattern="^[^-\s\.][0-9\.]{1,20}">
             </div>
              <div class="form-group">
            <label class="col-sm-3"  for="userheight" class="sr-only" >Your Height (cm)</label>
            <input class="col-sm-9" type="number" name="userheight" id="userheight" class="form-control" required value="<%=user.getHeight() %>" placeholder="Your height (cm) " min="100" max="250" step="1"  pattern="^[^-\s\.][0-9.\]{1,20}" >
              </div>
            <div class="form-group">
            <label class="col-sm-3" for="userage" class="sr-only">Age (years)</label>
            <input class="col-sm-9" type="number" name="userage" id="userheight" class="form-control" required value="<%=user.getAge() %>" placeholder="Your age (years) " min="14" max="100" step="1"   pattern="^[^-\s0\.][0-9\.]{1,20}" >
            </div>
             <div class="form-group">
                    <label class="col-sm-12" for="usergender" >Gender</label><br>

                    <div class="col-sm-12">
                        <input type="radio" name="usergender" id="male" value="male" checked> Male <br>
                        <input type="radio" name="usergender" id="female" value="female"> Female 
                    </div>
                </div>
                 

                <div class="form-group">
                    <label class="col-sm-12"  for="weightlostspeed">Preferred weight lost speed</label><br>
                    <div class="col-sm-12">
                        <input type="radio" name="weightlostspeed" id="plan1" value="1" checked > Maintain current weight<br>
                        <input type="radio" name="weightlostspeed" id="plan2" value="2"  > 1/4 kg per week<br>
                        <input type="radio" name="weightlostspeed" id="plan3"  value="3"  > 1/2 kg per week<br>
                        <input type="radio" name="weightlostspeed" id="plan4"  value="4"  > 3/4 kg per week<br>
                        <input type="radio" name="weightlostspeed" id="plan5"  value="5"  > 1 kg per week<br>
                    </div>
                </div>
               <script>
                $("#<%=user.getGender() %>").prop("checked", true);
                 $("#plan<%=user.getPlan() %>").prop("checked", true);
                
               
                </script>
            <input type="submit" value="Save"  class="btn btn-lg btn-primary">
 
        </form>
    </div>
    </div>
</body>
<jsp:include page="/template_parts/footer.jsp" />
</html>
