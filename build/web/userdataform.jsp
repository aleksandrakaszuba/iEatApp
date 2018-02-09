<%-- 
    Document   : userdataform
    Created on : 14-Mar-2017, 1:06:35 PM
    Author     : Ola
    Conditions : This forms runs in 2 cases a. after user register and login for the first time, b. when user wants to update own data
--%><%@page import="iEatPackage.model.User"%>

 
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

    <jsp:include page="/template_parts/menu_general_lout.jsp" />
    <div class="container">


        <div class="col-xs-12 col-md-8 col-md-offset-2">
            <h1 class="h3 ">Tell us about yourself </h1>
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
            <form action="UserAdvancedDataServlet.do" id="userdataform"  class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-2" for="username" class="sr-only"  >Your Name</label>
                    <input class="col-sm-10"  type="text" name="username" class="form-control"   placeholder="Your Name"  autofocus="" required pattern="^[^-\s][a-z A-Z 0-9]{1,20}">
                </div>
                <div class="form-group">
                    <label class="col-sm-2" for="currentweight" class="sr-only"  >Your Weight (kg)</label>
                    <input class="col-sm-10" type="number" name="userweight" id="userweight" class="form-control"  required placeholder="Your weight (kg)"  min="30" max="350" step="1" value=""  autofocus=""pattern="^[^-\s\.][0-9\.]{1,6}">
                </div>
                <div class="form-group">
                    <label class="col-sm-2" class="col-sm-2" for="userheight" class="sr-only" >Height (cm)</label>
                    <input class="col-sm-10" type="number" name="userheight" id="userheight" class="form-control" required   placeholder="Your height (cm) "  min="100" max="250" step="1" value="" required  pattern="^[0-9]{1,3}">
                </div>
                <div class="form-group">
                    <label class="col-sm-2" for="userage" class="sr-only">Age (years)</label>
                    <input class="col-sm-10" type="number" name="userage" id="userheight" class="form-control" required   placeholder="Your age (years) "  min="14" max="100" step="1" value="" pattern="^[0-9]{1,3}" >
                </div>

                <div class="form-group">
                    <label class="col-sm-2" for="usergender" >Gender</label><br>

                    <div class="col-sm-12">
                        <input type="radio" name="usergender" id="male" value="male" checked  > Male
                        <input type="radio" name="usergender" id="female" value="female" > Female<br>
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


                <input type="submit" value="Save"  class="btn btn-lg btn-primary">

            </form>
        </div>
    </div>
</body>
<jsp:include page="/template_parts/footer.jsp" />
</html>

