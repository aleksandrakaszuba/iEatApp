<%-- 
    Document   : rgistrationsuccess
    Created on : 20-Mar-2017, 12:20:53 PM
    Author     : Ola
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/template_parts/head.jsp" />
    <title>Congratulations</title>
</head>
<body>
    <jsp:include page="/template_parts/menu_general.jsp" />
    <div class="container" style="min-height: 400px">
         <div class="col-xs-12 col-md-6 col-md-offset-3">
            <h2>Congratulations!</h2>
            <p class="lead">You have successfully registered. </p>
            <p  class="lead">Please <a href="login.jsp">login here</a></p>
        </div>
    </div>
    </body>
    <jsp:include page="/template_parts/footer.jsp" />
