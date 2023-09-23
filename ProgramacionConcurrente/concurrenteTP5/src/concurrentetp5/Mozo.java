/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package concurrentetp5;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tomi
 */
public class Mozo extends Thread { //Se encarga de la bebida

    private String nombre;
    private Restauran restauran;
    private int cantidad;
    
    public Mozo(String nombre, Restauran restauran, int cantidadClientes) {
        this.nombre = nombre;
        this.restauran = restauran;
        this.cantidad = cantidadClientes;
    }

    public void run() {
        try {
           int n = 0;
            while(cantidad >= n){
            restauran.prepararBebida();
            Thread.sleep(1000);//tiempo para preparar bebida
            this.restauran.entregarBebida();
            n++;
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Mozo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
