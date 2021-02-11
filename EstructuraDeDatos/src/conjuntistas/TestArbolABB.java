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
public class TestArbolABB {
    public static void main (String[]arg){
        ArbolABB arbol = new ArbolABB();   
        pruebaEliminar(arbol);
    }
    public static void imprime(ArbolABB arbol){
//      Metodo de testeo del TDA Arbol Binario de Busqueda
        System.out.println("-----------------------------------------------------");
        System.out.println("Imprimo el arbol deberia darme vacio");
        System.out.println(arbol.toString());
        System.out.println("--------------------INSERTAR--------------------");
        System.out.println("Inserto 8 debe dar true: "+arbol.insertar(8));     
        System.out.println("Inserto 5 debe dar true: "+arbol.insertar(5));
        System.out.println("Inserto 8 debe dar false: "+arbol.insertar(8));
        System.out.println("Inserto 10 debe dar true: "+arbol.insertar(10));
        System.out.println("Inserto 9 debe dar true: "+arbol.insertar(9));
        System.out.println("Estado Actual del arbol");
        System.out.println("\n\t\t8\t\t\n"
                         + "\n5\t\t\t10\n"
                         + "\t\t9\n");
        System.out.println("Imprimo el arbol");
        System.out.println(arbol.toString());
        System.out.println("\n\n");
        System.out.println("--------------------Eliminar--------------------");
        System.out.println("Elimino el elemento maximo debe dar true: "+ arbol.eliminarMax());
        System.out.println("Muestro el estado del arbol:");
        System.out.println(arbol.toString());
        System.out.println("Elimino el elemento maximo debe dar true: "+ arbol.eliminarMax());
        System.out.println("Muestro el estado del arbol:");
        System.out.println(arbol.toString());
        System.out.println("Elimino otra vez el elemento maximo siendo este la raiz debe dar true: "+ arbol.eliminarMax());
        System.out.println("Imprimo el arbol:"+"\n"+ arbol.toString());
        System.out.println("Inserto los elementos 2,3,7 y 11");
        arbol.insertar(2);
        arbol.insertar(3);
        arbol.insertar(7);
        arbol.insertar(11);
        System.out.println("Imprimo el arbol:"+"\n"+ arbol.toString());
        System.out.println("Elimino el elemento minimo debe dar true: "+ arbol.eliminarMin());
        System.out.println("Muestro el estado del Arbol");
        System.out.println(arbol.toString());
        System.out.println("Elimino el elemento minimo debe dar true: "+ arbol.eliminarMin());
        System.out.println("Muestro el estado del Arbol:");
        System.out.println(arbol.toString());
        System.out.println("Elimino otra vez el elemento minimo siendo este la raiz debe dar true: "+ arbol.eliminarMin());
        System.out.println("Imprimo el arbol:"+"\n"+ arbol.toString());
        arbol.vaciar();
        System.out.println("Vacio el arbol y elimino minimo debe dar False: "+arbol.eliminarMin());
        System.out.println("Muestro el arbol:"+arbol.toString());
        System.out.println("Elimino maximo debe dar false:"+arbol.eliminarMax());
        System.out.println();
        System.out.println("--------------------Listar por Rango--------------------");
        System.out.println("Inserto los elementos 7,11,2,3,5 y 10");
        arbol.insertar(7);
        arbol.insertar(11);
        arbol.insertar(2);
        arbol.insertar(3);
        arbol.insertar(5);
        arbol.insertar(10);
        System.out.println("\n");
        System.out.println("Estado Actual del arbol");
        System.out.println("\n\t\t7\t\t\t\n"
                         + "\n2\t\t\t\t11\n"
                         + "\t3\t\t10\n"
                         + "\t\t5");
        System.out.println(arbol.toString());
        System.out.println("Listo por Rango del elemento 3 hasta el 10: "+arbol.listarRango(3, 10));
        System.out.println("Listo por Rango del elemento 7 hasta el 10: "+arbol.listarRango(7, 10));
        System.out.println("Listo valores que no existen 32 al 100"+ arbol.listarRango(32,100));
        System.out.println("Listo por Rango del elemento 5 hasta el 11: "+arbol.listarRango(5, 11));
        System.out.println("Listo por Rango la raiz 7 hasta la misma raiz 7: "+arbol.listarRango(7, 7));
        System.out.println("Listo por Rango del elemento 10 hasta el mismo elemento 10: "+arbol.listarRango(10, 10));
        System.out.println("-----------------------------------------------------");
    
    }
    public static void pruebaEliminar(ArbolABB arbol){
    arbol.insertar(8);
    arbol.insertar(13);
    arbol.insertar(10);
    arbol.insertar(15);
    arbol.insertar(4);
    arbol.insertar(5);
    arbol.insertar(3);
    

        System.out.println(arbol.toString());

//        System.out.println(arbol.toString());        
        arbol.eliminar(4);
        System.out.println(arbol.toString());
//        arbol.eliminar(3);
//        System.out.println(arbol.toString());
//        arbol.eliminar(2);
//        System.out.println(arbol.toString());
//        arbol.eliminar(5);
//        System.out.println(arbol.toString());
//        arbol.eliminar(8);
//        System.out.println(arbol.toString());


    }
    
}
