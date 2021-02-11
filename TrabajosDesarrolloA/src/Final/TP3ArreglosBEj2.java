/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final;

/**
 *
 * @author Walter
 */
public class TP3ArreglosBEj2 {
    public static void main (String []arg){
    int arrMat[][]= new int [4][4];
    arrMat[0][0]=1;
    arrMat[0][1]=2;
    arrMat[0][2]=3;
    arrMat[0][3]=4;
    arrMat[1][0]=5;
    arrMat[1][1]=6;
    arrMat[1][2]=7;
    arrMat[1][3]=8;
    arrMat[2][0]=9;
    arrMat[2][1]=10;
    arrMat[2][2]=11;
    arrMat[2][3]=12;
    arrMat[3][0]=13;
    arrMat[3][1]=14;
    arrMat[3][2]=15;
    arrMat[3][3]=16;
    
        for (int i = 0; i < arrMat.length; i++) {
            if (i%2==0) {
                 for (int j = 0; j < arrMat.length; j++) {
                System.out.print(arrMat[i][j]);
            }
            }
            else{ for (int j = arrMat.length-1; j >-1; j--) {
                System.out.print(arrMat[i][j]);
            }}
            System.out.println();
           
        }
    }
}
