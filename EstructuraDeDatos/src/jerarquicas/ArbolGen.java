/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;

import lineales.dinamicas.Lista;
import lineales.dinamicas.Cola;

/**
 *
 * @author Tomas Bascal
 */
public class ArbolGen {

    private NodoGen raiz;

    public ArbolGen() {
        this.raiz = null;
    }

    public boolean insertar(Object nuevoElem, Object elemPadre) {
        boolean aux;
        aux = insertarAux(nuevoElem, elemPadre, this.raiz);
        return aux;
    }

    private boolean insertarAux(Object nuevoElem, Object elemPadre, NodoGen nodo) {
        boolean exito = false;
        NodoGen nuevo = new NodoGen(nuevoElem, null, null), aux;
        if (nodo == null) {
            //Si la raiz esta vacia se le asigna el nuevo nodo
            this.raiz = nuevo;
            exito = true;
        } else {
            //Si ya tiene algun hijo se busca asignar al ultimo hermano derecho
            aux = obtenerNodo(elemPadre, this.raiz);
            if (aux != null) {
                if (aux.getHijoIzquierdo() != null) {
                    aux = aux.getHijoIzquierdo();
                    while (aux.getHermanoDerecho() != null) {
                        aux = aux.getHermanoDerecho();
                    }
                    aux.setHermanoDerecho(nuevo);
                    exito = true;
                } else {
                    aux.setHijoIzquierdo(nuevo);
                    exito = true;
                }
            }
        }
        return exito;
    }

    public boolean pertenece(Object elem) {
        boolean existe;
        existe = perteneceAux(elem, this.raiz);
        return existe;
    }

    private boolean perteneceAux(Object elem, NodoGen nodo) {
        //Metodo privado que busca si un elemento pertenece al arbol
        boolean valor = false;
        if (nodo != null) {

            if (nodo.getElem() == elem) {
                valor = true;
            } else {
                if (nodo.getHijoIzquierdo() != null) {

                    valor = perteneceAux(elem, nodo.getHijoIzquierdo());
                }
                if (!valor && nodo.getHermanoDerecho() != null) {
                    valor = perteneceAux(elem, nodo.getHermanoDerecho());
                }

            }
        }
        return valor;
    }

    public Lista ancestros(Object elem){
    Lista ancestro= new Lista();
        if (!esVacio()) {
            obtenerAncestroAux(this.raiz,elem,ancestro);
        }
        return ancestro;
    }

        private boolean obtenerAncestroAux(NodoGen n, Object buscado,Lista ancestros) {
        //Motodo privado que busca un elemento y devuelve el nodo que lo contiene.
        //Si no se encuentra buscado devuelve null.
        boolean aux=false;
        if (n != null) {
            if (n.getElem().equals(buscado)) {
                //si el buscado es n termina el llamado recursivo
                aux=true;
            } else {
                //deciendo al hijo izquierdo              
               aux = obtenerAncestroAux(n.getHijoIzquierdo(), buscado,ancestros);
                if (aux) {
                       ancestros.insertar(n.getElem(), ancestros.longitud()+1); 
                    }
                //sigo por el hermano derecho
                if (!aux) {
                aux = obtenerAncestroAux(n.getHermanoDerecho(), buscado,ancestros);
                }                
            }        
        }           
        return aux;
        }

    private NodoGen obtenerNodo(Object elem, NodoGen nodo) {
        //metodo privado que permite buscar un nodo en base a un elemento
        NodoGen resultado = null;
        if (nodo != null) {
            if (nodo.getElem() == elem) {
                resultado = nodo;
            } else {
                resultado = obtenerNodo(elem, nodo.getHijoIzquierdo());
                if (resultado == null) {
                    resultado = obtenerNodo(elem, nodo.getHermanoDerecho());
                }
            }
        }
        return resultado;
    }

    public boolean esVacio() {
        //Metodo que permite verificar si un arbol esta vacio
        boolean valor = true;
        if (this.raiz != null) {
            valor = false;
        }
        return valor;
    }

    public int altura() {
        int alt;
        if (this.raiz == null) {
            alt = -1;
        } else {
            alt = obtenerAltura(this.raiz);
        }
        return alt;
    }

    private int obtenerAltura(NodoGen nodo) {
        //Metodo que permite obtener la altura del arbol
        int altura = 0, alturaAux = 0;
        if (nodo != null) {

            altura = obtenerAltura(nodo.getHijoIzquierdo()) + 1;
            alturaAux = obtenerAltura(nodo.getHermanoDerecho());
            if (altura > alturaAux) {
                alturaAux = altura;
            }
        } else {
            alturaAux = -1;

        }
        return alturaAux;
    }

