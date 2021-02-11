/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;

import lineales.dinamicas.Lista;

/**
 *
 * @author Walter
 */
public class ArbolAVL {

    private NodoAVL raiz;

    public ArbolAVL() {
        this.raiz = null;
    }

    public boolean insertar(Comparable elemento) {
        boolean exito;
        exito = insertarAux(this.raiz, elemento);
        return exito;
    }

    private boolean insertarAux(NodoAVL nodo, Comparable elem) {
        boolean exito = true;
        //Caso de la raiz
        if (this.raiz == null) {
            NodoAVL nuevo = new NodoAVL(elem, null, null);
            this.raiz = nuevo;
            this.raiz.recalcularAltura();
        } else {
            if (nodo != null) {
                //Si el elemento es mas chico que el elemento del nodo entonces se mueve a la izquierda
                if (nodo.getElem().compareTo(elem) > 0) {
                    if (nodo.getIzquierdo() != null) {
                        //Si el elemento del hijo izquierdo es igual al elemento a insertar da error
                        if (nodo.getIzquierdo().getElem() == elem) {
                            exito = false;
                        } else {
                            //sino hace el llamado recursivo moviendose a la izquierda
                            insertarAux(nodo.getIzquierdo(), elem);
                            //actualizo la altura del nodo y calculo el balance de sus hijos
                            nodo.recalcularAltura();
                            calcularBalance(nodo, nodo.getIzquierdo(), 'I');
                        }
                    } else { // Si el nodo izquierdo es nulo, entonces se asigna el nuevo enlace
                        NodoAVL nuevo = new NodoAVL(elem, null, null);
                        nodo.setIzquierdo(nuevo);
                        nodo.recalcularAltura();
                    }
                } else {
                    //Si el elemento es mas grande que el elemento del nodo entonces se mueve a la derecha    
                    if (nodo.getElem().compareTo(elem) < 0) {
                        if (nodo.getDerecho() != null) {
                            //Si el elemento del hijo derecho es igual al elemento a insertar da error
                            if (nodo.getDerecho().getElem() == elem) {
                                exito = false;
                            } else {
                                //Sino hace el llamado recursivo moviendose a la derecha
                                insertarAux(nodo.getDerecho(), elem);
                                //actualizo la altura del nodo y calculo el balance de sus hijos
                                nodo.recalcularAltura();
                                calcularBalance(nodo, nodo.getDerecho(), 'D');
                            }
                        } else {//si el nodo derecho es nulo, entonces se asigna el nuevo enlace 
                            NodoAVL nuevo = new NodoAVL(elem, null, null);
                            nodo.setDerecho(nuevo);
                            nodo.recalcularAltura();
                        }
                    }
                }
            }
        }
        return exito;
    }

    private NodoAVL rotarIzquierda(NodoAVL r) {
        NodoAVL hijoDerecho, temp;
        //pivot
        hijoDerecho = r.getDerecho();
        temp = hijoDerecho.getIzquierdo();
        hijoDerecho.setIzquierdo(r);
        r.setDerecho(temp);
        //recalculo sus alturas
        r.recalcularAltura();;
        hijoDerecho.recalcularAltura();
        return hijoDerecho;
    }

    private NodoAVL rotarDerecha(NodoAVL r) {
        NodoAVL hijoIzquierdo, temp;
        hijoIzquierdo = r.getIzquierdo();
        temp = hijoIzquierdo.getDerecho();
        hijoIzquierdo.setDerecho(r);
        r.setIzquierdo(temp);
        //recalculo sus alturas
        r.recalcularAltura();
        hijoIzquierdo.recalcularAltura();
        return hijoIzquierdo;
    }

