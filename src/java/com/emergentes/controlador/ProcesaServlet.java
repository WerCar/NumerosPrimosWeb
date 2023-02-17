
package com.emergentes.controlador;

import com.emergentes.modelo.Registro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Random;
import javax.swing.JOptionPane;

@WebServlet(name = "ProcesaServlet", urlPatterns = {"/ProcesaServlet"})
public class ProcesaServlet extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String resultadoS;
        Registro regi = new Registro();
        //Probar si es una valor procesable
        try{
             int numero = Integer.parseInt(request.getParameter("numero"));
        int resultado = sumaPrimos(numero);
        resultadoS= Integer.toString(resultado);
        
        
       regi.setNumero(Integer.toString(numero));
       regi.setResultado(resultado);
        
      
        
        }catch(Exception ex){ //Si no es un valor valido
            String valor = request.getParameter("numero");
       regi.setNumero(valor);
       regi.setResultado(0);
       resultadoS="Valor ingresado no valido para procesar.";
        }
        
        //Guardado del archivo de texto
        Random claseRandom = new Random(); // Esto crea una instancia de la Clase Random
        String intento;
        File f;
        FileWriter w;
        BufferedWriter bw;
        PrintWriter wr;
        intento=Integer.toString(claseRandom.nextInt(100000000));
        
        /*
   try{
            f= new File ("Intento " + intento + ".txt" );
            w = new FileWriter(f);
            bw=new BufferedWriter(w);
            wr= new PrintWriter(bw);
            
            wr.write("Valor ingresado: " + request.getParameter("numero"));
            wr.append("-Werner Carcamo-");
            wr.close();
            bw.close();
            System.out.println("Intento registrado: " + intento);
        }catch(Exception ex){
            
        }
 */
        
     try{
          FileWriter fichero = new FileWriter("C:/Users/Werner Cárcamo/Desktop/UMG/7MO SEMESTRE/ANALISIS DE SISTEMAS/NumerosPrimosWeb/Intentos txt/Intento " + intento + ".txt");
     fichero.write("Valor ingresado: " + request.getParameter("numero"));
     fichero.append("\nResultado: " + resultadoS);
     fichero.close();
     }catch(Exception ex){
        
     }
        
        
        
        request.setAttribute("miRegistro", regi);
        request.getRequestDispatcher("salida.jsp").forward(request, response);
        
     
    }

 public static boolean esPrimo(int numero){
        for(int i=3; i*i <= numero;i+=2){
            if(numero % i ==0){
            return false;
        }
 }
        return true;
    }   
public static int sumaPrimos(int n){
    int suma=2;
   
    for(int i=3; i<n;++i){
        if (i % 2==1&&esPrimo(i)){
            suma+=i;
        }
    }
    
   return suma;
}
}
