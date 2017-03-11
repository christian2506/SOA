
<%@page import="Model.Activities"%>
<%
    Activities ac = new Activities();
    String codCli = request.getParameter("codCli");
    String codServicio = request.getParameter("service");
    String codTipoCom = request.getParameter("tipoContact");
    String nivelInt = request.getParameter("interes");
    ac.insertNewActivity(codCli, codServicio, codTipoCom, nivelInt);
    response.sendRedirect("actividadCliente.jsp?codCli="+codCli);
%>
