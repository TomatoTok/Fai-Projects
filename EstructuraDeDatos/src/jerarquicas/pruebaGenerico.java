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
public class pruebaGenerico {
    public static void main(String[]arg){
    ArbolGen arbol=new ArbolGen();
    ArbolGen copia = new ArbolGen();
    arbol.insertar(10,0);
    arbol.insertar(9,10);
    arbol.insertar(15,10);
    arbol.insertar(7,9);
    arbol.insertar(3,9);
    arbol.insertar(10,3);
    arbol.insertar(6,1);
    arbol.insertar(12,15);
    arbol.insertar(20,15);
    arbol.insertar(22,15);
    arbol.insertar(30,15);
    arbol.insertar(40,30);
    arbol.insertar(45,30);
    arbol.insertar(55,30);
    copia=arbol.clone();
        System.out.println(arbol.toString());
        System.out.println("***********************************");
        System.out.println(copia.toString());
//    System.out.println(arbol.ancestros(45));
//        System.out.println(arbol.listarNiveles());
//        System.out.println(arbol.frontera());

    
    
    }
}
