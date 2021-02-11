/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DDA19;

import java.util.Random;
import utiles.TecladoIn;

/**
 *
 * @author Walter
 */
public class Pruebas {
    public static void main (String [] arg){
  int pos=0;
  int arr [] ={5,0,3,0,4,0};
        
        System.out.println("La cantidad de ceros es:"+verificaNum(arr,pos)) ;
       
        
    }
     public static int numRandom(){
    int aux,aux2;
    Random Pepito = new Random();
    aux = Pepito.nextInt(12) ;
    return aux;
    }
     public static int verificaNum(int arr [], int pos){
     int total;
         if (pos == arr.length-1 && arr[pos]==0) {
             total=1;
         }
         else{if (pos < arr.length && arr[pos]==0) {
                 total = 1+verificaNum(arr,pos+1);
             }
         else{ total = verificaNum(arr,pos+1);}
         }
         return total;
     }
    
}
