/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej5;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tomi
 */
public class Taxista extends Thread{

    private Taxi taxi;
    private int cantidadPasajeros;
    public Taxista(Taxi taxi, int cp) {
        this.taxi = taxi;
        this.cantidadPasajeros = cp;
    }
    
    public void run(){
        for (int i = 0; i < this.cantidadPasajeros; i++) {
             try {
            taxi.realizarViaje();
            Thread.sleep(500);
            taxi.terminarViaje();
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxista.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
       
    }
}
