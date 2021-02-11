/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;

/**
 *
 * @author Walter
 */
public class pruebaBinario {
    public static void main (String[]arg){
    ArbolBin algo = new ArbolBin();
    algo.insertar(1,1,'I');
    algo.insertar(2,1,'D');
    algo.insertar(3,1,'I');
    algo.insertar(4,3,'D');
    algo.insertar(5,3,'I');
    algo.insertar(6,2,'I');
    algo.insertar(7,2,'D');
    algo.insertar(8, 5,'I');
    //algo.obtenerAncestro(5);
    System.out.println(algo.obtenerAncestro(1));
    
    }
  
    
}
