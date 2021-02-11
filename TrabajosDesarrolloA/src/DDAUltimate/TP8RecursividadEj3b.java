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
public class TP8RecursividadEj3b {
    public static void main (String[]arg){
    int n,t;
        System.out.println("ingrese el entero");
        n=TecladoIn.readInt();
        System.out.println("Ingrese el numero a buscar");
        t=TecladoIn.readLineInt();
        System.out.println("La cantidad de veces que aparece el digito es:"+cont(n,t));
    }
    public static int cont(int n,int t){
        int aux=0;
        if (n<10) {
            if (n==t) {
                return 1;
            }
            else{return 0;}
        }
        else{ if ((n%10)==t) {
                aux=cont(n/10,t)+1;
                return aux;
               }
        else{aux=cont(n/10,t);
            return aux;}
}
    }
}
