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
public class TpRecursion3b {
    public static void main (String[]arg){
    
      char arr[]=new char[4];
      char let;
      int pos=0;
      arr[0]='a';
      arr[1]='c';
      arr[2]='d';
      arr[3]='b';
        System.out.println("ingrese el caracter");
        let = TecladoIn.readLineNonwhiteChar();
        if (idCaracter(arr,pos,let)) {
            System.out.println("Si se encuentra dentro del arreglo");
        }else{
            System.out.println("No se encuentra dentro del arreglo");}
      
    }
    public static boolean idCaracter(char arr[],int pos, char let){
    boolean valor = false;
        if (pos<arr.length) {
            valor = idCaracter(arr,pos+1,let);
            if (!valor) {
                if (let==arr[pos]) {
                valor =true;
            }
                return valor;                
            }
        }
        else{
            if (let == arr[pos-1]) {
                valor=true;
            }            
}
        return valor;
    }
}
