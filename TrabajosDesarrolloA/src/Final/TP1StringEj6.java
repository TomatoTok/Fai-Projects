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
public class TP1StringEj6 {
    public static void main (String[]arg){
    String arr[]=new String [8];
    arr[0]="gato";
    arr[1]="tortuga";
    arr[2]="elefante";
    arr[3]="hipopotamo";
    arr[4]="jirafa";
    arr[5]="oso";
    arr[6]="cocodrilo";
    arr[7]="tigre";
    
      for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" , ");
        }
        System.out.println();
        ordenaArr(arr);
        
    }
    public static void ordenaArr(String arr[]){
    
       String aux;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i].length()>arr[j].length()) {
                    aux=arr[i];
                    arr[i]=arr[j];
                    arr[j]=aux;
                }
            }
        }
         for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" , ");
         }
        
    }
}
