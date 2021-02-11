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
public class NodoAdy {
    //atributos
    private NodoVert vertice;
    private NodoAdy sigAdyacente;
    private int etiqueta;
    
    public NodoAdy(NodoVert ver,NodoAdy ady, int etiq){
    this.vertice=ver;
    this.sigAdyacente=ady;
    this.etiqueta=etiq;
    }
    public NodoVert getVertice(){
    return this.vertice;
    }
    public void setVertice(NodoVert vert){
    this.vertice = vert;
    }
    public NodoAdy getSigAdyecente(){
    return this.sigAdyacente;
    }
    public void getNodoAdyecente(NodoAdy ady){
    this.sigAdyacente = ady;
    }
    public int getEtiqueta(){
    return this.etiqueta;
    }
    public void setEtiqueta(int elem){
    this.etiqueta = elem;
    }
}
