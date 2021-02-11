/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 *
 * @author Walter
 */
public class MixLineales {
    public static void main(String []arg){
    Lista a = new Lista();
    Lista b = new Lista();
    Lista c = new Lista();
        System.out.println("*------------------------------------------------*");
        System.out.println("* Test metodo Generar Lista de la reentrega      *");
        System.out.println("*------------------------------------------------*");
        System.out.println();
        System.out.println("+ Creo una lista con la siguiente cadena: [AB*C*DF]");
        a.insertar('A',1);
        a.insertar('B',2);
        a.insertar('*',3);
        a.insertar('C',4);
        a.insertar('*',5);
        a.insertar('D',6);
        a.insertar('F',7);
        System.out.println("Genero la lista nueva: "+a.generarLista(a));
        System.out.println("+ Creo una lista con la siguiente cadena: [A*B*CDF]");
        b.insertar('A',1);
        b.insertar('*',2);
        b.insertar('B',3);
        b.insertar('*',4);
        b.insertar('C',5);
        b.insertar('D',6);
        b.insertar('F',7);
        System.out.println("Genero la lista nueva: "+b.generarLista(b));
        System.out.print("+ Vacio la lista y genero la lista vacia: ");
        b.vaciar();
        System.out.println(b.generarLista(b));
        System.out.println("+ Creo una lista con la cadena: [A]");
        b.insertar('A', 1);
        System.out.println("Genero la lista nueva: "+b.generarLista(b));
        System.out.println("+ Creo una lista con la cadena: [A*BB*C*DE*F]");
        c.insertar('A',1);
        c.insertar('*',2);
        c.insertar('B',3);
        c.insertar('B',4);
        c.insertar('*',5);
        c.insertar('C',6);
        c.insertar('*',7);
        c.insertar('D',8);
        c.insertar('E',9);
        c.insertar('*',10);
        c.insertar('F',11);
        System.out.println("Genero la lista nueva: "+c.generarLista(c));
        System.out.println();
        System.out.println("*------------------------------------------------*");

        


    }
    
}
