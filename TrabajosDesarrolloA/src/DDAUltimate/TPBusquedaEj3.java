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
public class TPBusquedaEj3 {
    public static void main(String[]arg){
    int arr [] = {3,2,4,6,1,7,2,8};
        System.out.println("El arreglo original");
        muestra(arr);
        System.out.println();
        System.out.println("Arreglo ordenado por fuerza bruta");
        bubble(arr);
        muestra(arr);
        System.out.println();
        System.out.println("Arreglo ordenado por disminuye y venceras");
        insercion(arr);
        muestra(arr);
    }
    public static void bubble(int arr[]){
        int aux;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-2-i; j++) {
                if (arr[j+1]<arr[j]) {
                aux=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=aux;
                }
            }
        }
}
    public static void insercion(int arr[]){
        int aux,j;
        for (int i = 1; i < arr.length; i++) {
            aux=arr[i];
            j=i;
            while(j>0 && aux< arr[j-1]){
            arr[j]=arr[j-1];
            j=j-1;}
            arr[j]=aux;
        }
}
    public static void muestra(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
}
    
}
