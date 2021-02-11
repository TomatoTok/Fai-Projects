/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;

/**
 *
 * @author Walter
 */
public class TestArbolAVL {
    public static void main(String [] arg){
    ArbolAVL a = new ArbolAVL();
    prueba(a);
    
    }
    
    public static void prueba(ArbolAVL a){
    a.insertar(15);
    a.insertar(7);
    a.insertar(23);
    a.insertar(5);
    a.insertar(71);
    a.insertar(6);
    a.insertar(4);
    System.out.println(a.toString());
////Elimino 6 que es caso 3 y 15 que es caso 3 raiz
//    a.eliminar(6);
//    a.eliminar(15);
//    System.out.println(a.toString());
////Elimino 23 y 71 para hacer rotacion derecha en raiz
//    a.eliminar(23);
//    a.eliminar(71);
//    System.out.println(a.toString());
////Elimino 7 y 4 para caso 2 en raiz
//    a.eliminar(7);
//    a.eliminar(4);
//    System.out.println(a.toString());
////Elimino 5 para caso 1 y caso Raiz
//    a.eliminar(5);
    System.out.println(a.elemMaximo().toString());

    }
}
