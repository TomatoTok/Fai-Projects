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
public class TP8RecursividadEj4b {
    public static void main (String []arg){
    int v [] ={1,2,3,6,5};
    int i = 0;
    boolean ban = true;
        System.out.println("El orden del arreglo es cereciente?:"+crec(v,ban,i));
    }
    public static boolean crec(int v [],boolean ban,int i){        
        if ( v[i]<v[i+1]&& i==v.length-2) {
        if (ban) {return true;}    
        else{return false;}}        
            else{ if (ban && i<v.length && v[i]<v[i+1] ) {
            ban=crec(v,ban,i+1);
            return ban;}
            else{ return false;}}}
}
