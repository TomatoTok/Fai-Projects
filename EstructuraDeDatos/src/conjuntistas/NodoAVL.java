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
public class NodoAVL {
    private Comparable elem;
    private int altura;
    private NodoAVL izquierdo;
    private NodoAVL derecho;
    
    public NodoAVL(Comparable elem, NodoAVL izq, NodoAVL der){
        this.elem = elem;
        this.izquierdo = izq;
        this.derecho = der;
        this.altura = 0;
    }  
    public Comparable getElem(){
    return elem;
    }
    public void setElem(Comparable nuevo){
    elem = nuevo;
    }
    public int getAltura(){
    return this.altura;
    }

    public final void recalcularAltura(){
    int altIzq=-1;
    int altDer=-1;
        if (this.izquierdo!=null) {
            altIzq=this.izquierdo.getAltura();
        }
        if (this.derecho!=null) {
            altDer=this.derecho.getAltura();
        }
        this.altura=Math.max(altIzq, altDer)+1;
}
    public NodoAVL getIzquierdo(){
    return izquierdo;
    }
    public void setIzquierdo(NodoAVL nuevo){
    this.izquierdo = nuevo;
    }
    public NodoAVL getDerecho(){
    return derecho;
    }
    public void setDerecho(NodoAVL nuevo){
    this.derecho = nuevo;
    }
}
