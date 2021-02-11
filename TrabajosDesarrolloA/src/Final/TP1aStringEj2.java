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
public class TP1aStringEj2 {
    public static void main (String []arg){
    int num;
    
        System.out.println("Ingrese un numero del 1 al 7");
        num = TecladoIn.readInt();
        switch (num){
            case 1 : System.out.println("Lunes");break;
            case 2 : System.out.println("Martes");break;
            case 3 : System.out.println("Miercoles");break;
            case 4 : System.out.println("Jueves");break;
            case 5 : System.out.println("Viernes");break;
            case 6 : System.out.println("Sabado");break;
            case 7 : System.out.println("Domingo"); break;
            default : System.out.println("Error");break;
        }
    }
}
