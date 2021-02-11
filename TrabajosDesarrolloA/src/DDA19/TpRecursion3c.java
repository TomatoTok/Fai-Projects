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
public class TpRecursion3c {
    public static void main (String []arg){
    
        String arr [] = new String [4];
        int pos=0;
        arr[0]="hola";
        arr[1]="pc";
        arr[2]="nota";
        arr[3]="sonic";
        Palabra(arr,pos);
    
    }
    public static void Palabra(String arr[],int pos){
    char carac;
    String palabra;
        if (pos<arr.length) {
            palabra = arr[pos];
            carac = arr[pos].charAt(0);
            System.out.println("La primera letra de la palabra es:"+carac+" su longitud es:"+palabra.length());
            Palabra(arr,pos+1);
        }
    }
}
