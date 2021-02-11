/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;

import jerarquicas.NodoArbol;
import lineales.dinamicas.Lista;

/**
 *
 * @author Walter
 */
public class ArbolBin {

    //Atributos
    private NodoArbol raiz;

    //Constructor 
    public ArbolBin() {
        this.raiz = null;
    }

    public boolean insertar(Object elemNuevo, Object elemPadre, char lugar) {
        //inserta el elemNuevo como hijo del primer nodo encontrado en PREORDEN
        //iguala a elemPadre, como hijo izq(I) o der(D), segun lo indique el parametro lugar
        boolean exito = true;
        if (this.raiz == null) {
            //si el arbol esta vacio, ponemos el elem nuevo en la raiz
            this.raiz = new NodoArbol(elemNuevo, null, null);
        } else {
            //si no esta vacio, se busca al padre
            NodoArbol nodoPadre = obtenerNodo(this.raiz, elemPadre);
            if (nodoPadre != null) {
                if (lugar == 'I' && nodoPadre.getIzquierdo() == null) {
                    //si el padre existe y no tiene HI se lo agrega
                    nodoPadre.setIzquierdo(new NodoArbol(elemNuevo, null, null));
                } else {
                    if (lugar == 'D' && nodoPadre.getDerecho() == null) {
                        //si el padre existe y no tiene HD se lo agrega
                        nodoPadre.setDerecho(new NodoArbol(elemNuevo, null, null));
                    } else {
                        //si el padre no existe o ya tiene a ese hijo da error
                        exito = false;
                    }

                }
            } else {
                exito = false;
            }
        }
        return exito;
    }

