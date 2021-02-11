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
public class Cola {
    //creo los nodos privados

    private Nodo frente;
    private Nodo fin;

    public Cola() {
        //Constructor vacio
    }

    public boolean poner(Object elemento) {
        Nodo nuevo = new Nodo(elemento, null);
        //si el la cola esta vacia asigno a frente el nodo nuevo
        if (this.fin == null)
            this.frente = nuevo;
        else
        //sino enlazo el nodo nuevo en fin
        this.fin.setEnlace(nuevo);
        this.fin = nuevo;
        return true;
    }

    public boolean sacar() {
        //Metodo publico para sacar el elemento frente de la cola
        boolean exito = true;
            //Verifica que no este vacia la cola
        if (this.esVacia()) {
            exito = false;
        } else {
            //Existe al menos un elemento
            this.frente = this.frente.getEnlace();
            if (this.frente == null) {
                this.fin = null;
            }
        }
        return exito;
    }

    public Object obtenerFrente() {
        Object aux;
        if (esVacia()) {
            //si esta vacia retorna null
            aux = null;
        } else {
            //devuelve el elemento en el frente
            aux = this.frente.getElem();
        }
        return aux;
    }

    public boolean esVacia() {
        boolean exito = false;
            //Si no hay nada enlazado al frente entonces la cola esta vacia
        if (this.frente == null) {
            exito = true;
        }
        return exito;
    }

    public void vaciar() {
        //Tanto como a frente y fin al darle valores null el garbageCollector se hace cargo del resto de nodos
        this.frente = null;
        this.fin = null;
    }

    public Cola clone() {
        Cola copiaCola = new Cola();
        if (this.frente==this.fin && this.frente==null) {
            //Si la cola es vacia retorna una cola vacia
        }else{
            //Se le asignan una copia de los nodos permitiendo crean un clon sin alterar la original
        copiaCola.poner(this.frente.getElem());
        Nodo aux = this.frente;
        while (aux.getEnlace() != null) {
            aux = aux.getEnlace();
            copiaCola.poner(aux.getElem());
        }}
        return copiaCola;
    }

    public String toString() {
        String s = " ";
        if (this.frente == null) {
            s = "cola vacia";
        } else {
            Nodo aux = this.frente;
            s = "[";
            while (aux != null) {
                //agrega el texto y avanza
                s += aux.getElem().toString() + ",";
                aux = aux.getEnlace();

            }
            s = s + "]";
        }
        return s;
    }
}
