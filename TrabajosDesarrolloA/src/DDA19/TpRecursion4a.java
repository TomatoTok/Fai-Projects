/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DDA19;

/**
 *
 * @author Walter
 */
public class TpRecursion4a {
    public static void main(String [] arg){
        
        int matriz [][] = new int [3][3];
        int fil =0,col =0;
        
        matriz[0][0]=1;
        matriz[0][1]=4;
        matriz[0][2]=8;
        matriz[1][0]=2;
        matriz[1][1]=2;
        matriz[1][2]=3;
        matriz[2][0]=4;
        matriz[2][1]=1;
        matriz[2][2]=9;
        System.out.println("el mayor numero es:"+mayorNum(fil,matriz));
    }
    public static int mayorNum(int fil,int matriz[][]){
    int aux=0,aux2=0,alto=0;
        if (fil<matriz.length) {
            for (int i = 0; i <matriz.length; i++) {
                if (aux<matriz[fil][i]) {
                    aux = matriz[fil][i];
                }
                aux2 = mayorNum(fil+1,matriz);
            }
            if (aux>aux2) {
                alto=aux;
                return alto;
            }
        }
        if (aux2>alto) {
            alto=aux2;
        }
    return alto;
    }
}
