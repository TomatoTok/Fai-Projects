/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final;

/**
 *
 * @author Walter
 */
public class Simulacro2016Ej1 {
    public static void main (String []arg){
        String num = "15540927", nuevo ="";
        int i=0;
        while(i<num.length()){
        nuevo = nuevo + num.charAt(i);
        i=i+1;
            if (i==2) {
                nuevo=nuevo+"4";
                i=i+3;
            }
        }
        nuevo=nuevo+invertir(num);
        System.out.println("Numero Antiguo "+ num);
        System.out.println("Numero Nuevo: "+nuevo);
    }
    
public static String invertir(String num){
String aux="";
    for (int i = 4; i >= 2; i--) {
        aux=aux+num.charAt(i);
    }
return aux;
}
}
