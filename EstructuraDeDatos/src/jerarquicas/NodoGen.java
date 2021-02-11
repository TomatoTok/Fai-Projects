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
public class NodoGen {
    private Object elem;
    private NodoGen hijoIzquierdo;
    private NodoGen hermanoDerecho;
    
    public NodoGen(Object elem, NodoGen hijoIzq,NodoGen hermanoDer){
        this.elem=elem;
        hijoIzquierdo=hijoIzq;
        hermanoDerecho=hermanoDer;
    }
    
    public Object getElem(){
    return elem;
    }
    public NodoGen getHijoIzquierdo(){
    return hijoIzquierdo;
    }
    public NodoGen getHermanoDerecho(){
    return hermanoDerecho;
    }
    public void setElem(Object elem){
    this.elem=elem;
    }
    public void setHijoIzquierdo(NodoGen hijoIzquierdo){
    this.hijoIzquierdo= hijoIzquierdo;
    }
    public void setHermanoDerecho(NodoGen hermanoDerecho){
    this.hermanoDerecho=hermanoDerecho;
    }
    
}
