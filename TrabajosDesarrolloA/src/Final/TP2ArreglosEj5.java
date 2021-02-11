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
public class TP2ArreglosEj5 {
    public static void main (String []arg){
    String arr[]=new String [3],pal;
    int pos=0;
    boolean bandera=false;
    arr[0]="que";
    arr[1]="lindo";
    arr[2]="dia";
        System.out.println("Ingrese una palabra");
        pal =TecladoIn.readLine();
        while(!bandera && pos<arr.length){
            if (arr[pos].equalsIgnoreCase(pal)) {
                System.out.println("La posicion donde se encuentra la palabra es:"+pos);
                bandera=true;
            }
            pos=pos+1;
        }
        if (!bandera) {
            System.out.println("La palabra que busca no se encuentra dentro del arreglo");
        }
    }
    
}
