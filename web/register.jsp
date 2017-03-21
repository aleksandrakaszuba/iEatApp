<%-- 
    Document   : register
    Created on : 6-Mar-2017, 10:15:17 PM
    Author     : Ola
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/template_parts/head.jsp" />
    <title>Register</title>
</head>
<body>
    <jsp:include page="/template_parts/menu.jsp" />
    <div class="container">
    <div class="col-xs-12 col-md-6 col-md-offset-3">


        <p>Already have an account? <a href="login.jsp">Login here</a></p>

        <form action="RegisterServlet.do" class="form-register"  >
            <h1 class="h2">Register</h1>
            <div><%

                String errorclass;
                Object errormessage = (String) request.getAttribute("errormessage");
                if (errormessage != null) {
                    errorclass = "has-error";
                    out.println("<p class=''>" + errormessage + "</p>");

                } else {
                    errorclass = "";
                }


                %></div>
            <label for="username" >Email</label>
            <input type="text" id="username" name="username" class="form-control" placeholder="Email"  autofocus="">

            <label for="password"  >Password</label>
            <input type="password" name="password"  class="form-control" placeholder="Password"  >


            <br>
            <input type="submit" class="btn btn-lg btn-primary  " value="Get Started">
        </form>
    </div>
    </div>
</body>
<jsp:include page="/template_parts/footer.jsp" />
</html>
