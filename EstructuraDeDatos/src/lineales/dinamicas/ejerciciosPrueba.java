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
public class ejerciciosPrueba {
    public static void main (String[] arg){
    Lista aux = new Lista();
    aux.insertar(1,1);
    aux.insertar(2,2);
    aux.insertar(1, 3);
    aux.insertar(4, 4);
    aux.insertar(1, 5);
    aux.insertar(6, 6);
        System.out.println(aux.toString());
        
    aux.agregarElem(3,2);

        System.out.println(aux.toString());
    
    }
}
