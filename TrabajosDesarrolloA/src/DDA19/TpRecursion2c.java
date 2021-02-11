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
public class TpRecursion2c {
    public static void main (String []arg){
    int num;
        System.out.println("Ingrese el numero");
        num = TecladoIn.readInt();
        System.out.println(SumaDigitos(num));
    }
    public static int SumaDigitos(int num){
      int aux = num/10,suma;
        if (aux > 0) {
            suma = SumaDigitos(num/10 + num%10);
        }
        else{
           suma = num;
        }
        return suma;
    }
}
