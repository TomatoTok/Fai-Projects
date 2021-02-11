/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DDA19;

import utiles.TecladoIn;

/**
 *
 * @author Walter
 */
public class TestPuntosPorCliente {
    public static void main (String[]arg){
    int nroc;
        System.out.println("Ingrese el numero de cliente");
        nroc = TecladoIn.readInt();
    PuntosPorCliente cli1 = new PuntosPorCliente (nroc);
    menu(cli1);
   
    
    }
    
    public static void menu (PuntosPorCliente cli1){
    char opcion;
    opcion = ' ';
    while(opcion !='d'){
        System.out.println("Elija la opcion deseada:");
        System.out.println("a) Sumar puntos");
        System.out.println("b) Canjear puntos");
        System.out.println("c) Mostrar por pantalla");
        System.out.println("d)Salir del programa");
        opcion = TecladoIn.readLineNonwhiteChar();
        switch(opcion){
            case 'a': sumaPuntos(cli1);break;
            case 'b': canjearPuntos(cli1);break;
            case 'c': cli1.MuestraDatos();break;
            case 'd': opcion = 'd';break;
            default : System.out.println("ERROR");break;
        
        }
    }
        System.out.println("Gracias por utilizar este programa");
    }
   public static void sumaPuntos(PuntosPorCliente cli1){
   int p;
       System.out.println("Ingrese los puntos a sumar");
       p = TecladoIn.readInt();
       cli1.sumarPuntos(p);
      
   
   }
   public static void canjearPuntos(PuntosPorCliente cli1){
       int canj;
       System.out.println("Ingrese los puntos a canjear");
       canj = TecladoIn.readInt();
       if (cli1.canjearPuntos(canj)== true) {
           System.out.println("La operacion se completo con exito");
       }
       else{
           System.out.println("No es posible completa la operacion");
       
       }
     
   
   }
}
