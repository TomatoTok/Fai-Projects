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
public class TP3ArreglosBEj4 {
    public static void main(String []arg){
    int arrMat[][]=new int [5][5];
    char opc=' ';
    cargaMatriz(arrMat);
     menu();
    while(opc!='x'){    
     opc=TecladoIn.readLineNonwhiteChar();
        switch(opc){
            case 'a':System.out.println("El porcentaje total es de:%"+porc7(arrMat));break;
            case 'b':porcEsc(arrMat);break;
            case 'c':noJuegan(arrMat);break;
            case 'd':promCateg(arrMat);break;
            case 'e':grupoG(arrMat);break;
            case 'f':grupoP(arrMat);break;
            
        }
    
    }
    }
public static int[][] cargaMatriz(int arrMat[][]){
    arrMat[0][0]=5;arrMat[2][3]=10;
    arrMat[0][1]=6;arrMat[2][4]=12;
    arrMat[0][2]=5;arrMat[3][0]=10;
    arrMat[0][3]=7;arrMat[3][1]=12;
    arrMat[0][4]=10;arrMat[3][2]=8;
    arrMat[1][0]=12;arrMat[3][3]=9;
    arrMat[1][1]=10;arrMat[3][4]=16;
    arrMat[1][2]=11;arrMat[4][0]=3;
    arrMat[1][3]=8;arrMat[4][1]=2;
    arrMat[1][4]=15;arrMat[4][2]=4;
    arrMat[2][0]=10;arrMat[4][3]=5;
    arrMat[2][1]=11;arrMat[4][4]=7;
    arrMat[2][2]=9;
    
    return arrMat;
}
public static void menu(){
    System.out.println("Bienvenido wacho");
    System.out.println("Elija una opcion");
    System.out.println("a)Porcentaje total de grupos de mas de 7 niños");
    System.out.println("b)Cantidad de alumnos por escuela y porcentaje del total");
    System.out.println("c)Categoria y escuelas que no llegan a armar un grupo de 7");
    System.out.println("d)Promedio de alumnos por categoria");
    System.out.println("e)Grupo mas grande");
    System.out.println("f)Grupo mas pequeño");
    System.out.println("x)Salir");
    

}
public static double porc7(int arrMat[][]){
int cont=0;
double porc;
    for (int i = 0; i < arrMat.length; i++) {
        for (int j = 0; j < arrMat.length; j++) {
            if (arrMat[i][j]>6) {
                cont=cont+1;
                
            }
        }
    }
porc=((arrMat.length*2)*100)/cont;
 
return porc;
}
public static void porcEsc(int arrMat[][]){
double porc=0,suma=0;
int aux=0;
    for (int i = 0; i < arrMat.length; i++) {
        for (int j = 0; j < arrMat[0].length; j++) {
            suma=suma+arrMat[i][j];            
        }
       }
     
     for (int i = 0; i < arrMat.length; i++) {
         for (int j = 0; j < arrMat[0].length; j++) {
             aux=aux+arrMat[i][j];
         }
         porc=(aux*100)/suma;
        System.out.println("La cantidad de alumnos de la escuela "+escuela(i)+" es de:"+aux+" y su porcentaje del total es de:%"+porc);
        aux=0;
    }
        
    
}
public static String escuela(int esc){
String colegio="";
    switch(esc){
    case 0:colegio="Los patos (Centenario)";break;
    case 1:colegio="Marabunta(Cipolletti)";break;
    case 2: colegio="RRC(roca)";break;
    case 3:colegio ="NRC(Neuquen)";break;
    case 4:colegio="ARC(Allen)";break;
    }
return colegio;
}
public static String categoria(int cat){
String categoria="";
switch(cat){
    case 0: categoria="M4";break;
    case 1: categoria="M6";break;
    case 2: categoria="M7";break;
    case 3: categoria="M8";break;
    case 4: categoria="M10";break;
    
}
return categoria;
}
public static void noJuegan(int arrMat[][]){
    for (int i = 0; i < arrMat.length; i++) {
        for (int j = 0; j < arrMat[0].length; j++) {
            if (arrMat[i][j]<7) {
                System.out.println("La escuela "+escuela(i)+" de la categoria:"+categoria(j)+" No cumple con las condiciones minimas");
            }
        }
    }

}
public static void promCateg(int arrMat[][]){
int suma=0,aux=0;
    for (int i = 0; i < arrMat.length; i++) {
        for (int j = 0; j < arrMat.length; j++) {
            suma=suma+arrMat[j][i];
        }
        aux=suma/arrMat[0].length;
        System.out.println("La categoria:"+categoria(i)+" tiene un promedio de "+aux+" alumnos");
        suma=0;
    }
}
public static void grupoG(int arrMat[][]){
int esc=0,cat=0,temp=0;
    for (int i = 0; i < arrMat.length; i++) {
        for (int j = 0; j < arrMat.length; j++) {
            if (arrMat[i][j]>temp) {
                temp=arrMat[i][j];
                esc=i;
                cat=j;
            }
        }
    }
    System.out.println("El grupo mas grande es de "+escuela(esc)+" categoria:"+categoria(cat)+" con un total de:"+temp);
}
public static void grupoP(int arrMat[][]){
int esc=0,cat=0,temp=100;
    for (int i = 0; i < arrMat.length; i++) {
        for (int j = 0; j < arrMat.length; j++) {
            if (arrMat[i][j]<temp) {
                temp=arrMat[i][j];
                esc=i;
                cat=j;
            }
        }
    }
    System.out.println("El grupo mas Pequeño es de "+escuela(esc)+" categoria:"+categoria(cat)+" con un total de:"+temp);
}

}
