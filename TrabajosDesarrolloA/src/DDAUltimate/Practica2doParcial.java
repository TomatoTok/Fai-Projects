/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DDAUltimate;

/**
 *
 * @author Walter
 */
public class Practica2doParcial {
    public static void main(String []arg){
        int dig=10442;
        boolean valor=false;
        System.out.println(digPeg(dig,valor));
    }
    public static boolean digPeg(int dig,boolean valor){
        if (dig>10) {
            valor=digPeg(dig/10,valor);
        }
        if (!valor) {
        if (dig%10 == (dig/10)%10) {
                valor=true;}
            
    }return valor;
        }
  
    
}
