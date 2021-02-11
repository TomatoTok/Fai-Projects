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
public class PracticaParaParcial {
    public static void main (String []arg){
    int num;
    boolean corte=false;
        System.out.println("Ingrese un numero");
        num = TecladoIn.readInt();
        
        if (pegado(num,corte)) {
            System.out.println("existen numeros pegados");
        }
        else{
            System.out.println("No hay numeros pegados");}
    }
    public static boolean pegado(int num,boolean corte){
    
    int aux = ((num%100) -(num%10))/10;
        if (!corte && num>10) {
            if (aux == num%10) {
                corte = true;
                return corte;
            }
            else{
                corte=pegado(num/10,corte);
            }
        }
        return corte;
    }
}