    private void calcularBalance(NodoAVL padre, NodoAVL hijo, char pos) {

        int balH = balance(hijo), balP = balance(padre), balSubH = 0;
        //si el hijo tiene rama izquierda o derecha y su balance es de signo contrario al balance del padre
        //puede que sea rotacion doble, por lo tanto verifico
        if (hijo != null) {
            if (hijo.getIzquierdo() != null && hijo.getDerecho() == null) {
            balSubH = balance(hijo.getIzquierdo());
            } else {
                    if (hijo.getIzquierdo() == null && hijo.getDerecho() != null) {
                      balSubH = balance(hijo.getDerecho());
                   }
        }
        }
        if ((balH == 2 && balSubH == -1) || (balH == -2 && balSubH == 1)) {
            //es Rotacion Doble
            rotacionDoble(padre, hijo, pos, balH, balSubH);
        } else {
            if ((padre == this.raiz && this.raiz.getIzquierdo()==null) || (padre == this.raiz && this.raiz.getDerecho() == null)){
                //Caso de raiz
                rotacionRaiz(padre, hijo, balP, balH);
            } else {
                //Rotacion simple
                rotacionSimple(padre, hijo, pos, balH);
            }
        }
    }

    private void rotacionRaiz(NodoAVL padre, NodoAVL hijo, int balP, int balH) {
        if (balP == -2 && balH == 1) {
            //Rotacion doble Derecha-Izquierda
            padre.setDerecho(rotarDerecha(hijo));
            padre.recalcularAltura();
            this.raiz = rotarIzquierda(this.raiz);
            this.raiz.recalcularAltura();
        } else {
            if (balP == 2 && balH == -1) {
                //Rotacion doble Izquierda-Derecha
                padre.setIzquierdo(rotarIzquierda(hijo));
                padre.recalcularAltura();
                this.raiz = rotarDerecha(this.raiz);
                this.raiz.recalcularAltura();
            } else {
                //Rotacion simple
                if (padre == this.raiz) {
                    //si el balance es mayor a 1 el arbol esta caido hacia la izquierda
                    if (balP > 1) {
                        this.raiz = rotarDerecha(this.raiz);
                        this.raiz.recalcularAltura();
                    } else {
                        //si el balance es menor a -1 el arbol esta caido hacia la derecha
                        if (balP < -1) {
                            this.raiz = rotarIzquierda(this.raiz);
                            this.raiz.recalcularAltura();
                        }
                    }
                }

            }
        }
    }

    private void rotacionSimple(NodoAVL padre, NodoAVL hijo, char pos, int balH) {
        //Caso hijo desnivelado, al padre se el asigna la rotacion aplicada al hijo            
        //si el balance es mayor a 1 el arbol esta caido hacia la izquierda
        if (balH > 1) {
            if (pos == 'D') {
                padre.setDerecho(rotarDerecha(hijo));
                padre.recalcularAltura();
            } else {
                padre.setIzquierdo(rotarDerecha(hijo));
                padre.recalcularAltura();
            }
        } else {
            //si el balance es menor a -1 el arbol esta caido hacia la derecha
            if (balH < -1) {
                if (pos == 'D') {
                    padre.setDerecho(rotarIzquierda(hijo));
                    padre.recalcularAltura();
                } else {
                    padre.setIzquierdo(rotarIzquierda(hijo));
                    padre.recalcularAltura();
                }
            }
        }
    }

    private void rotacionDoble(NodoAVL padre, NodoAVL hijo, char pos, int balH, int balSubH) {
        //Envio los enteros balH y balP para no volver a calcularlos
        if (balH == -2 && balSubH == 1) {
            //Rotacion doble Derecha - Izquierda
            hijo.setDerecho(rotarDerecha(hijo.getDerecho()));
            hijo.recalcularAltura();
            if (pos == 'I') {
                padre.setIzquierdo(rotarIzquierda(hijo));
                padre.recalcularAltura();
            } else {
                padre.setDerecho(rotarIzquierda(hijo));
                padre.recalcularAltura();
            }
        } else {
            if (balH == 2 && balSubH == -1) {
                //Rotacion doble Izquierda - Derecha
                hijo.setIzquierdo(rotarIzquierda(hijo.getIzquierdo()));
                hijo.recalcularAltura();
                if (pos == 'I') {
                    padre.setIzquierdo(rotarDerecha(hijo));
                    padre.recalcularAltura();
                } else {
                    padre.setDerecho(rotarDerecha(hijo));
                    padre.recalcularAltura();
                }
            }
        }
    }

    private int balance(NodoAVL nodo) {
        int altIzq = -1, altDer = -1, aux=0;
        if (nodo != null) {
           if (nodo.getIzquierdo() != null) {
            altIzq = nodo.getIzquierdo().getAltura();
            }
            if (nodo.getDerecho() != null) {
            altDer = nodo.getDerecho().getAltura();
            }
            aux = altIzq - altDer; 
        }
        return aux;
    }

