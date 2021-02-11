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
public class NodoABB {

    private Comparable elem;
    private NodoABB izq;
    private NodoABB der;

    public NodoABB(Comparable elem, NodoABB izq, NodoABB der) {
        this.elem = elem;
        this.izq = izq;
        this.der = der;
    }

    public Comparable getElem() {
        return this.elem;
    }

    public NodoABB getIzquierdo() {
        return this.izq;
    }

    public NodoABB getDerecho() {
        return this.der;
    }

    public void setElem(Comparable nuevoElem) {
        this.elem = nuevoElem;
    }

    public void setIzquierdo(NodoABB nuevoIzq) {
        this.izq = nuevoIzq;
    }

    public void setDerecho(NodoABB nuevoDer) {
        this.der = nuevoDer;
    }

}


    

