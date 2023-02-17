

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Numeros Primos</title>
    </head>
    <body>
        <h1 align="center">Registros de datos para calculo</h1>
        <form action="ProcesaServlet" method="post">
            <h3> Ingrese el numero a calcular</h3>
            <label>Numero</label>
            <input type="text" name="numero">
            <input type="submit" name="procesar"> 
        </form>
    </body>
</html>
