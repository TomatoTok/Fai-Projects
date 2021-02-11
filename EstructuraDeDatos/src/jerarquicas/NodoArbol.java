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
public class NodoArbol {

    private Object elem;
    private NodoArbol izq;
    private NodoArbol der;

    public NodoArbol(Object elem, NodoArbol izq, NodoArbol der) {
        this.elem = elem;
        this.izq = izq;
        this.der = der;
    }

    public Object getElem() {
        return this.elem;
    }

    public NodoArbol getIzquierdo() {
        return this.izq;
    }

    public NodoArbol getDerecho() {
        return this.der;
    }

    public void setElem(Object nuevoElem) {
        this.elem = nuevoElem;
    }

    public void setIzquierdo(NodoArbol nuevoIzq) {
        this.izq = nuevoIzq;
    }

    public void setDerecho(NodoArbol nuevoDer) {
        this.der = nuevoDer;
    }

}

