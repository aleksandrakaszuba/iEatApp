package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.sql.*;
import iEatPackage.model.*;

public final class myday_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    /* if ((session.getAttribute("email") == null) || (session.getAttribute("email") == "")) {
        response.sendRedirect("login.jsp");
    } else if ((session.getAttribute("email") != null) || (session.getAttribute("profile") == "incomplete")) {
        response.sendRedirect("userdataform.jsp");
    }*/
    
    User user = (User)session.getAttribute("user");

    out.println("<p> session time atr:" + session.getCreationTime() + "</p>");
    out.println("<p>session all atr:" + session.getAttributeNames() + "</p>");
    out.println("<p>session email atr:" + user.getName() + "</p>"); 

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/template_parts/head.jsp", out, false);
      out.write("\n");
      out.write("    <title>My Day</title>\n");
      out.write("</head>\n");
      out.write(" \n");
      out.write("<body>\n");
      out.write("    \n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/template_parts/menu.jsp", out, false);
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("       ");

             Integer dailyCaloriesAllowance = (Integer) request.getAttribute("dailyCaloriesAllowance");
             int caloriesTotal=0;
                        List<QuantifiedFood> listOfConsumedFood = (List) request.getAttribute("listOfConsumedFood");

                        for (QuantifiedFood f : listOfConsumedFood) {
                        caloriesTotal += f.getFood().getCalories()*(f.getQuantity());}
            
      out.write("\n");
      out.write("        <div  >\n");
      out.write("            <div>\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/template_parts/dash_nav.jsp", out, false);
      out.write("\n");
      out.write("                <h1>My Day</h1>\n");
      out.write("                <hr>\n");
      out.write("                <b>Hi, ");
      out.print(user.getName() );
      out.write("! </b><br><p>Your budget:");
      out.print(dailyCaloriesAllowance );
      out.write("kcal ,\n");
      out.write("                Consumed today: ");
      out.print(caloriesTotal );
      out.write(" ,\n");
      out.write("                Left: ");
      out.print(dailyCaloriesAllowance-caloriesTotal );
      out.write("</p>\n");
      out.write("            \n");
      out.write("                <script type=\"text/javascript\">\n");
      out.write("                    google.charts.load(\"current\", {packages: [\"corechart\"]});\n");
      out.write("                    google.charts.setOnLoadCallback(drawChart);\n");
      out.write("                    function drawChart() {\n");
      out.write("                        var data = google.visualization.arrayToDataTable([\n");
      out.write("                            ['Calories', 'Hours per Day'],\n");
      out.write("                            ['Used calories', ");
      out.print(caloriesTotal );
      out.write("],\n");
      out.write("                            ['Available calories', ");
      out.print(dailyCaloriesAllowance-caloriesTotal );
      out.write("]\n");
      out.write("                        ]);\n");
      out.write("                        var options = {\n");
      out.write("                            colors: ['#f6c7b6', '#f6c0b0'],\n");
      out.write("                            'pieSliceText': 'value',\n");
      out.write("                            pieHole: 0.5,\n");
      out.write("                        };\n");
      out.write("                        var chart = new google.visualization.PieChart(document.getElementById('donutchart'));\n");
      out.write("                        chart.draw(data, options);\n");
      out.write("                    }\n");
      out.write("                </script>\n");
      out.write("                <div id=\"donutchart\" style=\"width: 800px; height: 400px;\"></div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        <a href=\"ListAllFoodServlet.do\" type=\"button\" class=\"btn btn-primary btn-large\">Add Food</a>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
