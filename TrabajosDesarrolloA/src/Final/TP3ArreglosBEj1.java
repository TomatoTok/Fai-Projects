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
public class TP3ArreglosBEj1 {
    public static void main (String []arg){
    int fil,col;
    char opcion=' ';
        System.out.println("Ingrese la cantidad de filas");
        fil=TecladoIn.readLineInt();
        System.out.println("Ingrese la cantidad de Columnas");
        col=TecladoIn.readLineInt();
    int arrMat[][]= new int [fil][col];
    while(opcion != 'x'){
    opcion=menu();    
    switch(opcion){
        case 'a': arrMat=cargarFil(arrMat);break;
        case 'b': arrMat=cargarMat(arrMat);break;
        case 'c': mostrarCol(arrMat);break;
        case 'd': mostrarMat(arrMat);break;
        case 'x': break;
    }
    }
        System.out.println("Gracias por usar este programa");
   
    
            
    }
    public static char menu(){
    char opcion;
        System.out.println("Elija una opcion");
        System.out.println("a)Cargar la fila i-esima de la matriz");
        System.out.println("b)Cargar la matriz completa");
        System.out.println("c)Mostrar la columna i-esima de la matriz");
        System.out.println("d)Mostrar la matriz entera");
        System.out.println("x)Salir del programa");
        opcion=TecladoIn.readChar();
        return opcion;
    }
    public static int[][] cargarFil(int arrMat[][]){
        int pos;
        System.out.println("Ingrese que fila desea cargar, tiene un total de:"+arrMat.length);
        pos=TecladoIn.readInt();
        pos=pos-1;
        if (pos<0 || pos>arrMat.length ) {
            System.out.println("No existe esa ubicacion");
        }
        else{
        for (int i = 0; i < arrMat.length; i++) {
            System.out.println("Ingrese un numero");
            arrMat[pos][i]=TecladoIn.readLineInt();
            
        }}
        return arrMat;
    }
    public static int[][] cargarMat(int arrMat[][]){
       char opcion=' ';
        while(opcion !='n'){
        arrMat=cargarFil(arrMat);
            System.out.println("Desea cargar otra fila?");
            opcion = TecladoIn.readLineNonwhiteChar();
        }
        
        return arrMat;
    }
    public static void mostrarCol(int arrMat[][]){
        int pos;
        System.out.println("Elija la columna");
        pos=TecladoIn.readInt();
        pos=pos-1;
        for (int i = 0; i < arrMat.length; i++) {
            System.out.println(arrMat[i][pos]);
        }
    }
    public static void mostrarMat(int arrMat[][]){
        System.out.println("Matriz completa");
        for (int i = 0; i < arrMat.length; i++) {
            for (int j = 0; j < arrMat[0].length; j++) {
                System.out.print(arrMat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
