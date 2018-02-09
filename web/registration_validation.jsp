<%-- 
    Document   : registration_validation
    Created on : 7-Mar-2017, 12:35:18 AM
    Author     : Ola
--%>


<%@ page import ="java.sql.*" %>

  
<%
    
    String name = request.getParameter("name"); 
    String uweight = request.getParameter("weight");
    String uheight = request.getParameter("height");
    String gender = request.getParameter("gender");
    String plan = request.getParameter("plan");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String utype = "Basic";
    
    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ieat_users.db", "ieat", "codeislife");

    Statement st = con.createStatement();
    //ResultSet rs;
    int i = st.executeUpdate("INSERT into USERS(name, weight, height, email, password, plan, regdate) values ('" + fname + "','" + lname + "','" + email + "','" + user + "','" + pwd + "', CURDATE())");
    if (i > 0) {
        //session.setAttribute("userid", user);
        //response.sendRedirect("welcome.jsp");
         out.print("Registration Successfull!"+"<a href='index.jsp'>Go to Login</a>");
    } else {
        response.sendRedirect("index.jsp");
    }
%>