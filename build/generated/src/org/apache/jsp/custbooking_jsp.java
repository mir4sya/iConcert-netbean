package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class custbooking_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("  <meta charset=\"utf-8\">\r\n");
      out.write("  <title>Booking ticket</title>\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"css/bookinguser.css\">\r\n");
      out.write("  <nav>\r\n");
      out.write("    <ul>\r\n");
      out.write("      <li><a href = \"home.jsp\">&#9900 Home</a></li>\r\n");
      out.write("      <li><a href = \"section.html\">&#9900; Section</a></li>\r\n");
      out.write("      <li><a href = \"custbooking.jsp\">&#9900; Booking</a></li>\r\n");
      out.write("    </ul>\r\n");
      out.write("  </nav>\r\n");
      out.write("  <script>\r\n");
      out.write("        function validate(){\r\n");
      out.write("            var username = document.custConcert.cust_username.value;\r\n");
      out.write("            var phoneno = document.custConcert.cust_phoneno.value;\r\n");
      out.write("            var confirm = document.custConcert.confirm.value;\r\n");
      out.write("            var section = document.custConcert.cust_section.value;\r\n");
      out.write("            var quantity = document.custConcert.cust_quantity.value;\r\n");
      out.write("                \r\n");
      out.write("            if(username == null || username==\"\"){\r\n");
      out.write("                alert(\"Please enter your name!\");\r\n");
      out.write("                return false;\r\n");
      out.write("            }else if(phoneno==null || phoneno==\"\"){\r\n");
      out.write("                alert(\"Please enter your password!\");\r\n");
      out.write("                return false;\r\n");
      out.write("            }else if(confirm==null || confirm==\"\"){\r\n");
      out.write("                alert(\"Please enter confirmation phone no!\");\r\n");
      out.write("                return false;\r\n");
      out.write("            }else if(section==null || section==\"\"){\r\n");
      out.write("                alert(\"Please enter your section!\")\r\n");
      out.write("                return false;\r\n");
      out.write("            }else if(quantity==null || quantity==\"\"){\r\n");
      out.write("                alert(\"Please enter your quantity!\")\r\n");
      out.write("                return false;\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"booking-box\">\r\n");
      out.write("<form method=\"POST\" action=\"/Concert/bookinguser\" name=\"custConcert\" id=\"custConcert\" onsubmit=\"return validate()\">\r\n");
      out.write("  <center>Booking Concert Ticket</center>\r\n");
      out.write("  <center>\r\n");
      out.write("    <div class=\"textbox\">\r\n");
      out.write("      <input type=\"text\" placeholder=\"Username\" name=\"cust_username\" id=\"cust_username\" >\r\n");
      out.write("    </div>\r\n");
      out.write("     <div class=\"textbox\">\r\n");
      out.write("      <input type=\"text\" placeholder=\"Phone no\" name=\"cust_phoneno\" id=\"cust_phoneno\">\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"textbox\">\r\n");
      out.write("      <input type=\"text\" placeholder=\"Re-enter phone no\" name=\"confirm\" id=\"confirm\" >\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"textbox\">\r\n");
      out.write("      <input type=\"text\" placeholder=\"Section A/B/C\" name=\"cust_section\" id=\"cust_section\">\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"textbox\">\r\n");
      out.write("      <input type=\"text\" placeholder=\"Quantity\" name=\"cust_quantity\" id=\"cust_quantity\">\r\n");
      out.write("    </div>\r\n");
      out.write("    <input class=\"btn\" type=\"submit\" name=\"submit\" value=\"Confirm\">\r\n");
      out.write("  </center>\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
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
