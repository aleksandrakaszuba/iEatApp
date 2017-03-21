package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import iEatPackage.model.Food;

public final class createfood_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/template_parts/head.jsp", out, false);
      out.write("\n");
      out.write("    <title>Login</title>\n");
      out.write("</head>\n");
      out.write("<a href=\"LoginServlet.do\"></a>\n");
      out.write("<body>\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/template_parts/menu.jsp", out, false);
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/template_parts/dash_nav.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("        <nav class=\"navbar navbar-default\">\n");
      out.write("            <ul class=\"nav navbar-nav\">\n");
      out.write("                <li><a href=\"ListAllFoodServlet.do\" ><i class=\"fa fa-search\"></i> Search Food</a></li>\n");
      out.write("                <li><a href=\"MealsServlet.do\"  >  Meals</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write(" <a href=\"ListAllFoodServlet.do\" type=\"button\" class=\"btn btn-primary btn-large\">Add Food</a>\n");
      out.write("        <div class=\"col-xs-12 col-md-6 col-md-offset-3\">\n");
      out.write("\n");
      out.write("            <form action=\"SearchServlet.do\"\n");
      out.write("                  <div class=\"input-group col-md-12\">\n");
      out.write("                    <input name=\"searchterm\" type=\"text\" class=\"form-control input-lg\" placeholder=\"Search food\" />\n");
      out.write("                    <span class=\"input-group-btn\">\n");
      out.write("                        <button a href=\"SearchServlet.do\" class=\"btn btn-info btn-lg\" type=\"submit\">\n");
      out.write("                            <i class=\"fa fa-search\" aria-hidden=\"true\"></i>\n");
      out.write("                        </button>\n");
      out.write("                    </span>\n");
      out.write("                </div> \n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("            <table class=\"table table-responsive \">\n");
      out.write("                <thead>\n");
      out.write("                <th>Name</th>\n");
      out.write("                <th> </th>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("\n");
      out.write("                    ");


                        List<Food> listOfAllFood = (List) request.getAttribute("listOfAllFood");

                        for (Food f : listOfAllFood) {
                    
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"modal fade\" id=\"");
      out.print(f.getId());
      out.write("food\" tabindex=\"-1\" role=\"dialog\">\n");
      out.write("                    <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("                        <div class=\"modal-content\">\n");
      out.write("                            <form action=\"ConsumeServlet.do\"> \n");
      out.write("                                <div class=\"modal-header\">\n");
      out.write("                                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n");
      out.write("                                    <h4>");
      out.print(f.getName());
      out.write(" </h4>\n");
      out.write("                                    <input class=\"hidden\" name=\"foodName\" value=\"");
      out.print(f.getName());
      out.write("\">\n");
      out.write("                                        \n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"modal-body\">\n");
      out.write("\n");
      out.write("                                    <p >Calories: <span id=\"");
      out.print(f.getId());
      out.write("caloriesfield\">");
      out.print(f.getCalories());
      out.write("</span> kcal  </p>\n");
      out.write("\n");
      out.write("                                    <div>Serving selection</div>\n");
      out.write("                                    \n");
      out.write("                                    <p><input id=\"");
      out.print(f.getId());
      out.write("serving\" type=\"number\" name=\"serving\" min=\"0\" max=\"200\" step=\"1\" value=\"1\"> ");
      out.print(f.getServingSize());
      out.write("</p>\n");
      out.write("                                    <div>Fats: <span id=\"");
      out.print(f.getId());
      out.write("fatsfield\">");
      out.print(f.getFats());
      out.write("</span>g | \n");
      out.write("                                        Carbohydrates: <span id=\"");
      out.print(f.getId());
      out.write("carbsfield\">");
      out.print(f.getCarbs());
      out.write("</span>g | \n");
      out.write("                                        Proteins: <span id=\"");
      out.print(f.getId());
      out.write("proteinsfield\">");
      out.print(f.getProteins());
      out.write("</span>g \n");
      out.write("                                    </div>\n");
      out.write("                                    <script>\n");
      out.write("                                        \n");
      out.write("                                        $(\"#");
      out.print(f.getId());
      out.write("serving\").on(\"change paste keyup\", function() {\n");
      out.write("                                        $(\"#");
      out.print(f.getId());
      out.write("caloriesfield\").text($(this).val() * (");
      out.print(f.getCalories());
      out.write("));\n");
      out.write("                                         $(\"#");
      out.print(f.getId());
      out.write("proteinsfield\").text($(this).val() * (");
      out.print((int)f.getProteins());
      out.write("));\n");
      out.write("                                          $(\"#");
      out.print(f.getId());
      out.write("carbsfield\").text($(this).val() * (");
      out.print((int)f.getCarbs());
      out.write("));\n");
      out.write("                                           $(\"#");
      out.print(f.getId());
      out.write("fatsfield\").text($(this).val() * (");
      out.print((int)f.getFats());
      out.write("));\n");
      out.write("                                        });\n");
      out.write("                                         \n");
      out.write("                                      \n");
      out.write("                                    </script>\n");
      out.write("                                        \n");
      out.write("                                        \n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"modal-footer\">\n");
      out.write("                                    <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Cancel</button>\n");
      out.write("                                    <input type=\"submit\" class=\"btn btn-primary\" value=\"Add\">\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                            </form>\n");
      out.write("                        </div><!-- /.modal-content -->\n");
      out.write("                    </div><!-- /.modal-dialog -->\n");
      out.write("                </div><!-- /.modal -->\n");
      out.write("\n");
      out.write("\n");
      out.write("                <tr> <td class=\"text-left\">");
      out.print(f.getName());
      out.write(' ');
      out.write('(');
      out.print((f.getServingSize()));
      out.write(")</td>\n");
      out.write("                    <td class=\"text-right\"><a data-toggle=\"modal\" data-target=\"#");
      out.print(f.getId());
      out.write("food\">\n");
      out.write("                            <i class=\"fa fa-pencil\" aria-hidden=\"true\"></i></a></td></tr>\n");
      out.write("                            ");

                                }


                            
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("\n");
      out.write("            </table>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/template_parts/footer.jsp", out, false);
      out.write("\n");
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
