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
public class TPRecursividadEj4 {
    public static void main (String[]arr){
    int arrM[][]= new int [4][4];
    char op=' ';
    int i=0,j=0,x;
    arrM[0][0]=6;arrM[1][0]=7;arrM[2][0]=7;arrM[3][0]=9;
    arrM[0][1]=4;arrM[1][1]=5;arrM[2][1]=5;arrM[3][1]=8;
    arrM[0][2]=3;arrM[1][2]=9;arrM[2][2]=1;arrM[3][2]=7;
    arrM[0][3]=8;arrM[1][3]=0;arrM[2][3]=1;arrM[3][3]=5;
        System.out.println("Elije una opcion:");
        System.out.println("a) Busca el mayor numero");
        System.out.println("b) Busca un digito");
        op=TecladoIn.readLineNonwhiteChar();
        switch(op){
            case 'a': System.out.println(mayor(arrM,i,j));break;
            case 'b': System.out.println("Ingrese el digito a buscar");
                        x=TecladoIn.readInt();
                        if (pertenece(arrM,i,j,x)) {
                            System.out.println("Si pertenece");
                }else{System.out.println("No pertenece");}
                        break;
            default : System.out.println("xao");break;
        }
    
    }
    public static int mayor(int arrM[][],int i,int j){
    int may;
        if (i == arrM.length-1 && j == arrM.length-1){
            may=arrM[i][j];
                
            }
        else{
                may=mayor(arrM,i+1,j+1);
                    if (arrM[i][j]>may) {
                        may=arrM[i][j];
            }
}
        return may;
    }
    public static boolean pertenece(int arrM[][],int i, int j,int x){
        boolean aux=false;
        if ((i == arrM.length-1 && j == arrM.length-1)) {
            if (arrM[i][j] == x) {
              aux=true;  
            }            
        }
        else{if (arrM[i][j] == x) {
                aux=true;
            }
        else{aux=pertenece(arrM,i+1,j+1,x);}        
}
        return aux;
    }
}
