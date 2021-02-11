/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DDA19;

/**
 *
 * @author Walter
 */
public class TpRecursion3a {
    public static void main (String[]arg){
    
        int arr [] = new int [3];
        int pos=0;
        arr[0]=2;
        arr[1]=4;
        arr[2]=3;
        System.out.println(masAlto(pos,arr));
    
    }
    public static int masAlto(int pos, int arr[]){
    int alto=0,aux;
        if (pos<arr.length) {
            aux = masAlto(pos+1,arr);
            if (arr[pos]>aux) {
                alto=arr[pos];
                return alto;
            }
            else{return aux;}
        }
        else{
        alto=arr[pos-1];}
    return alto;
    }
    
}
