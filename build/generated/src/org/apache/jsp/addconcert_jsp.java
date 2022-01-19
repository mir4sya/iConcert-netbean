package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addconcert_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <title>Add new concert</title>\n");
      out.write("  <link rel=\"stylesheet\" href=\"css/bookinguser.css\">\n");
      out.write("  <nav>\n");
      out.write("    <ul>\n");
      out.write("      <li><a href = \"homee.jsp\">&#9900; Home</a></li>\n");
      out.write("      <li><a href = \"addconcert.jsp\">&#9900; Add Concert</a></li>\n");
      out.write("       <li><a href = \"concertdetails.jsp\">&#9900; Concert Details</a></li>\n");
      out.write("      <li><a href = \"displayreport.jsp\">&#9900; Report</a></li>\n");
      out.write("    </ul>\n");
      out.write("  </nav>\n");
      out.write("  <script>\n");
      out.write("        function validate(){\n");
      out.write("            var username = document.iconcert.admin_username.value;\n");
      out.write("            var email = document.iconcert.admin_email.value;\n");
      out.write("            var confirm = document.iconcert.confirm.value;\n");
      out.write("            var concertname = document.iconcert.concert_name.value;\n");
      out.write("            var concertdate = document.iconcert.concert_date.value;\n");
      out.write("            var concerttime = document.iconcert.concert_time.value;\n");
      out.write("                \n");
      out.write("            if(username == null || username==\"\"){\n");
      out.write("                alert(\"Please enter your name!\");\n");
      out.write("                return false;\n");
      out.write("            }else if(email==null || email==\"\"){\n");
      out.write("                alert(\"Please enter your password!\");\n");
      out.write("                return false;\n");
      out.write("            }else if(confirm==null || confirm==\"\"){\n");
      out.write("                alert(\"Please enter confirmation email!\");\n");
      out.write("                return false;\n");
      out.write("            }else if(section==null || section==\"\"){\n");
      out.write("                alert(\"Please enter your section!\")\n");
      out.write("                return false;\n");
      out.write("            }else if(quantity==null || quantity==\"\"){\n");
      out.write("                alert(\"Please enter your quantity!\")\n");
      out.write("                return false;\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"booking-box\">\n");
      out.write("<form method=\"POST\" action=\"/Concert/addconcert\" name=\"iconcert\" id=\"iconcert\" onsubmit=\"return validate()\">\n");
      out.write("  <center>Book New Concert</center>\n");
      out.write("  <center>\n");
      out.write("    <div class=\"textbox\">\n");
      out.write("      <input type=\"text\" placeholder=\"Username\" name=\"admin_username\" id=\"admin_username\" >\n");
      out.write("    </div>\n");
      out.write("     <div class=\"textbox\">\n");
      out.write("      <input type=\"text\" placeholder=\"Email\" name=\"admin_email\" id=\"admin_email\">\n");
      out.write("    </div>\n");
      out.write("    <div class=\"textbox\">\n");
      out.write("      <input type=\"text\" placeholder=\"Re-enter email\" name=\"confirm\" id=\"confirm\" >\n");
      out.write("    </div>\n");
      out.write("    <div class=\"textbox\">\n");
      out.write("      <input type=\"text\" placeholder=\"Concert name\" name=\"concert_name\" id=\"concert_name\">\n");
      out.write("    </div>\n");
      out.write("    <div class=\"textbox\">\n");
      out.write("      <input type=\"text\" placeholder=\"Date: x/x/xxxx\" name=\"concert_date\" id=\"concert_date\">\n");
      out.write("    </div>\n");
      out.write("    <div class=\"textbox\">\n");
      out.write("      <input type=\"text\" placeholder=\"Time: 0000pm - 0000pm\" name=\"concert_time\" id=\"concert_time\">\n");
      out.write("    </div>\n");
      out.write("      <br><input class=\"btn\" type=\"submit\" name=\"submit\" value=\"Confirm\">\n");
      out.write("  </center>\n");
      out.write("</form>\n");
      out.write("</div>\n");
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
