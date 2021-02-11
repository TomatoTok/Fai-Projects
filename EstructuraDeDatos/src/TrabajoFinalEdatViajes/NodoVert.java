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
public class NodoVert {
    //atributos
    private Object elem;
    private NodoVert sigVertice;
    private NodoAdy primerAdy;
    
    public NodoVert(Object elemento, NodoVert ver){
        this.elem = elemento;
        this.sigVertice = ver;
    }
    
    public Object getElem(){
    return this.elem;
    }
    public void setElem(Object elem){
    this.elem = elem;
    }
    public NodoVert getSigVertice(){
    return this.sigVertice;
    }
    public void setSigVertice(NodoVert vert){
    this.sigVertice = vert;
    }
    public NodoAdy getPrimerAdy(){
    return this.primerAdy;
    }
    public void setPrimerAdy(NodoAdy ady){
    this.primerAdy = ady;
    }
}
