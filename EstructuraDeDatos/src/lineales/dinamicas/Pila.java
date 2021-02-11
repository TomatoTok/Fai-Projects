/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 *
 * @author Walter
 */
public class Pila {

    private Nodo tope;

    public Pila() {
        this.tope = null;
    }

    public boolean apilar(Object nuevoElem) {
        //crea el nuevo nodo adelante de la cabecera antigua
        Nodo nuevo = new Nodo(nuevoElem, this.tope);
        //Con esto se apunta al nodo nuevo
        this.tope = nuevo;
        //nunca hay error de pila llena, entonces delvuelve true
        return true;
    }

    public boolean desapilar() {
        boolean exito = false;
        //pregunto si la pila esta vacia, en caso de no estarlo se copia el enlace del nodo anterior
        if (this.tope != null) {
            //creo un nodo con el enlace del nodo anterior
            Nodo aux = this.tope.getEnlace();
            //le asigno a tope el tope del nodo anterior
            this.tope = aux;
            exito = true;
        }
        return exito;
    }

    public Object obtenerTope() {
        //Devuelve el elemento posicionado en el tope, si no hay devuelve null
        Object aux=null;
        if (this.tope != null) {
           aux=this.tope.getElem();           
        }
        return aux;
    }

    public boolean esVacia() {
        boolean exito = false;
        //si el tope es igual al nodo aux construido en null entonces esta vacia
        if (this.tope == null) {
            exito = true;
        }
        return exito;
    }

    public void vaciar() {
        //Gracias a el garbage collector de java simplemente ponemos en null el tope
        this.tope = null;
    }

    public Pila clone() {
        //Creo una pila nueva y le asigno el tope del ultimo nodo
        Nodo aux =this.tope;
        Pila invertido = new Pila();
        Pila clon = new Pila();
        //Copio elemento por elemento pero como es una pila me queda en orden invertido
        while(aux!=null){
        invertido.apilar(aux.getElem());
        aux=aux.getEnlace();
        }
        //Aca doy vuelta la pila para que me devuelva la estructura como la original
        aux= invertido.tope;
        while(aux!=null){
        clon.apilar(aux.getElem());
        aux=aux.getEnlace();
        }        
        return clon;

    }

    public String toString() {
        String s = " ";
        if (this.tope == null) {
            s = "Pila vacia";
        } else {
            //se ubica para recorrer la pila
            Nodo aux = this.tope;
            s = "[";

            while (aux != null) {
                //agrega el texto del elemento y avanza
                s += aux.getElem().toString();
                aux = aux.getEnlace();
                if (aux != null) {
                    s += ",";
                }
            }
            s += "]";
        }
        return s;
    }
}
