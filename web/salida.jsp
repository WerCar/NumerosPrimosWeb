<%@page import="com.emergentes.modelo.Registro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    
    Registro item = (Registro)request.getAttribute("miRegistro");
    boolean numerico=false;
    
    if(item.getNumero().matches("[0-9]+")){
        numerico=true;
    
    if(Integer.parseInt(item.getNumero())==0 || Integer.parseInt(item.getNumero())<0){%>
        
        <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado de programa</title>
    </head>
    <body>
        <h1>Programa finalizado</h1>
        <ul>
            <li>Numero ingresado: <%= item.getNumero() %> </li>
            <li>El valor ingresado no es valido para poder procesar, por favor vuelva al formulario e ingrese un numero valido.</li>
           

        </ul>
        <br>
        <a href="index.jsp">Volver a inicio</a>
    </body>
</html>
        
    <%}
    else{%>
     <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado de programa</title>
    </head>
    <body>
        <h1>Programa finalizado</h1>
        <ul>
            <li>Numero ingresado: <%= item.getNumero() %> </li>
            <li>Suma total de numeros primos anteriores: <%= item.getResultado()%> </li>
           

        </ul>
        <br>
        <a href="index.jsp">Volver a inicio</a>
    </body>
</html>   
        
  <%  }
}else{%>
  <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado de programa</title>
    </head>
    <body>
        <h1>Programa finalizado</h1>
        <ul>
            <li>Numero ingresado: <%= item.getNumero() %> </li>
            <li>El valor ingresado no es valido para poder procesar, por favor vuelva al formulario e ingrese un numero valido.</li>
           

        </ul>
        <br>
        <a href="index.jsp">Volver a inicio</a>
    </body>
</html>


<%}

    %>


