/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.estaticas;

import java.util.Arrays;

/**
 *
 * @author Walter
 */
public class Cola {
    //Declaro los atributos privados de mi estructura
    private int tamanio=10;
    private Object arr[] = new Object[tamanio];
    private int frente = 0;
    private int fin = 0;

    public Cola() {
        //Constructor vacio
    }

    public boolean poner(Object elem) {
        boolean exito = false;
            //Si fin +1 no es igual a frente entonces coloca un nuevo elemento
        if ((this.fin+1)%tamanio != this.frente) {
            this.arr[this.fin] = elem;
            this.fin = (this.fin + 1) % tamanio;
            exito =true;
        }
        return exito;
    }

    public boolean sacar() {
        boolean exito = true;
            //Verifica que la pila no este vacia
        if (this.esVacia()) {
            exito = false;
        } else {
            //Tiene por lo menos un elemento y luego avanza el frente
            this.arr[this.frente] = null;
            this.frente = (this.frente + 1) % this.tamanio;
        }
        return exito;
    }

    public Object obtenerFrente() {
        //Metodo publico para obtener el elemento del frente
    Object aux;    
        //Verifica que la sentencia no este vacia
    if (this.frente == this.fin) {
        aux=null;}
    else{
        aux=this.arr[frente];}
        return aux;
    }


    public boolean esVacia() {
        //Metodo publico donde se observa si esta vacia la estructura
        boolean valor = false;
        if (this.frente == this.fin) {
            valor = true;
        }
        return valor;
    }

    public void vaciar() {
            //Metodo publico para vaciar la estructura
        Object aux = null;
        this.frente=0;
        this.fin=0;
        for (int i = 0; i < this.tamanio; i++) {
            //Recorre todo el array pisando cada elemento con el valor null
            arr[i] = aux;
        }
    }

    @Override
    public Cola clone() {
        Cola nuevaCola = new Cola();
            //Igualo las variables a la original
        nuevaCola.tamanio = this.tamanio;
        nuevaCola.fin = this.fin;
        nuevaCola.frente = this.frente;
        //Copio todos los elementos a la copia, como es un arreglo puedo usar las propiedades de los arreglos
        nuevaCola.arr = this.arr.clone();
       
        return nuevaCola;
    }

    public String toString() {
        //Metodo publico para imprimir por pantalla
        return "Elementos: " + Arrays.toString(this.arr);
    }
}
