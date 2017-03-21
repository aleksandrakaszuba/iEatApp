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
%>
<!DOCTYPE html>
<html>
    <jsp:include page="/template_parts/head.jsp" />
    <title>User information</title>
</head>
<body>
   
    <jsp:include page="/template_parts/menu.jsp" />
    <div class="container">
      
  
    <div class="col-xs-12 col-md-8 col-md-offset-2">
          <h1 class="h2">My Account</h1>

        <form action="MyAccount.do" id="userdataform"  class="form-horizontal">
            <div class="form-group">
            <label class="col-sm-3" for="userweight" class="sr-only"  >Your Name</label>
            <input class="col-sm-9"  type="text" name="username" class="form-control" value="<%=user.getName() %>" autofocus="">
            </div>
             <div class="form-group">
            <label class="col-sm-3" for="currentweight" class="sr-only"  >Your Weight (kg)</label>
            <input class="col-sm-9" type="text" name="userweight" id="userweight" class="form-control" placeholder="Your weight (kg)" value="<%=user.getWeight() %>" autofocus="">
             </div>
              <div class="form-group">
            <label class="col-sm-3"  for="userheight" class="sr-only" >Your Height (cm)</label>
            <input class="col-sm-9" type="text" name="userheight" id="userheight" class="form-control" value="<%=user.getHeight() %>" placeholder="Your height (cm) "  >
              </div>
            <div class="form-group">
            <label class="col-sm-3" for="userage" class="sr-only">Age (years)</label>
            <input class="col-sm-9" type="text" name="userage" id="userheight" class="form-control" value="<%=user.getAge() %>" placeholder="Your age (years) "  >
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
