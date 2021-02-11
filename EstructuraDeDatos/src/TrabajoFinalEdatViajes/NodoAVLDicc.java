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
public class NodoAVLDicc {

    private Comparable clave;
    private Object datos;
    private int altura;
    private NodoAVLDicc izquierdo;
    private NodoAVLDicc derecho;

    public NodoAVLDicc(Comparable clave, Object datos,NodoAVLDicc hijDer, NodoAVLDicc hijIzq) {
        this.clave = clave;
        this.datos = datos;
        this.izquierdo = hijIzq;
        this.derecho = hijDer;
        this.altura = 0;
    }
    
    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setIzquierdo(NodoAVLDicc hijoIzquierdo) {
        this.izquierdo = hijoIzquierdo;
    }

    public void setDerecho(NodoAVLDicc hijoDerecho) {
        this.derecho = hijoDerecho;
    }

    public int getAltura() {
        return altura;
    }

    public NodoAVLDicc getIzquierdo() {
        return izquierdo;
    }

    public NodoAVLDicc getDerecho() {
        return derecho;
    }

    public Comparable getClave() {
        return clave;
    }

    public Object getDatos() {
        return datos;
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
}
