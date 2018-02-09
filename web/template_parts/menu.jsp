<%-- 
    Document   : menu
    Created on : 6-Mar-2017, 9:05:28 PM
    Author     : Ola
--%>

<%@page import="iEatPackage.model.User"%>
<header>
    <nav class="navbar navbar-default">
        <div class="container-fluid">

            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">iEat</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right" id="top-nav">

                     <li><a href="MyDayServlet.do" ><i class="fa fa-pie-chart" aria-hidden="true"></i> My Dash</a></li>
                    <li><a href="ListUserFoodHistory.do"  ><i class="fa fa-calendar-o" aria-hidden="true"></i> Day Log</a></li> 
                   <!-- <li><a href="/iEatApp/userdataform.jsp"><i class="fa fa-user-circle "></i> My Account</a></li>-->
                    <li><a href="/iEatApp/myaccount.jsp"><i class="fa fa-user-circle "></i> My Account</a></li>
                     <!--<li><a href="/iEatApp/login.jsp"><i class=""></i> Login</a></li>-->
                     <!--<li><a href="/iEatApp/register.jsp"><i class=""></i> Register</a></li>-->
                    <li><a href="/iEatApp/logout.jsp"><i class=""></i> Logout</a></li>
 
                </ul>
            </div>
        </div>
    </nav>
</header>