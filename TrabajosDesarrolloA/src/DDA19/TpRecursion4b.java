/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DDA19;

import utiles.TecladoIn;

/**
 *
 * @author Walter
 */
public class TpRecursion4b {
    public static void main (String []arg){
    char matriz [][] = new char [3][3];
    char elem;
    int fil=0;
    boolean algo;
    matriz[0][0] ='b';
    matriz[0][1] ='c';
    matriz[0][2] ='a';
    matriz[1][0] ='t';
    matriz[1][1] ='r';
    matriz[1][2] ='s';
    matriz[2][0] ='u';
    matriz[2][1] ='f';
    matriz[2][2] ='g';
        System.out.println("Ingrese un caracter a busca");
        elem = TecladoIn.readLineNonwhiteChar();
        algo = busqueda(fil,matriz,elem);
        if (algo) {
            System.out.println("Se encuentra dentro de la matriz");
        }
        if (!algo) {
            System.out.println("no se encuentra en la matriz");            
        }
        
    
    }
    public static boolean busqueda(int fil, char matriz[][],char elem){
    boolean aux = false;
        
        if (!aux && fil<matriz.length) {
            for (int i = 0; i < matriz.length; i++) {
                if (elem == matriz[fil][i]) {
                    aux=true;
                }}
                if (aux) {
                    return aux;
                }
                else{
                aux = busqueda(fil+1,matriz,elem);}
                }
        return aux;
        }
    }