    public int nivel(Object elem) {
        int niv, cont = -1;
        niv = obtenerNivel(this.raiz, elem, cont);
        return niv;
    }

    private int obtenerNivel(NodoGen nodo, Object elem, int cont) {
        //Metodo que permite obtener el nivel de un elemento
        int nivelElem = -1;
        if (nodo != null) {
            cont = cont + 1;
            if (nodo.getElem().equals(elem)) {
                nivelElem = cont;
            } else {
                //Llamados recursivos
                nivelElem = obtenerNivel(nodo.getHijoIzquierdo(), elem, cont);
                if (nivelElem == -1) {
                    cont = cont - 1;
                    nivelElem = obtenerNivel(nodo.getHermanoDerecho(), elem, cont);
                }
            }
        }
        return nivelElem;
    }

    public Object padre(Object hijo) {
        //Si la raiz no es nula o el hijo es la raiz entonces obtiene el elemento del nodo padre
        Object padre = null;
        if (this.raiz == null || hijo == this.raiz.getElem()) {
        } else {
            padre = obtenerPadre(this.raiz, hijo);
        }
        return padre;
    }

    private Object obtenerPadre(NodoGen nodo, Object hijo) {
        //Metodo privado para obtener el elemento del nodo padre
        Object padre = null;
        if (padre == null) {
            if (nodo.getHijoIzquierdo() != null) {
                NodoGen aux = nodo.getHijoIzquierdo();
                while (aux != null && padre == null) {
                    if (aux.getElem().equals(hijo)) {
                        padre = nodo.getElem();
                    } else {
                        aux = aux.getHermanoDerecho();
                    }
                }
                if (padre == null) {
                    //Llamado recursivo con el Hijo Izquierdo
                    padre = obtenerPadre(nodo.getHijoIzquierdo(), hijo);
                }

            }
            if (padre == null) {
                if (nodo.getHermanoDerecho() != null) {
                    if (nodo.getHermanoDerecho().getElem().equals(hijo)) {
                        padre = nodo.getElem();
                    }
                    if (padre == null) {
                        //Llamado recursivo con el Hijo Derecho
                        padre = obtenerPadre(nodo.getHermanoDerecho(), hijo);
                    }
                }
            }

        }
        return padre;
    }

    public Lista listarPreorden() {
        //imprime los elementos por consola en preorden
        //invoca a un metodo recursivo privado a la clase
        Lista listaAux = new Lista();
        if (this.raiz != null) {
            listaAux = preordenAux(this.raiz, listaAux);
        }
        return listaAux;
    }

    private Lista preordenAux(NodoGen nodo, Lista listaAux) {
        //metodo recursivo es Privado por que su parametro es de tipo NodoArbol
        if (nodo != null) {
            //visita el elemento en el nodo
            listaAux.insertar(nodo.getElem(), listaAux.longitud() + 1);//(1)

            //recorre a sus hijos y hermanos en preorden
            preordenAux(nodo.getHijoIzquierdo(), listaAux);//(2)
            preordenAux(nodo.getHermanoDerecho(), listaAux);//(3)
        }
        return listaAux;
    }

    public Lista listarInorden() {
        //imprime los elementos por pantalla en inorden
        //invoca a un metodo recursivo privado a la clase
        Lista listaAux = new Lista();
        if (this.raiz != null) {
            listaAux = inorden(this.raiz, listaAux);
        }
        return listaAux;
    }

    private Lista inorden(NodoGen nodo, Lista listaAux) {
        //Metodo recursivo es Privado por que su parametro es tipo NodoArbol
        //recorre todos los hijos izquierdos
        if (nodo.getHijoIzquierdo() != null) {
            inorden(nodo.getHijoIzquierdo(), listaAux);
        }
        //almacena el elemento
        listaAux.insertar(nodo.getElem(), listaAux.longitud() + 1);
        //Recorre todos los hermanos derechos a la vuelta del hijo izquierdo
        if (nodo.getHijoIzquierdo() != null) {
            NodoGen hijo = nodo.getHijoIzquierdo().getHermanoDerecho();
            while (hijo != null) {
                inorden(hijo, listaAux);
                hijo = hijo.getHermanoDerecho();
            }
        }
        return listaAux;
    }

    public Lista listarPosorden() {
        //Imprime los elementos por pantalla en posorden
        //Invoca a un metodo recursivo privado a la clase posorden
        Lista listaAux = new Lista();
        if (this.raiz != null) {
            listaAux = posorden(this.raiz, listaAux);
        }
        return listaAux;
    }

