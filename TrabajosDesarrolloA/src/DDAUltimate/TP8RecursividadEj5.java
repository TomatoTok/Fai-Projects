/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DDAUltimate;

import utiles.TecladoIn;

/**
 *
 * @author Walter
 */
public class TP8RecursividadEj5 {
    public static void main (String []arg){
    int arr [] =new int [30];
    int num=0;
    char op;
        System.out.println("Elija la opcion");
        System.out.println("a) Multiplo");
        System.out.println("b) Maximo");
        op=TecladoIn.readLineNonwhiteChar();
    switch(op){
        case 'a' :System.out.println("La cantidad de numeros multiplo de 4 son:"+multiplo(num));break;
        case 'b' :System.out.println("El maximo numero es:"+ maximo (num));break;}
    
    }
    public static int multiplo(int num){
    int cont;
        System.out.println("Ingrese una secuencia de numeros terminada en 0");
        num=TecladoIn.readInt();
        if (num==0) {
            
        }
        if ((num%4)==0) {
            cont=multiplo(num)+1;
        }
        else{
            cont=multiplo(num);
        
        }
        return cont;
    }
    
    public static int maximo(int num){
        int max=0;
        System.out.println("Ingrese una secuencia de numeros terminada en 0");
        num =TecladoIn.readLineInt();
        if (num == 0) {
            
        }
        else{
            max=maximo(num);
        if (num<max) {
           }
        else{
            if (num>max) {
                max=num;                
            }}}
        return max;
    }
}
