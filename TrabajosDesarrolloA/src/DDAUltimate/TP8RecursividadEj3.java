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
public class TP8RecursividadEj3 {
    public static void main (String[]arg){
    int n=32154,cont;
    cont = dig(n);
        System.out.println("La cantidad de digitos es:"+cont);
    }
    
    public static int dig(int n){
        int cont;
        if (n<10) {
            return 1;
        }
        else{cont = dig((n/10))+1;
        return cont;
        }
        
    }
}