    public boolean eliminar(Comparable elem) {
        boolean existe = false;
        if (this.raiz != null) {
            existe = eliminarAux(elem, this.raiz);
        }
        return existe;
    }

    private boolean eliminarAux(Comparable elem, NodoAVL nodo) {
        boolean exito = false;
        //Mientras el nodo no sea nulo
        if (nodo != null) {
            //  Primero revisa si la raiz es el elemento a eliminar
            if (this.raiz.getElem().compareTo(elem) == 0) {
                verificarCaso(this.raiz, 'R');
                exito = true;
            } else {
                //Luego revisa si alguno de sus hijos contiene el elemento a eliminar
                if (nodo.getIzquierdo() != null) {
                    if (elem.compareTo(nodo.getIzquierdo().getElem()) == 0) {
                        verificarCaso(nodo, 'I');
                        exito = true;
                    }
                }
                if (nodo.getDerecho() != null) {
                    if (elem.compareTo(nodo.getDerecho().getElem()) == 0) {
                        verificarCaso(nodo, 'D');
                        exito = true;
                    }
                }
            }
            //Si el elemento no se ha encontrado aun, se hace el llamado recursivo por los subArboles
            if (!exito) {
                if (elem.compareTo(nodo.getElem()) < 0) {
                    eliminarAux(elem, nodo.getIzquierdo());
                }
                if (elem.compareTo(nodo.getElem()) > 0) {
                    eliminarAux(elem, nodo.getDerecho());
                }
            }
        }
        return exito;
    }

    private void verificarCaso(NodoAVL padre, char pos) {
        NodoAVL hijo = null;
        if (pos == 'R') {
//      vemos el caso de la raiz
            if (this.raiz.getIzquierdo() == null && this.raiz.getDerecho() == null) {
                eliminarCaso1(this.raiz, pos);
            } else {
                if (this.raiz.getIzquierdo() != null && this.raiz.getDerecho() != null) {
                    eliminarCaso3(this.raiz, null, pos);
                } else {
                    eliminarCaso2(this.raiz, hijo, pos);
                }
            }
        } else {
//      en caso de sub arbol
            if (pos == 'I') {
                hijo = padre.getIzquierdo();
            } else {
                if (pos == 'D') {
                    hijo = padre.getDerecho();
                }
            }
            if (padre != this.raiz && hijo == null) {
//          es hoja, caso 1
                eliminarCaso1(padre, pos);
            } else {
                if (hijo.getIzquierdo() != null && hijo.getDerecho() != null) {
//          el nodo tiene ambos hijos, caso 3
                    eliminarCaso3(padre, hijo, pos);
                    ladoBalance(padre,pos);
                } else {
//          tiene solo un hijo, caso 2
                    eliminarCaso2(padre, hijo, pos);
                    ladoBalance(padre,pos);
                }
            }
        }
    }
    
    private void ladoBalance(NodoAVL padre, char pos){
        if (pos == 'D') {
        calcularBalance(padre,padre.getDerecho(),'D');
        }else{calcularBalance(padre,padre.getIzquierdo(),'I');
}
    }

    private void eliminarCaso1(NodoAVL padre, char pos) {
        //Elimina la hoja dependiendo de la posicion en que se encuente con respecto al padre
        if (pos == 'I') {
            padre.setIzquierdo(null);
            padre.recalcularAltura();
        } else {
            if (pos == 'D') {
                padre.setDerecho(null);
                padre.recalcularAltura();
            } else {
                //En caso de ser raiz no posee una posicion con respecto a un padre
                //Por lo cual este se le asigna el valor null
                this.raiz = null;
            }
        }
    }
    
