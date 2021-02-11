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
public class Simulacro2016Ej2 {
    public static void main (String[]arg){
        char arr[][] = new char [4][4];
        arr[0][0]='a'; arr[2][0]='h';
        arr[0][1]='e'; arr[2][1]='j';
        arr[0][2]='r'; arr[2][2]='a';
        arr[0][3]='t'; arr[2][3]='h';
        arr[1][0]='v'; arr[3][0]='g';
        arr[1][1]='a'; arr[3][1]='g';
        arr[1][2]='b'; arr[3][2]='f';
        arr[1][3]='a'; arr[3][3]='b';
        
        if (diagonal(arr)) {
            System.out.println("La matriz es Diagonal");
        }
        if (!diagonal(arr)) {
            System.out.println("La matriz no es Diagonal");
        }
        
    }
    public static boolean diagonal(char arr[][]){
        boolean aux=true;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i][i] != arr[i+1][i+1]) {
                aux=false;
            }
        }
        return aux;
    }
}
