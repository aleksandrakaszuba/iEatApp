package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import iEatPackage.model.QuantifiedFood;
import java.util.List;
import iEatPackage.model.Food;
import java.sql.*;

public final class daylog_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/template_parts/head.jsp", out, false);
      out.write("\n");
      out.write("    <title>My Day</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/template_parts/sessioncheck.jsp", out, false);
      out.write("\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/template_parts/menu.jsp", out, false);
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div  >\n");
      out.write("             ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/template_parts/dash_nav.jsp", out, false);
      out.write("\n");
      out.write("            <div>\n");
      out.write("                <h1>{{message}}</h1>\n");
      out.write("                <hr>\n");
      out.write("\n");
      out.write("                List of today consumed food\n");
      out.write("                <br>\n");
      out.write("                <a href=\"#food\" type=\"button\" class=\"btn btn-primary btn-large\">Add Food</a>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <table class=\"table table-responsive \">\n");
      out.write("                <thead>\n");
      out.write("\n");
      out.write("                <th class=\"text-left\">Name</th>\n");
      out.write("                <th class=\"text-right\">Kcal</th>\n");
      out.write("                <th class=\"text-right\"> </th>\n");
      out.write("                </thead> \n");
      out.write("\n");
      out.write("                <tbody>\n");
      out.write("                    ");


                        List<QuantifiedFood> listOfConsumedFood = (List) request.getAttribute("listOfConsumedFood");

                        for (QuantifiedFood f : listOfConsumedFood) {
                    
      out.write("\n");
      out.write("                    <tr> <td class=\"text-left\">");
      out.print(f.getName());
      out.write(' ');
      out.print(f.getServingSize());
      out.write("</td>\n");
      out.write("                        <td class=\"text-right\"> \n");
      out.write("                            <i class=\"fa fa-plus\" aria-hidden=\"true\"></i></a></td></tr>\n");
      out.write("                            ");

                                }


                            
      out.write("\n");
      out.write("                    <tr >\n");
      out.write("                        <td class=\"text-left\" >Item</td>\n");
      out.write("                        <td class=\"text-right\" >300</td>\n");
      out.write("                        <td class=\"text-right\" ><a href=\"#modify_ingredient_selection\"><i class=\"fa fa-pencil-square-o\" aria-hidden=\"true\"></i></a></td>\n");
      out.write("\n");
      out.write("                    </tr>\n");
      out.write("                </tbody>\n");
      out.write("\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("\n");
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
