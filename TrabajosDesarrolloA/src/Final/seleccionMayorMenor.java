/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final;

/**
 *
 * @author Tomas Bascal
 */
public class seleccionMayorMenor {
 public static void main (String [] arg){
 int arr [] = new int [6];
    instrucciones(arr);
 }
 public static void instrucciones(int arr[]){
     //Se carga el arreglo
    cargarArr(arr);
    System.out.println("Arreglo Original:");
    mostrarArr(arr);
    //Se ordena el arreglo
    seleccionMayMen(arr);
    System.out.println("Arreglo Ordenado mayor a menor: ");
    mostrarArr(arr);
 }
 public static void cargarArr(int arr[]){
     //Carga el arreglo
     arr[0]=3;
    arr[1]=8;
    arr[2]=1;
    arr[3]=5;
    arr[4]=2;
    arr[5]=6;
 }
 //Algoritmo de Ordenamiento por Seleccion (Mayor a menor)
 public static void seleccionMayMen(int arr[]){
    int mayor;
        for (int i = 0; i < arr.length - 1; i++) {
            mayor = i;
            for (int j = i + 1; j < arr.length; j++) {
                //El cambio importante para determinar el orden mayor a menor
                //es la condicion de "< o >" que determina hacia donde se ordena
                if (arr[j] > arr[mayor]) {
                    mayor = j;
                }
            }
        //Se llama al metodo cambio para intercambiar valores de las pasociones del arreglo
            cambio(arr,i,mayor);
        }
    }
 public static void cambio(int arr[], int i, int may){
 //Algoritmo de intercambio de valores
    int aux=arr[i];
    arr[i]=arr[may];
    arr[may]=aux;
 }
 public static void mostrarArr(int arr[]){
     //Muestra el arreglo
     System.out.print("[ ");
     for (int i = 0; i < arr.length; i++) {
         System.out.print(arr[i]+" ");
     }
    System.out.print("]\n");
 }
 }

