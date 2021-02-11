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
public class TP1StringEj4 {
    public static void main(String []arg){
    String oracion;
    char vocal;
    
        System.out.println("Ingrese la frase");
        oracion = TecladoIn.readLine();
        oracion = oracion+" ";
        System.out.println("Ingrese la vocal");
        vocal = TecladoIn.readChar();
        System.out.println("La palabra con mas vocales \""+vocal+"\" elegida fue:"+buscPal(oracion,vocal));
    }
    public static String buscPal(String oracion,char vocal){
        String palabra="",guardarPal="";
        int ini=0,fin,cont=0,aux;
        for (int i = 0; i < oracion.length(); i++) {
            if (oracion.charAt(i) == ' ') {
                palabra= oracion.substring(ini, fin=i);
                aux = cuentavocales(palabra,vocal);
                if ( aux > cont) {
                    cont=aux;
                    guardarPal=palabra;
                }
                ini=i+1;
            }
        
    }
        return guardarPal;
    }

    public static int cuentavocales(String palabra,char vocal){
     int i=0,cont=0;
     char aux;
     
        while (i<palabra.length()) {
            aux=palabra.charAt(i);
        if (aux == vocal) {
            cont++;
        }
        i++;
        }
        return cont;
    }
    
}
