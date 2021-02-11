/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final;
import java.util.Random;
/**
 *
 * @author Walter
 */
public class TP3ArreglosBEj3 {
    public static void main(String []arg){
    int arrMat[][]= new int [15][10];
    int arr [] = new int [150];
    int cont=0;
    arr=cargarArr(arr);
        for (int i = 0; i < arrMat.length; i++) {
            for (int j = 0; j < arrMat[0].length; j++) {
                arrMat[i][j]=arr[cont];
                cont++;
            }
            
        }
           for (int i = 0; i < arrMat.length; i++) {
               for (int j = 0; j < arrMat[0].length; j++) {
                   System.out.print(arrMat[i][j]+" ");
               }
               System.out.println();
        }
        System.out.println();
        System.out.println("Arreglo");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static int[] cargarArr(int arr[]){
        Random aux =new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i]=aux.nextInt(10);
        }
    return arr;
    }
}