    private NodoArbol obtenerNodo(NodoArbol n, Object buscado) {
        //Motodo privado que busca un elemento y devuelve el nodo que lo contiene.
        //Si no se encuentra buscado devuelve null.

        NodoArbol resultado = null;
        if (n != null) {
            if (n.getElem().equals(buscado)) {
                //si el buscado es n, lo devuelve
                resultado = n;
            } else {
                //no es el buscado: busca primero en el HI               
                resultado = obtenerNodo(n.getIzquierdo(), buscado);

                //si no lo encuetra en el HI, busca en HD
                if (resultado == null) {
                    resultado = obtenerNodo(n.getDerecho(), buscado);
                }
            }
        }
        return resultado;
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

    private Object obtenerPadre(NodoArbol nodo, Object hijo) {
        //Metodo privado para obtener el elemento del nodo padre
        Object padre = null;
        if (padre == null) {
            if (nodo.getIzquierdo() != null) {
                if (nodo.getIzquierdo().getElem().equals(hijo)) {
                    padre = nodo.getElem();
                }
                if (padre == null) {
                    //Llamado recursivo con el Hijo Izquierdo
                    padre = obtenerPadre(nodo.getIzquierdo(), hijo);
                }

            }
            if (padre == null) {
                if (nodo.getDerecho() != null) {
                    if (nodo.getDerecho().getElem().equals(hijo)) {
                        padre = nodo.getElem();
                    }
                    if (padre == null) {
                        //Llamado recursivo con el Hijo Derecho
                        padre = obtenerPadre(nodo.getDerecho(), hijo);
                    }
                }
            }

        }
        return padre;
    }

    public boolean esVacio() {
        //Metodo para verificar si el arbol esta vacio
        boolean valor = false;
        if (this.raiz == null) {
            valor = true;
        }
        return valor;
    }

    public int altura() {
        //Metodo para obtener la altura del arbol
        int laAltura;
        laAltura = obtenerAltura(this.raiz);
        return laAltura;
    }

    private int obtenerAltura(NodoArbol nodo) {
        //Metodo privado ya que se opera con nodos del arbol
        int alturaIzq = 0, alturaDer = 0;
        if (nodo != null) {
            //Llamados recursivos
            alturaIzq += obtenerAltura(nodo.getIzquierdo()) + 1;
            alturaDer += obtenerAltura(nodo.getDerecho()) + 1;
            if (alturaIzq > alturaDer) {
                alturaDer = alturaIzq;
            }
        } else {
            alturaDer = -1;
        }
        return alturaDer;

    }

    public int nivel(Object elem) {
        //Si la raiz no es nula, obtiene el nivel llamando al metodo privado
        int cont = -1;
        if (this.raiz != null) {
            cont = obtenerNivel(this.raiz, elem, cont);
        }
        return cont;
    }

    private int obtenerNivel(NodoArbol nodo, Object elem, int cont) {
        //Metodo privado ya que opera con nodos del arbol
        int nivelElem = -1;
        if (nodo != null) {
            cont = cont + 1;
            if (nodo.getElem().equals(elem)) {
                nivelElem = cont;
            } else {
                //Llamados recursivos
                nivelElem = obtenerNivel(nodo.getIzquierdo(), elem, cont);
                if (nivelElem == -1) {
                    nivelElem = obtenerNivel(nodo.getDerecho(), elem, cont);
                }
            }
        }
        return nivelElem;
    }

    public void vaciar() {
        //Al asignar la raiz null el GarageCollector de java nos permite vaciar el arbol
        this.raiz = null;
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

    private Lista preordenAux(NodoArbol nodo, Lista listaAux) {
        //metodo recursivo es Privado por que su parametro es de tipo NodoArbol
        if (nodo != null) {
            //visita el elemento en el nodo
            listaAux.insertar(nodo.getElem(), listaAux.longitud() + 1);//(1)

            //recorre a sus hijos en preorden
            preordenAux(nodo.getIzquierdo(), listaAux);//(2)
            preordenAux(nodo.getDerecho(), listaAux);//(3)
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

    private Lista inorden(NodoArbol nodo, Lista listaAux) {
        //Metodo recursivo es Privado por que su parametro es tipo NodoArbol
        //recorre todos los hijos izquierdos
        if (nodo.getIzquierdo() != null) {
            inorden(nodo.getIzquierdo(), listaAux);
        }
        //almacena el elemento
        listaAux.insertar(nodo.getElem(), listaAux.longitud() + 1);
        //Recorre todos los hijos derechos a la vuelta del hijo izquierdo
        if (nodo.getDerecho() != null) {
            inorden(nodo.getDerecho(), listaAux);
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

    private Lista posorden(NodoArbol nodo, Lista listaAux) {
        //Metodo recursivo es Privado por que su parametro es tipo NodoArbol
        //recorre todos los hijos izquierdos
        if (nodo.getIzquierdo() != null) {
            posorden(nodo.getIzquierdo(), listaAux);
        }

        //Recorre todos los hijos derechos a la vuelta del hijo izquierdo
        if (nodo.getDerecho() != null) {
            posorden(nodo.getDerecho(), listaAux);
        }
        //Almacena el elemento
        listaAux.insertar(nodo.getElem(), listaAux.longitud() + 1);
        return listaAux;
    }

    public Lista listarNiveles() {
        //imprime los elementos por pantalla en posorden
        //invoca a un mmetodo recursivo privado a la clase Niveles
        Lista listaAux = new Lista();
        niveles(this.raiz, listaAux);
        return listaAux;
    }

    private void niveles(NodoArbol nodo, Lista listaAux) {
        //imprime la raiz
        if(!esVacio()){
        if (nodo == this.raiz) {
            listaAux.insertar(nodo.getElem(), listaAux.longitud()+1);
        }
        //Imprime los hijos
        if (nodo.getIzquierdo() != null) {
            listaAux.insertar(nodo.getIzquierdo().getElem(), listaAux.longitud()+1);
        }
        if (nodo.getDerecho() != null) {
            listaAux.insertar(nodo.getDerecho().getElem(), listaAux.longitud()+1);
        }//crea los sub arboles
        if (nodo.getIzquierdo() != null) {
            niveles(nodo.getIzquierdo(), listaAux);
        }
        if (nodo.getDerecho() != null) {
            niveles(nodo.getDerecho(), listaAux);
        }}
    }

    public String toString() {
        String aux;
        aux = preordenString(this.raiz);
        return aux;

    }

    private String preordenString(NodoArbol nodo) {
        //Retorna una cadena con los nodos y sus respectivos hijos izquierdos y derechos
        String total = "";
        if (nodo != null) {
            total = total + nodo.getElem() + "\t";
            if (nodo.getIzquierdo() != null) {
                total = "\t" + "\t" + "\t" + total + "HI=" + nodo.getIzquierdo().getElem() + "\t";
            } else {
                total = "\t" + "\t" + "\t" + total + "HI= - " + "\t";
            }
            if (nodo.getDerecho() != null) {
                total = "\t" + "\t" + "\t" + total + "HD=" + nodo.getDerecho().getElem() + "\n";
            } else {
                total = "\t" + "\t" + "\t" + total + "HD= - " + "\n";
            }
            total += preordenString(nodo.getIzquierdo());
            total += preordenString(nodo.getDerecho());
        }

        return total;
    }

    public ArbolBin clone() {
        //Si la raiz no es null llama al metodo privado para crear un clon del arbol
        ArbolBin clone = new ArbolBin();        
        if (this.raiz != null) {
            NodoArbol aux = new NodoArbol(this.raiz.getElem(),null,null);
            clone.raiz = aux;
            cloneAux(clone.raiz,this.raiz);
        }

        return clone;
    }

     private void cloneAux(NodoArbol clon,NodoArbol original){
       //Recorre los nodos izquierdos creando un nuevo nodo y asignandolo
        if (original.getIzquierdo()!=null) {
            NodoArbol nuevoEnlace= new NodoArbol(original.getIzquierdo().getElem(),null,null);
            clon.setIzquierdo(nuevoEnlace);
            cloneAux(clon.getIzquierdo(),original.getIzquierdo());
        } 
        //Recorre los nodos derechos creando un nuevo nodo y asignandolo

        if (original.getDerecho()!=null) {
            NodoArbol nuevoEnlaceAux= new NodoArbol(original.getDerecho().getElem(),null,null);
            clon.setDerecho(nuevoEnlaceAux);
            cloneAux(clon.getDerecho(),original.getDerecho());
        }
    }
    
    public Lista obtenerAncestro(Object elem){
    Lista ancestro= new Lista();
        if (!esVacio()) {
            obtenerAncestroAux(this.raiz,elem,ancestro);
        }
        return ancestro;
    }

        private boolean obtenerAncestroAux(NodoArbol n, Object buscado,Lista ancestros) {
        //Motodo privado que busca un elemento y devuelve el nodo que lo contiene.
        //Si no se encuentra buscado devuelve null.
        boolean aux=false;
        if (n != null) {
            if (n.getElem().equals(buscado)) {
                //si el buscado es n termina el llamado recursivo
                aux=true;
            } else {
                //deciendo al subArbol izquierdo               
               aux = obtenerAncestroAux(n.getIzquierdo(), buscado,ancestros);
                if (aux) {
                       ancestros.insertar(n.getElem(), ancestros.longitud()+1); 
                    }
                //Deciendo al subArbol derecho
                if (!aux) {
                aux = obtenerAncestroAux(n.getDerecho(), buscado,ancestros);
                    if (aux) {
                       ancestros.insertar(n.getElem(), ancestros.longitud()+1); 
                    }
                }                
            }        
        }           
        return aux;
        }
}
