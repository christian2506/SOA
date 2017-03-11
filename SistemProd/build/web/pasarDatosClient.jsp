
<%@page import="Model.Activities"%>
<%
    Activities ac = new Activities();
    String nombreCli = request.getParameter("name-client");
    String codRubro = request.getParameter("rubro");
    String telefono = request.getParameter("telefono");
    String correo = request.getParameter("email");
    String codServicio = request.getParameter("service");
    String codTipoCom = request.getParameter("tipoContact");
    String nivelInt = request.getParameter("interes");
    String codEmp = request.getParameter("codE");
    ac.insertNewClient(nombreCli, codRubro, telefono, correo, codEmp, codServicio, codTipoCom, nivelInt);
    response.sendRedirect("clientes.jsp");
%>

