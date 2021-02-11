/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DDAUltimate;

import utiles.TecladoIn;

/**
 *
 * @author Walter
 */
public class TPBusquedaEj2 {
public static void main(String[]arg){
    int arr [] = {1,2,3,4,5,6};
    int n,aux;
        System.out.println("Ingrese el valor a buscar");
        n = TecladoIn.readLineInt();
        switch (menu()){
            case 'a' : aux=secuencial(arr,n);if (aux==-1){System.out.println("El numero ingresado no se encuentra");}
                        else{System.out.println("La posicion del nuemro es: "+aux);}break;
            case 'b' : aux=busquedaBin(arr,n);if (aux==-1){System.out.println("El numero ingresado no se encuentra");}
                        else{System.out.println("La posicion del nuemro es: "+aux);}break;
            default : System.out.println("Error");break;
        }
        
    
    }
public static int secuencial(int arr[],int n){
int pos=-1,i=0;
boolean ban = false;
while(!ban && i<arr.length){
    if (arr[i]==n) {
        ban=true;
        pos=i;
    }
    else{i++;}
}
return pos;
}
public static int busquedaBin(int arr[],int n){
    int in=0,med,fin=arr.length,res=-1;
    while(in <= fin){
    med=(in+fin)/2;
        if (n==arr[med]) {
            res=med;
            in=fin+1;
        }
        else{if (n< arr[med]) {
                fin=med-1;
            }
        else{in=med+1;}
}
}
    return res;
}
public static char menu(){
    char op;
    System.out.println("Elija un metodo:");
    System.out.println("a)Secuencial");
    System.out.println("b)Busqueda binaria");
    op=TecladoIn.readLineNonwhiteChar();
    return op;
}
}
