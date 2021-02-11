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
public class TP2ArreglosEj2 {
    public static void main (String []arg){
   String cod;
   char arrcn[]= new char [8];
        System.out.println("ingrese el codigo");
        cod = TecladoIn.readLine();
        arrcn=cargarCn(cod);
        for (int i = 0; i < arrcn.length; i++) {
            System.out.print(arrcn[i]+" ");
        }
        
    }
    public static char[] cargarCn(String cod){
    char cn[]=new char [8],algo='a';
    int aux=0,num;
    int REDIX=10;
    String aux2;
        for (int i = 0; i < cn.length; i=i+2) {
            cn[i]=cod.charAt(aux);
            if (cod.charAt(aux) == '3') {
                cn[i+1]='A';
            }
            if (cod.charAt(aux) =='5') {
                cn[i+1]='M';
            }
            if (cod.charAt(aux) =='7') {
                cn[i+1]='F';
            }
            else{num=Integer.parseInt(String.valueOf(cod.charAt(aux)));
                  num=((num+5)*3) ; 
                 cn[i+1]=Character.forDigit(num, REDIX);
            }
            aux=aux+1;
        }
        return cn;
    }
}
