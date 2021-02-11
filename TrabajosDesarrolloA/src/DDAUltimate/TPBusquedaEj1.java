/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DDAUltimate;

/**
 *
 * @author Walter
 */
public class TPBusquedaEj1 {
    public static void main (String []arg){
    int arr [] = {0,3,2,4,3};
    showMeArray(arr);
    System.out.println();
    seleccion(arr);
    showMeArray(arr);
    }
    public static void seleccion(int arr []){
    int min,aux;
        for (int i = 0; i < arr.length; i++) {
            min =i;
            for (int j = i+1; j < arr.length; j++) {
             if (arr[j]<arr[min]) {
                min=j;
            }    
            }
           aux=arr[i];
           arr[i]=arr[min];
           arr[min]=aux;
        }
    }
    public static void showMeArray(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"  ");
        }
}
}
