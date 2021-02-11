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
public class TP2ArreglosEj3 {
    public static void main(String []arg){
    char arr[]=new char[5],car;
    int cont=0;    
    for (int i = 0; i < arr.length; i++) {
            System.out.println("Ingrese un caracter");
            arr[i]=TecladoIn.readLineNonwhiteChar();
            if (arr[i]=='1' ||arr[i]=='2' ||arr[i]=='3' ||arr[i]=='4' ||arr[i]=='5' ||arr[i]=='6' ||arr[i]=='7' ||arr[i]=='8' ||arr[i]=='9' ||arr[i]=='0') {
                System.out.println("Error, ingrese una letra");
                i=i-1;
            }
        }
        System.out.println("Posiciones par");
        for (int i = 0; i < arr.length; i=i+2) {
            System.out.print(arr[i]+" ");
            }
        System.out.println();
        System.out.println("Orden inverso");
        for (int i = arr.length-1; i > -1; i--) {
            System.out.println(arr[i]);
        }
        System.out.println("Elija un caracter");
        car=TecladoIn.readChar();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==car) {
                cont=cont+1;
            }
        }
        System.out.println("La cantidad de veces que se repite es de:"+cont);
    }
    
}
