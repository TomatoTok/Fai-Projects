/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;

import jerarquicas.NodoArbol;
import lineales.dinamicas.Lista;

/**
 *
 * @author Walter
 */
public class ArbolBinarioBusqueda {

    private NodoABB raiz;
    
    public ArbolBinarioBusqueda(){
    this.raiz=null;
    }

    public boolean insertar(Comparable elemento) {
        boolean exito = true;
        if (this.raiz == null) {
            this.raiz = new NodoABB(elemento, null, null);
        } else {
            exito = insertarAux(this.raiz, elemento);
        }
        return exito;
    }

    private boolean insertarAux(NodoABB n, Comparable elem) {
        //precondicion: n no es nulo
        boolean exito = true;
        if (elem.compareTo(n.getElem()) == 0) {
            //Reportar error: elemento repetido
            exito = false;

        } else if (elem.compareTo(n.getElem()) < 0) {
            //elemento es menor que el elemento del nodo
            //si tine HI baja a la izq, sino agrega elemento
            if (n.getIzquierdo() != null) {
                exito = insertarAux(n.getIzquierdo(), elem);
            } else {
                n.setIzquierdo(new NodoABB(elem, null, null));
            }
        } else // elemento es mayor que el elemento del nodo
        //si tiene HD baja a la derecha, sino agrega el elemento
        if (n.getDerecho() != null) {
            exito = insertarAux(n.getDerecho(), elem);
        } else {
            n.setDerecho(new NodoABB(elem, null, null));
        }
        return exito;
    }

    public Lista listar() {
        //imprime los elementos por pantalla en inorden
        //invoca a un metodo recursivo privado a la clase
        Lista listaAux = new Lista();
        if (this.raiz != null) {
            listaAux = listarAux(this.raiz, listaAux);
        }
        return listaAux;
    }

    private Lista listarAux(NodoABB nodo, Lista listaAux) {
        //Metodo recursivo es Privado por que su parametro es tipo NodoArbol
        //recorre todos los hijos izquierdos
        if (nodo.getIzquierdo() != null) {
            listarAux(nodo.getIzquierdo(), listaAux);
        }
        //almacena el elemento
        listaAux.insertar(nodo.getElem(), listaAux.longitud() + 1);
        //Recorre todos los hijos derechos a la vuelta del hijo izquierdo
        if (nodo.getDerecho() != null) {
            listarAux(nodo.getDerecho(), listaAux);
        }
        return listaAux;
    }

    public Lista listarRango(Comparable elemMin, Comparable elemMax) {
        //imprime los elementos por pantalla en inorden
        //invoca a un metodo recursivo privado a la clase
        Lista listaAux = new Lista();
        if (this.raiz != null) {
            listaAux = listarRangoAux(this.raiz, listaAux, elemMin, elemMax);
        }
        return listaAux;
    }

    private Lista listarRangoAux(NodoABB nodo, Lista listaAux, Comparable elemMin, Comparable elemMax) {
        //Metodo recursivo es Privado por que su parametro es tipo NodoArbol
        //recorre todos los hijos izquierdos siempre que sea mayor al elemento minimo, 
        while ((int) elemMin < (int) nodo.getElem() && (int) nodo.getElem() < (int) elemMax) {
            if (nodo.getIzquierdo() != null) {
                listarRangoAux(nodo.getIzquierdo(), listaAux, elemMin, elemMax);
            }
            //almacena el elemento
            listaAux.insertar(nodo.getElem(), listaAux.longitud() + 1);
            //Recorre todos los hijos derechos a la vuelta del hijo izquierdo
            if (nodo.getDerecho() != null) {
                listarRangoAux(nodo.getDerecho(), listaAux, elemMin, elemMax);
            }
        }
        return listaAux;
    }

    public Comparable minimoElem() {
        return minimoElemAux(this.raiz);
    }

    private Comparable minimoElemAux(NodoABB nodo) {
        Comparable aux = null;
        
        if (nodo.getIzquierdo().getElem() != null) {
            aux = minimoElemAux(nodo.getIzquierdo());
        } else {
            aux = nodo.getElem();
        }
        return aux;
    }

    public Comparable maximoElem() {
        return maximoElemAux(this.raiz);
    }

    private Comparable maximoElemAux(NodoABB nodo) {
        Comparable aux = null;
        if (nodo.getIzquierdo().getElem() != null) {
            aux = maximoElemAux(nodo.getIzquierdo());
        } else {
            aux = nodo.getElem();
        }
        return aux;
    }

    public boolean esVacio() {
        boolean aux = true;
        if (this.raiz != null) {
            aux = true;
        }
        return aux;
    }
    
    public boolean pertenece(Comparable elem){
    return perteneceAux(elem,this.raiz);
    }
    
    private boolean perteneceAux(Comparable elem, NodoABB nodo){
    boolean exito=false;
        if (nodo.getElem().compareTo(elem)==0) {
            exito=true;
        }else{
            if (nodo!=null) {
                if (elem.compareTo(nodo.getElem())<0) {
                    exito=perteneceAux(elem,nodo.getIzquierdo());
                }
                if(elem.compareTo(nodo.getElem())>0){
                    exito=perteneceAux(elem,nodo.getDerecho());
                }
            }
        }
        return exito;
    }
    
    public boolean eliminar(Comparable elem){
    return eliminarAux(elem,this.raiz);
    }
    private boolean eliminarAux(Comparable elem,NodoABB nodo){
    boolean exito=false;
        if (this.raiz.getElem().compareTo(elem)==0) {
            //Primero revisa si la raiz es el elemento a eliminar
           // eliminarRaiz();
            exito=true;
        }
        //Luego revisa si alguno de sus hijos contiene el elemento a eliminar
        if (elem.compareTo(nodo.getIzquierdo().getElem())==0) {
            verificarCaso(nodo,'I');
            exito=true;
        }
        if (elem.compareTo(nodo.getDerecho().getElem())==0) {
            verificarCaso(nodo,'D');
            exito=true;
        }
        //Si el elemento no se ha encontrado aun se hace el llamado recursivo por los subArboles
        if (elem.compareTo(nodo.getElem())<0) {
            eliminarAux(elem,nodo.getIzquierdo());
        }
        if (elem.compareTo(nodo.getElem())>0) {
            eliminarAux(elem,nodo.getDerecho());
        }
        return exito;
    }
    private void verificarCaso(NodoABB padre, char pos){
    NodoABB hijo;
    //Almacena el valor del hijo dependiendo de la posicion enviada por parametro
        if (pos=='I') {hijo=padre.getIzquierdo();}
        else{hijo=padre.getDerecho();}
        
        //Si el hijo es hoja
        if (hijo.getIzquierdo() == null && hijo.getDerecho()==null) {
            if (pos=='I') {padre.setIzquierdo(null);}
            else{padre.setDerecho(null);}
        }
        //Si el hijo tiene subArboles izquierdos enlazados
        if (hijo.getIzquierdo()!= null && hijo.getDerecho()==null) {
            if (pos=='I') {padre.setIzquierdo(hijo.getIzquierdo());}
            else{padre.setDerecho(hijo.getIzquierdo());}
        }
        //Si el hijo tiene subArboles derechos enlazados
        if (hijo.getIzquierdo()== null && hijo.getDerecho()!=null) {
            if (pos=='D') {padre.setIzquierdo(hijo.getDerecho());}
            else{padre.setDerecho(hijo.getDerecho());}
        }
    }
}
