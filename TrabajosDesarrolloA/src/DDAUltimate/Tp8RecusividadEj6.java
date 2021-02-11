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
public class Tp8RecusividadEj6 {
    public static void main (String []arg){
        char op,sec=' ',x;
        int cant=0;
        System.out.println("Elija una opcion");
        System.out.println("a) Inverso");
        System.out.println("b) Buscar un caracter dado");
        op = TecladoIn.readLineNonwhiteChar();
        switch(op){
            case 'a': System.out.println("Ingrese un valor a omitir"); 
                    x=TecladoIn.readLineNonwhiteChar();
                    inverso(sec,x);break;
            case 'b': System.out.println("Ingrese el valor a buscar");
                        x=TecladoIn.readLineNonwhiteChar();
                System.out.println(buscar(cant,x));break;
        }
    }
    
    public static void inverso(char sec,char x){
        System.out.println("Ingrese un caracter (. para salir)");
        sec= TecladoIn.readLineNonwhiteChar();
        if (sec=='.') {
        }
        else{
            if (sec!=x) {
                
                inverso(sec,x);
                System.out.print(sec);
               }
            else{inverso(sec,x);}
            }
        }
    
    public static int buscar(int cant,char x){
        char aux=' ';
        System.out.println("Ingrese un caracter ( . para salir)");
        aux= TecladoIn.readLineNonwhiteChar();
        if (aux == '.') {
            cant=0;
        }
        else{if (aux == x) {
                cant =buscar(cant,x)+1;
            }
        else{cant =buscar(cant,x);
            }
        }
    return cant; }
}
