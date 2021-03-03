/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final;

import java.util.Scanner;

/**
 *
 * @author Tomas Bascal
 */
public class vocalesRepetidas {
 public static void main (String []arg){
     menu();
 }
 public static void menu(){
 String pal;
 Scanner sc = new Scanner (System.in);
     System.out.println("ingrese una palabra");
     pal = sc.nextLine();
     if (repiteVoc(pal)) {
         System.out.println("Si se repiten vocales");
     }else{
         System.out.println("No se repite ninguna vocal");}
 }
 public static boolean repiteVoc(String pal){
 boolean valor=false;
 //Si alguna vocal se repite mas de dos veces entonces devuelve true
     if (contadorVoc(pal,'a',0,0)||contadorVoc(pal,'e',0,0)||contadorVoc(pal,'i',0,0)||contadorVoc(pal,'o',0,0)||contadorVoc(pal,'u',0,0)) {
         valor=true;
     }
     return valor;
 }
    public static boolean contadorVoc(String pal, char voc,int pos,int cont){
       //Metodo recursivo para contar vocales
        //Cuenta la vocal del parametro,si iguala o supera el numero 2 permitido o llega al final de la palabra entonces termina la ejecucion
        boolean aux=false;
        if (cont>=2) {
        aux=true;}else{
        if (pos<pal.length()) {
            if (pal.charAt(pos)==voc) {
                //Si la vocal se repite entonces la posicion y el contador aumenta en 1 y se llama a si mismo
                aux=contadorVoc(pal,voc,pos=pos+1,cont=cont+1);
            }else{
                //Si no se repite la vocal entonces la posicion aumenta en 1 y se llama a si mismo
                aux=contadorVoc(pal,voc,pos=pos+1,cont);
            }
        }}
        return aux;
    }
}
