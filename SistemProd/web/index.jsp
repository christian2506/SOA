
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingresar</title>
        <link rel="stylesheet" href="css/semantic.min.css">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body class="login">
        <div class="ui middle aligned aligned grid center-login">
            <div class="column">
                <h2 class="ui teal image header">
                  <div class="content">
                    Ingreso al Sistema
                  </div>
                </h2>
                <form class="ui large form" action="clientes.jsp" method="post">
                    <div class="ui stacked segment">
                        <div class="field">
                            <div class="ui left icon input">
                                <i class="user icon"></i>
                                <input type="text" name="user" placeholder="User">
                            </div>
                        </div>
                        <div class="field">
                            <div class="ui left icon input">
                                <i class="lock icon"></i>
                                <input type="password" name="pass" placeholder="Password">
                            </div>
                        </div>
                        <button type="submit" class="ui fluid large teal submit button">Login</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