    private void eliminarCaso2(NodoAVL padre, NodoAVL hijo, char pos) {
        //Si el nodo a eliminar es la raiz
        if (pos == 'R') {
            if (this.raiz.getIzquierdo() != null) {
                this.raiz = this.raiz.getIzquierdo();
                this.raiz.recalcularAltura();
            } else {
                this.raiz = this.raiz.getDerecho();
                this.raiz.recalcularAltura();
            }
        } else {
            //Si el nodo a eliminar(hijo) tiene un nodo izquierdo su padre
            //se enlaza con su nodo izquierdo eliminandolo    
            if (hijo.getIzquierdo() != null) {
                if (pos == 'I') {
                    padre.setIzquierdo(hijo.getIzquierdo());
                    padre.recalcularAltura();
                } else {
                    padre.setDerecho(hijo.getIzquierdo());
                    padre.recalcularAltura();
                }
            } else {
                //Si el nodo a eliminar(hijo) tiene un nodo derecho su padre
                //se enlaza con su nodo derecho eliminandolo
                if (pos == 'D') {
                    padre.setDerecho(hijo.getDerecho());
                    padre.recalcularAltura();
                } else {
                    padre.setIzquierdo(hijo.getDerecho());
                    padre.recalcularAltura();
                }
            }
        }
    }

    private void eliminarCaso3(NodoAVL padre, NodoAVL hijo, char pos) {
        NodoAVL candidato = new NodoAVL(null, null, null);
        if (hijo == null) {
//      Esta condicion se da en el caso de la Raiz ya que se envia a la raiz por el Padre
            candidato = mejorCandidato(padre);
            if (padre.getIzquierdo() != null) {
                    candidato.setIzquierdo(padre.getIzquierdo());
            }
            if (padre.getDerecho() != null) {
                    candidato.setDerecho(padre.getDerecho());
            }
            //ahora superpongo el candidato por el nodo que quiero eliminar
            this.raiz = candidato;
        } else {
//      Caso contrario se envia al hijo que es al que se quiere eliminar
            candidato = mejorCandidato(hijo);
//      Luego al candidato le asigno los subarboles del nodo a eliminar
            if (hijo.getIzquierdo() != null) {
                if (hijo.getIzquierdo().getElem() != candidato.getElem()) {
                    candidato.setIzquierdo(hijo.getIzquierdo());
                }

            }
            if (hijo.getDerecho() != null) {
                if (hijo.getDerecho().getElem() != candidato.getElem()) {
                    candidato.setDerecho(hijo.getDerecho());
                }
            }
            //ahora superpongo el candidato por el hijo que es al que quiero eliminar
            if (pos == 'D') {
                padre.setDerecho(candidato);
            } else {
                padre.setIzquierdo(candidato);
            }
        }
    }

    private NodoAVL mejorCandidato(NodoAVL hijo) {
        NodoAVL padre = hijo, aux, candidato = new NodoAVL(null, null, null);
        aux = hijo.getIzquierdo();
        while (aux != null) {
            padre = aux;
            //Con esto obtengo el padre para eliminar el candidato
            if (aux.getDerecho() != null) {
                if (aux.getDerecho().getDerecho()== null) {
                    candidato.setElem(aux.getDerecho().getElem());
                    aux = null;
                }else{
                    aux = aux.getDerecho();}
            }else {candidato.setElem(aux.getElem());
                    aux = null;
                }
        }
        //  Si tiene hijos derechos asigna el valor del nodo a eliminar al candidato y luego se elimina
        if (candidato.getElem() == hijo.getIzquierdo().getElem()) {
            candidato.setElem(padre.getElem());
            verificarCaso(hijo, 'I');
        } else {
            //  Si no tiene hijos derechos al candidato se le asigna el valor del nodo a eliminar y luego se elimina
            verificarCaso(padre, 'D');
        }
        return candidato;
    }

    public Lista listarRango(Comparable elemMin, Comparable elemMax) {
//      imprime los elementos por pantalla en inorden
//      invoca a un metodo recursivo privado a la clase
        Lista listaAux = new Lista();
        boolean aux1 = true;
        if (this.raiz != null) {
            listaAux = listarRangoAux(this.raiz, listaAux, elemMin, elemMax, aux1);
        }
        return listaAux;
    }

