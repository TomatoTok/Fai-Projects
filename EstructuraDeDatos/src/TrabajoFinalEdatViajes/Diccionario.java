/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoFinalEdatViajes;

/**
 *
 * @author Walter
 */
public class Diccionario {
    
    private NodoAVLDicc raiz;
    
    public Diccionario(){
    this.raiz = null;
    }
    
        public boolean insertar(Comparable elemento, Object dato) {
        boolean exito;
        exito = insertarAux(this.raiz, elemento,dato);
        return exito;
    }

    private boolean insertarAux(NodoAVLDicc nodo, Comparable elem, Object dato) {
        boolean exito = true;
        //Caso de la raiz
        if (this.raiz == null) {
            NodoAVLDicc nuevo = new NodoAVLDicc(elem,dato, null, null);
            this.raiz = nuevo;
            this.raiz.recalcularAltura();
        } else {
            if (nodo != null) {
                //Si el elemento es mas chico que el elemento del nodo entonces se mueve a la izquierda
                if (nodo.getClave().compareTo(elem) > 0) {
                    if (nodo.getIzquierdo() != null) {
                        //Si el elemento del hijo izquierdo es igual al elemento a insertar da error
                        if (nodo.getIzquierdo().getClave() == elem) {
                            exito = false;
                        } else {
                            //sino hace el llamado recursivo moviendose a la izquierda
                            insertarAux(nodo.getIzquierdo(), elem,dato);
                            //actualizo la altura del nodo y calculo el balance de sus hijos
                            nodo.recalcularAltura();
                            calcularBalance(nodo, nodo.getIzquierdo(), 'I');
                        }
                    } else { // Si el nodo izquierdo es nulo, entonces se asigna el nuevo enlace
                        NodoAVLDicc nuevo = new NodoAVLDicc(elem,dato, null, null);
                        nodo.setIzquierdo(nuevo);
                        nodo.recalcularAltura();
                    }
                } else {
                    //Si el elemento es mas grande que el elemento del nodo entonces se mueve a la derecha    
                    if (nodo.getClave().compareTo(elem) < 0) {
                        if (nodo.getDerecho() != null) {
                            //Si el elemento del hijo derecho es igual al elemento a insertar da error
                            if (nodo.getDerecho().getClave() == elem) {
                                exito = false;
                            } else {
                                //Sino hace el llamado recursivo moviendose a la derecha
                                insertarAux(nodo.getDerecho(), elem,dato);
                                //actualizo la altura del nodo y calculo el balance de sus hijos
                                nodo.recalcularAltura();
                                calcularBalance(nodo, nodo.getDerecho(), 'D');
                            }
                        } else {//si el nodo derecho es nulo, entonces se asigna el nuevo enlace 
                            NodoAVLDicc nuevo = new NodoAVLDicc(elem,dato, null, null);
                            nodo.setDerecho(nuevo);
                            nodo.recalcularAltura();
                        }
                    }
                }
            }
        }
        return exito;
    }

