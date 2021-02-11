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
public class TP1StringEj3 {
    public static void main (String []arg){
    
        String palabra,inv="";
        char aux;
        int cont;
        System.out.println("Ingrese la palabra");
        palabra = TecladoIn.readLine();
        for (int i = palabra.length(); i > 0; i--) {
            inv =inv+ palabra.charAt(i-1);
        }
        System.out.println("La palabra invertida es: "+inv);
    }
    
}
