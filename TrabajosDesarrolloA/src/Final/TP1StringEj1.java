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
public class TP1StringEj1 {
    public static void main (String []arg){
        String palabra;
       
        char vocal,aux;
        int i=0,cont=0;
        System.out.println("Ingrese una palabra");
        palabra = TecladoIn.readLine();
        System.out.println("Ingrese la vocal");
        vocal = TecladoIn.readChar();
        while (i<palabra.length()) {
            aux=palabra.charAt(i);
        if (aux == vocal) {
            cont++;
        }
        i++;
        }
        System.out.println("La cantidad de veces que aparece la vocal es de : "+cont);
    }
    
}
