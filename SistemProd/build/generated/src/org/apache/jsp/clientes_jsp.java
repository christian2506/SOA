package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.DetailClient;
import Model.Activities;

public final class clientes_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"es\">\n");
      out.write("<head>\n");
      out.write("    ");

        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        
        Activities ac = new Activities();
        String cod
        String codEmp = ac.validarDatos(user, pass);
       
        session.setAttribute("CodigoEmpleado", request.getParameter(codEmp));
        if(codEmp != ""){
    
      out.write("\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Document</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/semantic.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <header>\n");
      out.write("\t<div class=\"logo\">\n");
      out.write("            <figure>\n");
      out.write("                <img src=\"img/logo.png\" alt=\"logo\">\n");
      out.write("            </figure>\n");
      out.write("\t</div>\n");
      out.write("\t<div id=\"user-log\">\n");
      out.write("            <h1>Bienvenido: <span>");
      out.print( codEmp );
      out.write("</span></h1>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"ui category search\">\n");
      out.write("            <div class=\"ui icon input\">\n");
      out.write("\t\t<input class=\"prompt\" type=\"text\" placeholder=\"Search ...\">\n");
      out.write("\t\t<i class=\"search icon\"></i>\n");
      out.write("            </div>\n");
      out.write("\t</div>\n");
      out.write("\t<ul class=\"menu-nav\">\n");
      out.write("            <li><a href=\"#\">Clientes</a></li>\n");
      out.write("            <li><a href=\"#\">Actividades</a></li>\n");
      out.write("            <li>\n");
      out.write("            <select name=\"list-client\" id=\"list-client\" class=\"dropdown\">\n");
      out.write("                <option value=\"\">holi</option>\n");
      out.write("\t\t<option value=\"\">holi</option>\n");
      out.write("\t\t<option value=\"\">holi</option>\n");
      out.write("            </select>\n");
      out.write("            </li>\n");
      out.write("            <li><a href=\"#\">Producción</a></li>\n");
      out.write("\t</ul>\n");
      out.write("    </header>\n");
      out.write("    <main>\n");
      out.write("\t<section>\n");
      out.write("            <div>\n");
      out.write("\t\t<p>CLIENTES</p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"options\">\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"#\"><i class=\"add user icon\"></i></a></li>\n");
      out.write("                    <li><a href=\"#\"><i class=\"edit icon\"></i></a></li>\n");
      out.write("                    <li><a href=\"#\"><i class=\"file pdf outline icon\"></i></a></li>\n");
      out.write("                    <li><a href=\"#\"><i class=\"file excel outline icon\"></i></a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("\t</section>\n");
      out.write("\t<div id=\"table-client\">\n");
      out.write("            <table class=\"ui celled table\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("\t\t\t<th>#</th>\n");
      out.write("\t\t\t<th>Empresa</th>\n");
      out.write("\t\t\t<th>Negociación</th>\n");
      out.write("\t\t\t<th>Interés</th>\n");
      out.write("\t\t\t<th>Contacto</th>\n");
      out.write("\t\t\t<th>Rubro</th>\n");
      out.write("\t\t\t<th>Fecha</th>\n");
      out.write("\t\t\t<th>Detalle</th>\n");
      out.write("                    </tr>\n");
      out.write("\t\t</thead>\n");
      out.write("\t\t\n");
      out.write("                    ");

                      int i = 1;
                      for(DetailClient temp: ac.listDetailClient(codEmp)){
                    
      out.write("\n");
      out.write("                    \n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print( i );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( temp.getNom_Cliente() );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( temp.getNegociacion() );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( temp.getInteres() );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( temp.getContacto() );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( temp.getRubro() );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( temp.getFecha_Reg() );
      out.write("</td>\n");
      out.write("                        <td><a href=\"actividadCliente.jsp?codCl=");
      out.print( temp.getCod_Cliente() );
      out.write("\">Ver</a></td>\n");
      out.write("                    </tr>\n");
      out.write("                    \n");
      out.write("                    ");
 i++; }
      out.write("\n");
      out.write("\t\t\n");
      out.write("\t\t<tfoot>\n");
      out.write("                    <tr>\n");
      out.write("\t\t\t<th colspan=\"8\">\n");
      out.write("                            <div class=\"ui right floated pagination menu\">\n");
      out.write("                                <a class=\"icon item\">\n");
      out.write("                                    <i class=\"left chevron icon\"></i>\n");
      out.write("                                </a>\n");
      out.write("                                <a class=\"item\">1</a>\n");
      out.write("                                <a class=\"item\">2</a>\n");
      out.write("                                <a class=\"item\">3</a>\n");
      out.write("                                <a class=\"item\">4</a>\n");
      out.write("                                <a class=\"icon item\">\n");
      out.write("                                    <i class=\"right chevron icon\"></i>\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("\t\t\t</th>\n");
      out.write("                    </tr>\n");
      out.write("\t\t</tfoot>\n");
      out.write("            </table>\n");
      out.write("\t</div>\n");
      out.write("    </main>\n");
      out.write("    ");

        }else{
            response.sendRedirect("index.jsp");
        }
    
      out.write("\n");
      out.write("    <script src=\"js/jquery-3.1.1.min.js\"></script>\n");
      out.write("    <script src=\"js/semantic.min.js\"></script>\n");
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
