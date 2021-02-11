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
public class Pila {

    private Object[] dato;
    private int tope;
    private static final int tamanio = 10;

    public Pila() {
        this.dato = new Object[tamanio];
        this.tope = -1;
    }

    public boolean apilar(Object nuevoElem) {
        boolean exito;

        if (this.tope + 1 >= this.tamanio) {
            //error: pila llena
            exito = false;
        } else {
            //pone el elemento en el tope de la pile e incrementa tope
            this.tope++;
            this.dato[tope] = nuevoElem;
            exito = true;
        }
        return exito;
    }

    public boolean desapilar() {
        Object elemNulo = null;
        boolean exito;
        if (this.tope <= 0  ) {
            //error: pila vacia
            exito = false;
        } else {
            //pone un elemento nulo y decrementa el tope
            this.dato[tope] = elemNulo; 
            this.tope--;        
            exito = true;
        }
        return exito;
    }

    public Object obtenerTope() {
        return this.dato[tope];
    }

    public boolean esVacia() {
        //Verifica si la pila esta vacia
        boolean exito = false;
        if (this.tope <= 0 ) {
            exito = true;
        }
        return exito;
    }

    public void vaciar() {
        //Vacia la pila sobreescribiendo el valor del objeto con otro objeto null
        for (int i = this.tope; i > -1; i--) {
            dato[i] = null;
        }
    }

    public Pila clone() {
        Pila pilaNueva = new Pila();
        //Como el tope de pilaNueva es -1, lo igualo al tope de pila original
        pilaNueva.tope = this.tope;
        
        //Despues copiamos cada elemento de la pila original
        while(pilaNueva.tope >= 0){
        pilaNueva.dato[pilaNueva.tope]=this.dato[pilaNueva.tope];
        pilaNueva.tope= pilaNueva.tope -1;
        }
        //Volvemos a igualar el tope al tope original
        pilaNueva.tope=this.tope;
        return pilaNueva;
    }
    public String toString(){
    return "Elementos: "+ Arrays.toString(dato);
    }
}
 