    private Lista listarRangoAux(NodoAVL nodo, Lista listaAux, Comparable elemMin, Comparable elemMax, boolean aux1) {
//        Metodo recursivo es Privado por que su parametro es tipo NodoABB
//        recorre todos los hijos izquierdos 
//        El condicional aux limita que se recorra el arbol completo
        if (aux1) {
//            recorre los hijos izquierdos
            if (nodo.getIzquierdo() != null) {
                aux1 = (elemMin.compareTo(nodo.getElem()) <= 0);
                listarRangoAux(nodo.getIzquierdo(), listaAux, elemMin, elemMax, aux1);
            }
//            almacena el elemento dentro del rango establecido
            if (nodo.getElem().compareTo(elemMin) >= 0 && nodo.getElem().compareTo(elemMax) <= 0) {
                listaAux.insertar(nodo.getElem(), listaAux.longitud() + 1);
            }

//            Recorre todos los hijos derechos            
            if (nodo.getDerecho() != null) {
                aux1 = (elemMax.compareTo(nodo.getElem()) >= 0);
                listarRangoAux(nodo.getDerecho(), listaAux, elemMin, elemMax, aux1);

            }
        }

        return listaAux;
    }
    
    public Comparable elemMinimo(){
        Comparable valor=null;
        if (this.raiz!=null) {
            valor = elemMinimoAux(this.raiz);
        }
        return valor;
    }
    private Comparable elemMinimoAux(NodoAVL nodo){
    Comparable valor= nodo.getElem();
    NodoAVL aux=nodo;
    while(aux!=null){
    valor=aux.getElem();
        if (aux.getIzquierdo() != null) {
            //Recorre todos los nodos izquierdos para encontrar el menor de los elementos
            aux=aux.getIzquierdo();
        }else{aux=null;
        }        
    }
    return valor;
    }
    
    public Comparable elemMaximo(){
    Comparable valor = null;
        if (this.raiz != null) {
            valor = elemMaximoAux(this.raiz);
        }
        return valor;
    }
    private Comparable elemMaximoAux(NodoAVL nodo){
    Comparable valor = null;
    NodoAVL aux = nodo;
    while(aux!=null){
    valor= aux.getElem();
        if (aux.getDerecho()!=null) {
            aux=aux.getDerecho();
        }else{
        aux=null;
        }
    }
    return valor;
    }
    
    public boolean esVacio(){
        boolean exito=false;
            if (this.raiz==null) {
                exito=true;
            }
        return exito;
    }

    public String toString() {
        String aux;
        if (this.raiz == null) {
            aux = "Arbol Vacio";
        } else {
            aux = toStringAux(this.raiz);
        }
        return aux;

    }

    private String toStringAux(NodoAVL nodo) {
//      Retorna una cadena con los nodos y sus respectivos hijos izquierdos y derechos
        String total = "";
        if (nodo != null) {
            total = total + "Nodo= " + nodo.getElem() + "\t";
            if (nodo.getIzquierdo() != null) {
                total = "\t" + total + "HI=" + nodo.getIzquierdo().getElem() + "\t";
            } else {
                total = "\t" + total + "HI= - " + "\t";
            }
            if (nodo.getDerecho() != null) {
                total = "\t" + total + "HD=" + nodo.getDerecho().getElem() + "\n";
            } else {
                total = "\t" + total + "HD= - " + "\n";
            }
            total += toStringAux(nodo.getIzquierdo());
            total += toStringAux(nodo.getDerecho());
        }

        return total;
    }
    public ArbolAVL clone() {
        //Si la raiz no es null llama al metodo privado para crear un clon del arbol
        ArbolAVL clone = new ArbolAVL();        
        if (this.raiz != null) {
            NodoAVL aux = new NodoAVL(this.raiz.getElem(),null,null);
            clone.raiz = aux;
            cloneAux(clone.raiz,this.raiz);
        }

        return clone;
    }

     private void cloneAux(NodoAVL clon,NodoAVL original){
       //Recorre los nodos izquierdos creando un nuevo nodo y asignandolo
        if (original.getIzquierdo()!=null) {
            NodoAVL nuevoEnlace= new NodoAVL(original.getIzquierdo().getElem(),null,null);
            clon.setIzquierdo(nuevoEnlace);
            cloneAux(clon.getIzquierdo(),original.getIzquierdo());
        } 
        //Recorre los nodos derechos creando un nuevo nodo y asignandolo

        if (original.getDerecho()!=null) {
            NodoAVL nuevoEnlaceAux= new NodoAVL(original.getDerecho().getElem(),null,null);
            clon.setDerecho(nuevoEnlaceAux);
            cloneAux(clon.getDerecho(),original.getDerecho());
        }
    }
    

}
