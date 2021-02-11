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
public class TP2ArreglosEj4 {
    public static void main (String[]arg){
    int pos;
    boolean bandera=false;
    String arr[]=new String[3];
    arr[0]="que";
    arr[1]="lindo";
    arr[2]="dia";
    while(!bandera){
        System.out.println("Ingrese una posicion");
        pos= TecladoIn.readLineInt();
        if (-1>pos || pos>arr.length) {
            System.out.println("Posicion invalida");
        }else{System.out.println(arr[pos]);
        bandera=true;
        }
    }
}
}