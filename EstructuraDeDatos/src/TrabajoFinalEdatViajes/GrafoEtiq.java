/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoFinalEdatViajes;

import lineales.dinamicas.Lista;

/**
 *
 * @author Walter
 */
public class GrafoEtiq {
    //atributo
    private NodoVert inicio = null;
    
//  método auxiliar privado ubicarVertice recorre la lista de vértices buscando un elemento
//  y si lo encuentra devuelve el enlace al nodo que lo contiene
    private NodoVert ubicarVertice (Object buscado){
        NodoVert aux = this.inicio;
        while(aux != null && !aux.getElem().equals(buscado)){
            aux =  aux.getSigVertice();
        }
        return aux;
    }
    
    public boolean insertarVertice(Object nuevoVertice){
    boolean exito = false;
    NodoVert aux = this.ubicarVertice(nuevoVertice);
        if (aux==null) {
            this.inicio = new NodoVert(nuevoVertice, this.inicio);
            exito=true;
        }
        return exito;
    }
    
    public Lista listarEnProfundidad(){
    Lista visitados =  new Lista();
    //Define un vertice donde comenzar a recorrer
    NodoVert aux = this.inicio;
    while(aux != null){
        if (visitados.localizar(aux.getElem())<0) {
            //si el vertice no fue visitado aun avanza en profundidad
            listarEnProfundidadAux(aux,visitados);
        }
        aux = aux.getSigVertice();
    }
    return visitados;
    }
    private void listarEnProfundidadAux(NodoVert n, Lista vis){
        if (n!=null) {
            //marca al vertice n como visitado
            vis.insertar(n.getElem(),vis.longitud()+1);
            NodoAdy ady = n.getPrimerAdy();
            while(ady != null){
            //visita en profundidad los adyacentes de n aun no visitados
                if (vis.localizar(ady.getVertice().getElem()) < 0) {
                    listarEnProfundidadAux(ady.getVertice(),vis);
                }
                ady = ady.getSigAdyecente();
            }
        }
    }
    public boolean existeCamino (Object origen, Object destino){
    boolean exito = false;
    //verifica si ambos vertices existen
    NodoVert aux0 = null;
    NodoVert auxD = null;
    NodoVert aux = this.inicio;
    while ((aux0 == null || auxD == null) && aux!=null){
        if (aux.getElem().equals(origen)) {
            aux0=aux;
        }
        if (aux.getElem().equals(destino)) {
            auxD=aux;
        }
        aux= aux.getSigVertice();
    }
        if (aux0 != null && auxD != null) {
            //si ambos vertices existen busca si existe camino entre ambos
            Lista visitados = new Lista();
            exito = existeCaminoAux(aux0,destino,visitados);
        }
        return exito;
    }
    private boolean existeCaminoAux(NodoVert n, Object dest, Lista vis){
    boolean exito = false;
        if (n!=null) {
            //si vertice n es el destino: hay camino
            if (n.getElem().equals(dest)) {
                exito=true;
            }else{
            //si no es el destino verifica si hay camino entre n y destino
            vis.insertar(n.getElem(),vis.longitud()+1);
            NodoAdy ady = n.getPrimerAdy();
            while(!exito && ady!= null){
                if (vis.localizar(ady.getVertice().getElem())<0) {
                    exito= existeCaminoAux(ady.getVertice(),dest,vis);
                }
                ady=ady.getSigAdyecente();
            }
            }
        }
        return exito;
    }
}
