/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;

import conjuntistas.NodoABB;
import lineales.dinamicas.Lista;

/**
 *
 * @author Walter
 */
public class ArbolABB {

    private NodoABB raiz;

    public ArbolABB() {
        this.raiz = null;
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
//      Metodo privado por trabajar con Nodos internos
//      precondicion: n no es nulo
        boolean exito = true;
        if (elem.compareTo(n.getElem()) == 0) {
            //Reportar error: elemento repetido
            exito = false;

        } else if (elem.compareTo(n.getElem()) < 0) {
//          elemento es menor que el elemento del nodo
//          si tine HI baja a la izq, sino agrega elemento
            if (n.getIzquierdo() != null) {
                exito = insertarAux(n.getIzquierdo(), elem);
            } else {
                n.setIzquierdo(new NodoABB(elem, null, null));
            }
        }else {// elemento es mayor que el elemento del nodo
        // si tiene HD baja a la derecha, sino agrega el elemento
        if (n.getDerecho() != null) {
            exito = insertarAux(n.getDerecho(), elem);
        } else {
            n.setDerecho(new NodoABB(elem, null, null));
        }}
        return exito;
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

    private Lista listarRangoAux(NodoABB nodo, Lista listaAux, Comparable elemMin, Comparable elemMax, boolean aux1) {
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

    public boolean eliminarMax() {
        boolean aux = false;
        if (this.raiz != null) {
            aux = eliminarMaxAux(this.raiz);
        }
        return aux;
    }

    private boolean eliminarMaxAux(NodoABB nodo) {
        boolean exito = true;
//      Busca por la rama derecha el elemento mas grande
        if (nodo.getDerecho() != null) {
            if (nodo.getDerecho().getDerecho() != null) {
//          Llamado recursivo si el elemento a su derecha tiene hijo derecho
                eliminarMaxAux(nodo.getDerecho());
            } else {
//          En caso de que el nodo a eliminar tenga hijo izq
                if (nodo.getDerecho().getIzquierdo() != null) {
                    nodo.setDerecho(nodo.getDerecho().getIzquierdo());
                } else {
                    nodo.setDerecho(null);
                }
            }
        } else {//En caso de ser raiz 
            if (nodo.getIzquierdo() != null) {
                this.raiz = nodo.getIzquierdo();
            } else {
                raiz = null;
            }
        }
        return exito;
    }

    public boolean eliminarMin() {
        boolean aux = false;
        if (this.raiz != null) {
            aux = eliminarMinAux(this.raiz);
        }
        return aux;
    }

    private boolean eliminarMinAux(NodoABB nodo) {
        boolean exito = true;
//      Busca por la rama izquierda el elemento mas chico
        if (nodo.getIzquierdo() != null) {
            if (nodo.getIzquierdo().getIzquierdo() != null) {
//          Llamado recursivo si el elemento a su izquierda tiene hijo derecho
                eliminarMinAux(nodo.getIzquierdo());
            } else {
//              En caso de que el nodo a eliminar tenga hijo der
                if (nodo.getIzquierdo().getDerecho() != null) {
                    nodo.setIzquierdo(nodo.getIzquierdo().getDerecho());
                } else {
                    nodo.setIzquierdo(null);
                }
            }
        } else {//En caso de ser raiz 
            if (nodo.getDerecho() != null) {
                this.raiz = nodo.getDerecho();
            } else {
                this.raiz = null;

            }
        }
        return exito;
    }

    public void vaciar() {
        this.raiz = null;
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

    private String toStringAux(NodoABB nodo) {
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

    public boolean eliminar(Comparable elem) {
        boolean existe = false;
        if (this.raiz != null) {
            existe = eliminarAux(elem, this.raiz);

        }
        return existe;
    }

    private boolean eliminarAux(Comparable elem, NodoABB nodo) {
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
    
    private void verificarCaso(NodoABB padre, char pos) {
        NodoABB hijo = null;
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
            if (hijo == null) {
//          es hoja, caso 1
                eliminarCaso1(padre, pos);
            } else {
                if (hijo.getIzquierdo() != null && hijo.getDerecho() != null) {
//          el nodo tiene ambos hijos, caso 3
                    eliminarCaso3(padre, hijo, pos);
                } else {
//          tiene solo un hijo, caso 2
                    eliminarCaso2(padre, hijo, pos);
                }
            }
        }
    }

    private void eliminarCaso1(NodoABB padre, char pos) {
        //Elimina la hoja dependiendo de la posicion en que se encuente con respecto al padre
        if (pos == 'I') {
            padre.setIzquierdo(null);
        } else {
            if (pos == 'D') {
                padre.setDerecho(null);
            } else {
                //En caso de ser raiz no posee una posicion con respecto a un padre
                //Por lo cual este se le asigna el valor null
                this.raiz = null;
            }
        }
    }

    private void eliminarCaso2(NodoABB padre, NodoABB hijo, char pos) {
        //Si el nodo a eliminar es la raiz
        if (pos == 'R') {
            if (this.raiz.getIzquierdo() != null) {
                this.raiz = this.raiz.getIzquierdo();
            } else {
                this.raiz = this.raiz.getDerecho();
            }
        } else {
            //Si el nodo a eliminar(hijo) tiene un nodo izquierdo su padre
            //se enlaza con su nodo izquierdo eliminandolo    
            if (hijo.getIzquierdo() != null) {
                if (pos == 'I') {
                    padre.setIzquierdo(hijo.getIzquierdo());
                } else {
                    padre.setDerecho(hijo.getIzquierdo());
                }
            } else {
                //Si el nodo a eliminar(hijo) tiene un nodo derecho su padre
                //se enlaza con su nodo derecho eliminandolo
                if (pos == 'D') {
                    padre.setDerecho(hijo.getDerecho());
                } else {
                    padre.setIzquierdo(hijo.getDerecho());
                }
            }
        }
    }

    private void eliminarCaso3(NodoABB padre, NodoABB hijo, char pos) {
        NodoABB candidato = new NodoABB(null, null, null);
        if (hijo == null) {
//      Esta condicion se da en el caso de la Raiz ya que se envia a la raiz por el Padre
            candidato = mejorCandidato(padre);
            if (padre.getIzquierdo() != null) {
                if (padre.getIzquierdo().getElem() != candidato.getElem()) {
                    candidato.setIzquierdo(padre.getIzquierdo());
                }
            }
            if (padre.getDerecho() != null) {
                if (padre.getDerecho().getElem() != candidato.getElem()) {
                    candidato.setDerecho(padre.getDerecho());
                }
            }
            //ahora superpongo el candidato por el nodo que quiero eliminar
            padre.setElem(candidato.getElem());
            padre.setDerecho(candidato.getDerecho());
            padre.setIzquierdo(candidato.getIzquierdo());
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

    private NodoABB mejorCandidato(NodoABB hijo) {
        NodoABB padre = hijo, aux, candidato = new NodoABB(null, null, null);
        aux = hijo.getIzquierdo();
        while (aux != null) {
            padre = aux;
            //Con esto obtengo el padre para eliminar el candidato
            if (aux.getDerecho() != null) {
                if (aux.getDerecho().getDerecho() != null) {
                    aux = aux.getDerecho();
                } else {
                    aux = null;
                }
            } else {
                //En caso de que no tenga hijos derechos
                aux = null;
            }
        }
        //  Si tiene hijos derechos asigna el valor del nodo a eliminar al candidato y luego se elimina
        if (padre.getDerecho() != null) {
            candidato.setElem(padre.getDerecho().getElem());
            verificarCaso(padre, 'D');
        } else {
            //  Si no tiene hijos derechos al candidato se le asigna el valor del nodo a eliminar y luego se elimina
            candidato.setElem(padre.getElem());
            verificarCaso(padre, 'I');
        }
        return candidato;
    }

}
