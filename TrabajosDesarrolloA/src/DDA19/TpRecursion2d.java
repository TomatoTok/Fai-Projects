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
public class TpRecursion2d {
    public static void main (String []arg){
     int num,cont=0;
        System.out.println("Ingrese el num");
        num = TecladoIn.readInt();
        System.out.println(contPar(num,cont));
        
    }
    public static int contPar(int num,int cont){
        
        
        if (num>0) {
            
             if (num%2 == 0) {
        cont =contPar(num/10,cont+1);
       }
             else{
             cont= contPar(num/10,cont);}        
        }
       
      
        return cont;
        
    
    } 
}
