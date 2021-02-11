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
public class TP8RecursividadEj4 {
    public static void main (String []arg){
    int v [] ={12,7,0,-1,8,10};
    int n,i=v.length-1;
    boolean vf=false;
        System.out.println("Ingrese el numero a buscar");
        n=TecladoIn.readInt();
        System.out.println("El valor es:"+busc(v,n,vf,i));
    }
public static boolean busc(int v [], int n,boolean vf,int i){
    if (!vf && i<=0) {
        return false;
    }
    else{if (!vf && v[i]==n) {
            return true;
        }
        if (vf) {
            return true;
        }
           return busc(v,n,vf,i-1);
        }
        
}
}

