/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3_hamster;

/**
 *
 * @author Tomi
 */
public class Rueda {
    boolean estaLibre = true;

    public Rueda() {
    }

    public synchronized boolean usarRueda() {//Falso semaforo
        boolean sePuedeUsar = false;
        if (this.estaLibre) {
            this.estaLibre = false;
            sePuedeUsar = true;
        }

        return sePuedeUsar;
    }

    public synchronized void dejarRueda() {
        this.estaLibre = true;
    }
    
}

