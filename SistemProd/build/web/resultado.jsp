
<%@page import="Model.DetailClient"%>
<%@page import="Model.Activities"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Busqueda</title>
        <link rel="stylesheet" href="css/semantic.min.css">
        <link rel="stylesheet" href="css/style.css">
        <%
            String palabra = request.getParameter("busqueda");
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
                <li><a href="produccion.jsp">Producción</a></li>
            </ul>
        </header>
        <main>
            <section>
                <div>
                    <h2><i class="newspaper icon"></i>RESULTADO</h2>
                    <div class="ui divider"></div>
                    <div class="options">
                        <ul class="ui stacked segment">
                            <li><a href="#"><i id="exportPDF" class="file pdf outline icon"></i></a></li>
                            <li><a href="#"><i id="exportExcel" class="file excel outline icon"></i></a></li>
                        </ul>
                    </div>
                </div>
            </section>
            <div id="table-client">
                <table class="ui celled table" id="exportTable">
                    <thead>
                        <tr>
                            <th>N</th>
                            <th>Empresa</th>
                            <th>Negociación</th>
                            <th>Interés</th>
                            <th>Contacto</th>
                            <th>Rubro</th>
                            <th>Fecha</th>
                            <th>Detalle</th>
                        </tr>
                    </thead>

                        <%
                          Activities ac2 = new Activities();
                          int i = 1;
                          for(DetailClient temp: ac2.resultBusqueda(palabra)){
                        %>

                        <tr>
                            <td><%= i %></td>
                            <td><%= temp.getNom_Cliente() %></td>
                            <td><%= temp.getNegociacion() %></td>
                            <td><%= temp.getInteres() %></td>
                            <td><%= temp.getContacto() %></td>
                            <td><%= temp.getRubro() %></td>
                            <td><%= temp.getFecha_Reg() %></td>
                            <td><a href="actividadCliente.jsp?codCli=<%= temp.getCod_Cliente() %>">Ver</a></td>
                        </tr>

                        <% i++; }%>

                    <tfoot>
                        <tr>
                            <th colspan="8">
                                <div class="ui right floated pagination menu">
                                    <a class="icon item">
                                        <i class="left chevron icon"></i>
                                    </a>
                                    <a class="item">1</a>
                                    <a class="item">2</a>
                                    <a class="item">3</a>
                                    <a class="item">4</a>
                                    <a class="icon item">
                                        <i class="right chevron icon"></i>
                                    </a>
                                </div>
                            </th>
                        </tr>
                    </tfoot>
                </table>
            </div>
        </main>
        <script src="js/jquery-3.1.1.min.js"></script>
        <script src="js/semantic.min.js"></script>
        <script type="text/javascript" src="http://www.shieldui.com/shared/components/latest/js/shieldui-all.min.js"></script>
        <script type="text/javascript" src="http://www.shieldui.com/shared/components/latest/js/jszip.min.js"></script>
        <script src="js/main.js"></script>
        <script type="text/javascript">
        jQuery(function ($) {
            $("#exportPDF").click(function () {
                // parse the HTML table element having an id=exportTable
                var dataSource = shield.DataSource.create({
                    data: "#exportTable",
                    schema: {
                        type: "table",
                        fields: {
                            N: {type: Number},
                            Empresa: { type: String },
                            Negociación: { type: String },
                            Interés: { type: String },
                            Contacto: { type: String },
                            Rubro: { type: String },
                            Fecha: { type: String }
                        }
                    }
                });

                // when parsing is done, export the data to PDF
                dataSource.read().then(function (data) {
                    var pdf = new shield.exp.PDFDocument({
                        author: "PrepBootstrap",
                        created: new Date()
                    });

                    pdf.addPage("a4", "portrait");

                    pdf.table(
                        10,
                        50,
                        data,
                        [
                            { field: "N", title: "N", width: 40 },
                            { field: "Empresa", title: "Empresa", width: 100 },
                            { field: "Negociación", title: "Negociación", width: 100 },
                            { field: "Interés", title: "Interés", width: 80 },
                            { field: "Contacto", title: "Contacto", width: 80 }, 
                            { field: "Rubro", title: "Rubro", width: 80 }, 
                            { field: "Fecha", title: "Fecha", width: 80 }
                        ],
                        {
                            margins: {
                                top: 10,
                                left: 10
                            }
                        }
                    );

                    pdf.saveAs({
                        fileName: "PrepBootstrapPDF"
                    });
                });
            });
        });
        
        jQuery(function ($) {
            $("#exportExcel").click(function () {
                // parse the HTML table element having an id=exportTable
                var dataSource = shield.DataSource.create({
                    data: "#exportTable",
                    schema: {
                        type: "table",
                        fields: {
                            N: {type: Number},
                            Empresa: { type: String },
                            Negociación: { type: String },
                            Interés: { type: String },
                            Contacto: { type: String },
                            Rubro: { type: String },
                            Fecha: { type: String }
                        }
                    }
                });

                // when parsing is done, export the data to Excel
                dataSource.read().then(function (data) {
                    new shield.exp.OOXMLWorkbook({
                        author: "PrepBootstrap",
                        worksheets: [
                            {
                                name: "PrepBootstrap Table",
                                rows: [
                                    {
                                        cells: [
                                            {
                                                style: {
                                                    bold: true
                                                },
                                                type: Number,
                                                value: "N"
                                            },
                                            {
                                                style: {
                                                    bold: true
                                                },
                                                type: String,
                                                value: "Empresa"
                                            },
                                            {
                                                style: {
                                                    bold: true
                                                },
                                                type: String,
                                                value: "Negociación"
                                            },
                                            {
                                                style: {
                                                    bold: true
                                                },
                                                type: String,
                                                value: "Interés"
                                            },
                                            {
                                                style: {
                                                    bold: true
                                                },
                                                type: String,
                                                value: "Contacto"
                                            },
                                            {
                                                style: {
                                                    bold: true
                                                },
                                                type: String,
                                                value: "Rubro"
                                            },
                                            {
                                                style: {
                                                    bold: true
                                                },
                                                type: String,
                                                value: "Fecha"
                                            }
                                        ]
                                    }
                                ].concat($.map(data, function(item) {
                                    return {
                                        cells: [
                                            { type: Number, value: item.N },
                                            { type: String, value: item.Empresa },
                                            { type: String, value: item.Negociación },
                                            { type: String, value: item.Interés },
                                            { type: String, value: item.Contacto },
                                            { type: String, value: item.Rubro },
                                            { type: String, value: item.Fecha },
                                        ]
                                    };
                                }))
                            }
                        ]
                    }).saveAs({
                        fileName: "PrepBootstrapExcel"
                    });
                });
            });
        });
    </script>
    <%
        }else{
            if (session != null) {
                session.invalidate();
            }
            response.sendRedirect("index.jsp");
        }
    %>
    </body>
</html>
