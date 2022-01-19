package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <title>Sign in</title>\n");
      out.write("  <link rel=\"stylesheet\" href=\"css/login.css\">\n");
      out.write("  <script>\n");
      out.write("            function validate(){\n");
      out.write("                var username = document.adminlogin.admin_username.value;\n");
      out.write("                var pass = document.adminlogin.admin_password.value;\n");
      out.write("                \n");
      out.write("                if(username==null || username==\"\"){\n");
      out.write("                    alert(\"Please enter your username!\");\n");
      out.write("                    return false;\n");
      out.write("                }else if(pass==null || pass==\"\"){\n");
      out.write("                    alert(\"Please enter your password!\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("  </script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<form method=\"POST\" action=\"/Concert/adminlogin\" name=\"adminlogin\" id=\"adminlogin\" onsubmit=\"return validate()\">\n");
      out.write("<div class=\"login-box\">\n");
      out.write("  <center>Admin</center>\n");
      out.write("  <center>\n");
      out.write("    <div class=\"textbox\">\n");
      out.write("      <input type=\"text\" placeholder=\"Username\" name=\"admin_username\" id=\"admin_username\">\n");
      out.write("    </div>\n");
      out.write("     <div class=\"textbox\">\n");
      out.write("      <input type=\"password\" placeholder=\"Password\" name=\"admin_password\" id=\"admin_password\">\n");
      out.write("    </div>\n");
      out.write("      <input class=\"btn\" type=\"submit\" name=\"submit\" value=\"Sign in\">\n");
      out.write("      <br><a href=\"adminregistration.html\" target=\"_blank\"><font face = \"Arial\" size = \"2\" color = \"white\">Sign up if you don't have any account</a></font><br>\n");
      out.write("  </center>\n");
      out.write("</div>\n");
      out.write("</form>\n");
      out.write("</body>\n");
      out.write("</html>");
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
