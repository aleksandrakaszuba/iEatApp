<%-- 
    Document   : userdataform
    Created on : 14-Mar-2017, 1:06:35 PM
    Author     : Ola
    Conditions : This forms runs in 2 cases a. after user register and login for the first time, b. when user wants to update own data
--%>
import iEatPackage.model.User;
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/template_parts/head.jsp" />
    <title>User information</title>
</head>
<body>

    <jsp:include page="/template_parts/menu.jsp" />
    <div class="container">
      

        <div class="col-xs-12 col-md-8 col-md-offset-2">
              <h1 class="h3 ">Tell us about yourself </h1>
            <%

                //  dailyCaloriesAllowance =  request.getAttribute("dailyCaloriesAllowance");
                //Object currentuser = (User) request.getAttribute("currentuser");
                //   out.println("<p> complete user data: " + currentuser.getEmail()  + "</p>");
%>

            <form action="UserAdvancedDataServlet.do" id="userdataform"  class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-2" for="userweight" class="sr-only"  >Your Name</label>
                    <input class="col-sm-10"  type="text" name="username" class="form-control" placeholder="Your Name"  autofocus="">
                </div>
                <div class="form-group">
                    <label class="col-sm-2" for="currentweight" class="sr-only"  >Your Weight (kg)</label>
                    <input class="col-sm-10" type="text" name="userweight" id="userweight" class="form-control" placeholder="Your weight (kg)"   autofocus="">
                </div>
                <div class="form-group">
                    <label class="col-sm-2" class="col-sm-2" for="userheight" class="sr-only" >Height (cm)</label>
                    <input class="col-sm-10" type="text" name="userheight" id="userheight" class="form-control" placeholder="Your height (cm) "  >
                </div>
                <div class="form-group">
                    <label class="col-sm-2" for="userage" class="sr-only">Age (years)</label>
                    <input class="col-sm-10" type="text" name="userage" id="userheight" class="form-control"   placeholder="Your age (years) "  >
                </div>
               
                <div class="form-group">
                    <label class="col-sm-2" for="usergender" >Gender</label><br>

                    <div class="col-sm-12">
                        <input type="radio" name="usergender" id="male" value="male" checked> Male
                        <input type="radio" name="usergender" id="female" value="female"> Female<br>
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

