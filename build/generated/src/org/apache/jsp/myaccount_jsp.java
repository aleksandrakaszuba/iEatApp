package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class myaccount_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("import iEatPackage.model.User;\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/template_parts/head.jsp", out, false);
      out.write("\n");
      out.write("    <title>User information</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("   \n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/template_parts/menu.jsp", out, false);
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("    <h1>Please enter your information:</h1>\n");
      out.write("  \n");
      out.write("    <div class=\"col-xs-12 col-md-6 col-md-offset-3\">\n");
      out.write("           ");

            //  dailyCaloriesAllowance =  request.getAttribute("dailyCaloriesAllowance");
             //Object currentuser = (User) request.getAttribute("currentuser");
          
           //   out.println("<p> complete user data: " + currentuser.getEmail()  + "</p>");
          
      out.write("\n");
      out.write("\n");
      out.write("        <form action=\"UserAdvancedDataServlet.do\" id=\"userdataform\">\n");
      out.write("  \n");
      out.write("            <label for=\"userweight\" class=\"sr-only\">Your Name</label>\n");
      out.write("            <input type=\"text\" name=\"username\" class=\"form-control\" value=\" ");
      out.print(user.getName() );
      out.write("\" autofocus=\"\">\n");
      out.write("            <label for=\"currentweight\" class=\"sr-only\">Your weight</label>\n");
      out.write("            <input type=\"text\" name=\"userweight\" id=\"userweight\" class=\"form-control\" placeholder=\"Your weight (kg)\" autofocus=\"\">\n");
      out.write("            <label for=\"userheight\" class=\"sr-only\">Height</label>\n");
      out.write("            <input type=\"text\" name=\"userheight\" id=\"userheight\" class=\"form-control\" placeholder=\"Your height (cm) \"  >\n");
      out.write("            <label for=\"userage\" class=\"sr-only\">Age</label>\n");
      out.write("            <input type=\"text\" name=\"userage\" id=\"userheight\" class=\"form-control\" placeholder=\"Your age (years) \"  >\n");
      out.write("            <br>\n");
      out.write("            <label for=\"usergender\" >Gender</label><br>\n");
      out.write("            <input type=\"radio\" name=\"usergender\" value=\"male\" checked> Male\n");
      out.write("            <input type=\"radio\" name=\"usergender\" value=\"female\"> Female<br>\n");
      out.write("            <br>\n");
      out.write("            <label for=\"weightlostspeed\">Preferred weight lost speed</label><br>\n");
      out.write("            <input type=\"radio\" name=\"weightlostspeed\" value=\"1\" checked> Maintain current weight<br>\n");
      out.write("            <input type=\"radio\" name=\"weightlostspeed\" value=\"2\"  > 1/4 kg per week<br>\n");
      out.write("            <input type=\"radio\" name=\"weightlostspeed\" value=\"3\"  > 1/2 kg per week<br>\n");
      out.write("            <input type=\"radio\" name=\"weightlostspeed\" value=\"4\"  > 3/4 kg per week<br>\n");
      out.write("            <input type=\"radio\" name=\"weightlostspeed\" value=\"5\"  > 1 kg per week<br>\n");
      out.write("            <br><br>\n");
      out.write("            \n");
      out.write("            <input type=\"submit\" value=\"Save\"  class=\"btn btn-lg btn-primary\">\n");
      out.write(" \n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("    </div>\n");
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
