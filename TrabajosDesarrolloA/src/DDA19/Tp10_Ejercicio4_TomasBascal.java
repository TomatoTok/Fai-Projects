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
public class Tp10_Ejercicio4_TomasBascal {

    public static void main(String[] arg) {

        int matriz[][] = new int[3][3];
        int fil = 0, col = 0;
        matriz[0][0] = 1;
        matriz[0][1] = 2;
        matriz[0][2] = 3;
        matriz[1][0] = 4;
        matriz[1][1] = 5;
        matriz[1][2] = 6;
        matriz[2][0] = 7;
        matriz[2][1] = 8;
        matriz[2][2] = 9;
 
        System.out.println("Matriz original");
        impXPantalla(matriz);
        invertirMatriz(fil, col, matriz);
        System.out.println();
        System.out.println("Invertida");
        impXPantalla(matriz);

    }

    public static void invertirMatriz(int fil, int col, int matriz[][]) {
        int aux, ultF, ultC, bandera;
        ultF = (matriz.length - 1) - fil;
        ultC = (matriz[0].length - 1) - col;
        bandera = (fil + col) - (ultF + ultC);
  
       if ( bandera <=0 && col < matriz[0].length) {            
            aux = matriz[fil][col];
            matriz[fil][col] = matriz[ultF][ultC];
            matriz[ultF][ultC] = aux;                
            invertirMatriz(fil, col + 1, matriz);
        }
        if (bandera <=0 && fil <= matriz.length) {            
            invertirMatriz(fil + 1, col=0, matriz);
        }
   
       

    }

    public static void impXPantalla(int matriz[][]) {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

    }
}
