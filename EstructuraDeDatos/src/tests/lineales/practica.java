/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;
/**
 *
 * @author Walter
 */
public class practica {
    public static void main(String[]arg){
     Lista algo = new Lista();
     Lista aux;
    algo.insertar('A', algo.longitud()+1);
    algo.insertar('B', algo.longitud()+1);
    algo.insertar('*', algo.longitud()+1);
    algo.insertar('C', algo.longitud()+1);
    algo.insertar('*', algo.longitud()+1);
    algo.insertar('T', algo.longitud()+1);
    algo.insertar('F', algo.longitud()+1);
   // algo.insertar('*', algo.longitud()+1);
        System.out.println("La cadena: "+algo);
    System.out.println("La nueva cadena: "+algo.generarLista(algo));

}}
