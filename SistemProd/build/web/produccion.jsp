
<%@page import="Model.DetailClient"%>
<%@page import="Model.Activities"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produccion</title>
        <link rel="stylesheet" href="css/semantic.min.css">
        <link rel="stylesheet" href="css/style.css">
        <%
            Activities ac = new Activities();    
            String codEmp = ac.validarDatos(session.getAttribute("Usuario").toString(), session.getAttribute("Password").toString());
            String nomEmp = ac.nomEmplForCod(codEmp);
            if(codEmp != ""){ 
        %>
    </head>
    <body>
        <header>
            <div class="logo">
                <figure>
                    <img src="img/logo.png" alt="logo">
                </figure>
            </div>
            <div id="user-log">
                <h1>Bienvenido: <span><%= nomEmp %></span></h1>
            </div>
            <div id="formulary">
               <form method="get" action="resultado.jsp">
                <div class="ui category search">
                    <div class="ui icon input">
                        <input class="prompt" type="search" name="busqueda" placeholder="Search ...">
                        <i class="search icon"></i>
                    </div>
                </div>
                </form> 
            </div>
            <ul class="menu-nav">
                <li><a href="clientes.jsp">Clientes</a></li>
                <li><a href="#">Actividades</a></li>
                <li>
                    <select name="list-client" id="list-client" class="dropdown" onchange="window.location.href=this.value">
                        <option>--Elegir--</option>
                        <%

                            for(DetailClient temp: ac.listDetailClient(codEmp)){
                        %>
                        <option value="actividadCliente.jsp?codCli=<%= temp.getCod_Cliente() %>"><%= temp.getNom_Cliente() %></option>
                        <%}%>
                    </select>
                </li>
                <li><a href="#">Producción</a></li>
            </ul>
        </header>
        <main>
            <section>
                <h2><i class="bar chart icon"></i>PRODUCCIÓN</h2>
                <div class="ui divider"></div>
                <div class="ui stacked segment">
                    <form action="produccion.jsp" method="post" class="ui form" >
                        <div class="field">
                            <label>Elegir</label>
                            <select class="ui fluid dropdown" name="elegir">
                                <option value="Empleado">Empleado</option>
                                <option value="Todos">Todos</option>
                            </select>
                        </div>
                        <div class="field">
                            <label>Año:</label>
                            <select class="ui fluid dropdown" name="anio" id="anio">
                                <%
                                    Activities ac2 = new Activities();
                                    String vec[] = ac2.listAnios(codEmp);
                                    for(int m = 0; m < vec.length; m++){
                                %>
                                <option><%= vec[m] %></option>
                                <%}%>
                            </select>
                        </div>
                        <div class="field">
                              
                        </div>
                        <button class="ui button" type="submit">Grafico</button>
                    </form>
                </div>
            </section>
            <div class="ui stacked segment">
                <div class="estadistica">
                    <div id="estadistica"></div>
                </div>                
            </div>             
            
        </main>
        <script src="js/jquery-3.1.1.min.js"></script>
        <script src="js/semantic.min.js"></script>
        <script src="https://code.highcharts.com/highcharts.js"></script>
        <script src="https://code.highcharts.com/modules/exporting.js"></script>
        <script src="js/main.js"></script>
        <script>
        <% if(request.getParameter("anio") != null){ %>
        $(function () {
        
            $('#estadistica').highcharts({
              chart: {
                  type: 'column'
              },
              title: {
                  text: 'Registro de Clientes'
              },
              xAxis: {
                  type: 'category',
                  labels: {
                      rotation: -45,
                      style: {
                          fontSize: '13px',
                          fontFamily: 'Verdana, sans-serif'
                      }
                  }
              },
              yAxis: {
                  min: 0,
                  title: {
                      text: 'Número Clientes'
                  }
              },
              legend: {
                  enabled: false
              },
              tooltip: {
                  pointFormat: '<b>{point.y:.1f} clientes</b>'
              },
              series: [{
                  name: 'Population',
                  data: [
                  <%
                      Activities ac3 = new Activities();
                      
                      if(request.getParameter("elegir").equals("Empleado")){
                          String arr[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
                      
                          int j = 1;
                          int count = 0;
                          for(int k = 0; k < arr.length; k++){
                            count = ac3.listGraphicsEmploye(codEmp, request.getParameter("anio")  , j);
                            out.println("['"+arr[k]+"',"+count+"],");
                            j++;
                          } 
                      }else{
                          String ar2[][] = ac3.listGraphicsAll(request.getParameter("anio"));
                      
                          for(int k = 0; k < ar2.length; k++){
                          
                            out.println("['"+ar2[k][0]+"',"+ar2[k][1]+"],");
                          
                          }
                      }
                    }
                  %>
                  
                  ],
                  dataLabels: {
                      enabled: true,
                      rotation: -90,
                      color: '#FFFFFF',
                      align: 'right',
                      y: 10, // 10 pixels down from the top
                      style: {
                          fontSize: '13px',
                          fontFamily: 'Verdana, sans-serif'
                      }
                  }
              }]
            
            });
        
        });
        
        </script>
    </body>
    <%
        }else{
            if (session != null) {
                session.invalidate();
            }
            response.sendRedirect("index.jsp");
        }
    %>
</html>
