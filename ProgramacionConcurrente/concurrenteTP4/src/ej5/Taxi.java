/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej5;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tomi
 */
public class Taxi {

    private Semaphore taxiLibre = new Semaphore(1);
    private Semaphore hayPasajero = new Semaphore(0);
    private Semaphore puedeBajar = new Semaphore(0);

    public void subirTaxi(String nombre) {//Pasajero
        try {
            taxiLibre.acquire();
            System.out.println("Subio el pasajero " + nombre);
            hayPasajero.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void realizarViaje() {//Taxista
        try {
            hayPasajero.acquire();
            System.out.println("Esta viajando el taxista(realizarViaje)");

        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void terminarViaje() {//Taxista
        puedeBajar.release();
        System.out.println("termino viaje del taxista(terminarViaje)");

    }

    public void pagarViaje(String nombre) {//Pasajero
        try {
            puedeBajar.acquire();
            System.out.println("Esta pagando " + nombre);
            taxiLibre.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
