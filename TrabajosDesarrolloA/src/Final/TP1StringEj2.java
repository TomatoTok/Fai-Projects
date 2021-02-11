/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final;

import utiles.TecladoIn;

/**
 *
 * @author Walter
 */
public class TP1StringEj2 {
    public static void main (String []arg){
    String palabra,oracion,aux;
    int cont=0,ini=0,fin;
  
        System.out.println("Ingrese la oracion");
        oracion = TecladoIn.readLine();
        oracion = oracion + ' ';
        System.out.println("Ingrese la palabra");
        palabra = TecladoIn.readLineWord();
        
        for (int i = 0; i < oracion.length(); i++) {
            if (oracion.charAt(i) == ' ') {
                aux= oracion.substring(ini, fin=i);
                if (aux.equalsIgnoreCase(palabra)) {
                    cont++;                    
                }
                ini=i+1;
            }
        }
        System.out.println("la cantidad de veces que aparece su palabra es de: "+cont);
    
    }
    
}