    private Lista posorden(NodoGen nodo, Lista listaAux) {
        //Metodo recursivo es Privado por que su parametro es tipo NodoArbol
        //recorre todos los hijos izquierdos
        if (nodo.getHijoIzquierdo() != null) {
            posorden(nodo.getHijoIzquierdo(), listaAux);
        }

        //Almacena el elemento
        listaAux.insertar(nodo.getElem(), listaAux.longitud() + 1);

        //Recorre todos los hermanos derechos a la vuelta del hijo izquierdo
        if (nodo.getHermanoDerecho() != null) {
            posorden(nodo.getHermanoDerecho(), listaAux);
        }
        return listaAux;
    }

    public Lista listarNiveles() {
        //imprime los elementos por pantalla en posorden
        //invoca a un mmetodo recursivo privado a la clase Niveles
        Lista listaAux = new Lista();
        listaAux = listarNivelesAux();
        return listaAux;
    }

    private Lista listarNivelesAux(){
        //uso una cola para recorrer el arbol
        Lista listaN = new Lista();
        Cola aux = new Cola();
        aux.poner(this.raiz);
        
        while(!aux.esVacia()){
            NodoGen nodo = (NodoGen) aux.obtenerFrente();
            aux.sacar();
            listaN.insertar(nodo.getElem(), listaN.longitud() + 1);
            nodo = nodo.getHijoIzquierdo();
            while(nodo != null){
                aux.poner(nodo);
                nodo = nodo.getHermanoDerecho();
            }
        }
        return listaN;
    }

    public String toString() {
        return toStringAux(this.raiz);
    }

    private String toStringAux(NodoGen nodo) {
        String s = "";
        if (nodo != null) {
            //visita del nodo
            s += nodo.getElem().toString() + " -> ";
            NodoGen hijo = nodo.getHijoIzquierdo();
            while (hijo != null) {
                s += hijo.getElem().toString() + ", ";
                hijo = hijo.getHermanoDerecho();
            }
            //comienza recorrido de los hijos de n llamando recursivamente
            // para que cada hijo agregue su subcadena a la general
            hijo = nodo.getHijoIzquierdo();
            while (hijo != null) {
                s += "\n" + toStringAux(hijo);
                hijo = hijo.getHermanoDerecho();
            }
        }
        return s;
    }

    public ArbolGen clone() {
        //Si la raiz no es null llama al metodo privado para crear un clon del arbol
        ArbolGen clon = new ArbolGen();
        if (this.raiz != null) {
            NodoGen raiz = new NodoGen(this.raiz.getElem(),null,null);
            clon.raiz = raiz;
            cloneAux(clon.raiz,this.raiz);
        }

        return clon;
    }

       private void cloneAux(NodoGen clon,NodoGen original){
       //Recorre los nodos izquierdos creando un nuevo nodo y asignandolo
        if (original.getHijoIzquierdo()!=null) {
            NodoGen nuevoEnlace = new NodoGen(original.getHijoIzquierdo().getElem(),null,null);
            clon.setHijoIzquierdo(nuevoEnlace);
            cloneAux(clon.getHijoIzquierdo(),original.getHijoIzquierdo());
        } 
        //Recorre los nodos derechos creando un nuevo nodo y asignandolo

        if (original.getHermanoDerecho()!=null) {
            NodoGen nuevoEnlaceAux= new NodoGen(original.getHermanoDerecho().getElem(),null,null);
            clon.setHermanoDerecho(nuevoEnlaceAux);
            cloneAux(clon.getHermanoDerecho(),original.getHermanoDerecho());
        }
    }

    public void vaciar() {
        //Metodo para vacia el arbol
        this.raiz = null;
    }

    //Extension para la reentrega 
    //Ejercicio Frontera
    
    public Lista frontera(){
    Lista aux = new Lista();
        if (!this.esVacio()) {
           fronteraAux(this.raiz,aux);
        }
        return aux;
    }
    private void fronteraAux(NodoGen nodo,Lista aux){
        //Este metodo es privado por que opera con NodoGen dentro de la estructura
        //almacena en una lista los nodos hoja que crean una frontera
        if (nodo!=null) {
            if (nodo.getHijoIzquierdo()==null) {
                aux.insertar(nodo.getElem(),aux.longitud()+1);
            }else{fronteraAux(nodo.getHijoIzquierdo(),aux);
            }
            fronteraAux(nodo.getHermanoDerecho(),aux);
        }
    
    }
}
