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
public class TPBusquedaEj4 {
    public static void main(String []arg){
        int a [] = {2,4,7};
        int b [] = {1,3,5,6};
        int c [] = new int [a.length+b.length];
        c=nuevoArr(a,b);
        mostrar(c);
    }
    public static int [] nuevoArr(int a[],int b[]){
      int i=0,j=0,c=a.length+b.length,pos=0;
      int x [] = new int [a.length+b.length];
        while(pos<c){
            if (i<a.length && j<b.length) {
                if (a[i]>b[j]){
                x[pos]=b[j];
                    j++;
                    pos++; }
                    
            else{   x[pos]=a[i];
                     i++; 
                     pos++; 
                  
            }}
            else{
                if (i==a.length) {
                    for (int k = j; k < b.length; k++) {
                    x[pos]=b[k];
                    pos++;
                }}
                else{ 
                    for (int k = i; k < a.length; k++) {
                    x[pos]=a[k];
                    pos++;
                }}
            }
            }
        
      return x;}  
    
    public static void mostrar(int c[]){
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
    }
    
}