    private NodoAVLDicc rotarIzquierda(NodoAVLDicc r) {
        NodoAVLDicc hijoDerecho, temp;
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

    private NodoAVLDicc rotarDerecha(NodoAVLDicc r) {
        NodoAVLDicc hijoIzquierdo, temp;
        hijoIzquierdo = r.getIzquierdo();
        temp = hijoIzquierdo.getDerecho();
        hijoIzquierdo.setDerecho(r);
        r.setIzquierdo(temp);
        //recalculo sus alturas
        r.recalcularAltura();
        hijoIzquierdo.recalcularAltura();
        return hijoIzquierdo;
    }

    private void calcularBalance(NodoAVLDicc padre, NodoAVLDicc hijo, char pos) {

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

    private void rotacionRaiz(NodoAVLDicc padre, NodoAVLDicc hijo, int balP, int balH) {
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

    private void rotacionSimple(NodoAVLDicc padre, NodoAVLDicc hijo, char pos, int balH) {
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

    private void rotacionDoble(NodoAVLDicc padre, NodoAVLDicc hijo, char pos, int balH, int balSubH) {
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

    private int balance(NodoAVLDicc nodo) {
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

    private boolean eliminarAux(Comparable elem, NodoAVLDicc nodo) {
        boolean exito = false;
        //Mientras el nodo no sea nulo
        if (nodo != null) {
            //  Primero revisa si la raiz es el elemento a eliminar
            if (this.raiz.getClave().compareTo(elem) == 0) {
                verificarCaso(this.raiz, 'R');
                exito = true;
            } else {
                //Luego revisa si alguno de sus hijos contiene el elemento a eliminar
                if (nodo.getIzquierdo() != null) {
                    if (elem.compareTo(nodo.getIzquierdo().getClave()) == 0) {
                        verificarCaso(nodo, 'I');
                        exito = true;
                    }
                }
                if (nodo.getDerecho() != null) {
                    if (elem.compareTo(nodo.getDerecho().getClave()) == 0) {
                        verificarCaso(nodo, 'D');
                        exito = true;
                    }
                }
            }
            //Si el elemento no se ha encontrado aun, se hace el llamado recursivo por los subArboles
            if (!exito) {
                if (elem.compareTo(nodo.getClave()) < 0) {
                    eliminarAux(elem, nodo.getIzquierdo());
                }
                if (elem.compareTo(nodo.getClave()) > 0) {
                    eliminarAux(elem, nodo.getDerecho());
                }
            }
        }
        return exito;
    }

    private void verificarCaso(NodoAVLDicc padre, char pos) {
        NodoAVLDicc hijo = null;
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
    
    private void ladoBalance(NodoAVLDicc padre, char pos){
        if (pos == 'D') {
        calcularBalance(padre,padre.getDerecho(),'D');
        }else{calcularBalance(padre,padre.getIzquierdo(),'I');
}
    }

    private void eliminarCaso1(NodoAVLDicc padre, char pos) {
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
    
    private void eliminarCaso2(NodoAVLDicc padre, NodoAVLDicc hijo, char pos) {
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

    private void eliminarCaso3(NodoAVLDicc padre, NodoAVLDicc hijo, char pos) {
        NodoAVLDicc candidato = new NodoAVLDicc(null,null, null, null);
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
                if (hijo.getIzquierdo().getClave() != candidato.getClave()) {
                    candidato.setIzquierdo(hijo.getIzquierdo());
                }

            }
            if (hijo.getDerecho() != null) {
                if (hijo.getDerecho().getClave() != candidato.getClave()) {
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

    private NodoAVLDicc mejorCandidato(NodoAVLDicc hijo) {
        NodoAVLDicc padre = hijo, aux,candidato;
        boolean bandera = false;
        aux = hijo.getIzquierdo();
        while (!bandera) {
            padre = aux;
            //Con esto obtengo el padre para eliminar el candidato
            if (aux.getDerecho() != null) {
                if (aux.getDerecho().getDerecho()== null) {
                    aux = aux.getDerecho();
                    bandera=true;
                }else{
                    aux = aux.getDerecho();}
            }else{
            bandera=true;
            }
        }
        //Si el hijo izquierdo del nodo a eliminar no tiene hijos derechos
        if (aux.getClave() == hijo.getIzquierdo().getClave()) {
            verificarCaso(hijo,'I');
            candidato = new NodoAVLDicc(aux.getClave(),aux.getDatos(),null,null);
        }else{
        //Si el hijo izquierdo del nodo a eliminar tiene hijos derechos 
            verificarCaso(padre,'D');
            candidato = new NodoAVLDicc(aux.getClave(),aux.getDatos(),null,null);
        }
        return candidato;
    }

         public boolean existeClave(Comparable clave){
     boolean exito = false;
         if (this.raiz != null) {
             exito = existeClaveAux(clave,this.raiz);
         }
         return exito;
     }
     
     private boolean existeClaveAux(Comparable clave, NodoAVLDicc nodo){
         boolean exito = false;
         if (!exito) {
             if (nodo != null) {
                 if (nodo.getClave().compareTo(clave) == 0) {
                     exito = true;
                 }
                 else{
                     if (nodo.getClave().compareTo(clave)<0 && nodo.getIzquierdo()!=null) {
                         
                     }
                 }
             }
         }
     return exito;
     }
}
