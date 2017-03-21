<%-- 
    Document   : index
    Created on : 6-Mar-2017, 7:50:24 PM
    Author     : Ola
--%>
<%@page import = "java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/template_parts/head.jsp" />
    <title>iEat App</title>
</head>
<body>
    <jsp:include page="/template_parts/menu.jsp" />
    <div class="container">
        <h1>Welcome to iEat</h1>
        <p class="lead">Start your journey to healthier eating</p>
       
         
              
            <hr class="half-rule"> 
            <div class="row bs-docs-featured-sites"> <div class="col-xs-6 col-sm-3"> 
                    <a href="http://expo.getbootstrap.com/2014/10/29/lyft/" target="_blank" title="Lyft"> 
                       
                    </a> 
                </div> 
                <div class="col-xs-6 col-sm-3"> 
                    <a href="http://expo.getbootstrap.com/2014/09/30/vogue/" target="_blank" title="Vogue"> 
                        
                    </a> 
                </div> 
                <div class="col-xs-6 col-sm-3"> <a href="http://expo.getbootstrap.com/2014/03/13/riot-design/" target="_blank" title="Riot Design"> 
                         
                    </a> 
                </div> <div class="col-xs-6 col-sm-3"> 
                    <a href="http://expo.getbootstrap.com/2014/02/12/newsweek/" target="_blank" title="Newsweek"> 
                        
                    </a> 
               
            </div> <hr class="half-rule"> 
            <p class="lead">Lorem ipsum</p> 
            <a href="register.jsp" class="btn btn-lg btn-primary ">Get started</a> 
        </div>
        <ul>
            <%
                Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/ieat_users.db", "ieat", "codeislife");
                Statement s = c.createStatement();
                String query = "SELECT * FROM USERS";
                ResultSet result = s.executeQuery(query);
                while (result.next()) {
            %>
            <!-- <li><%= result.getString("name")%>
             </li> --><%
                 }
                 c.close();
            %>

    </div>
</ul>
</body>
</html>
