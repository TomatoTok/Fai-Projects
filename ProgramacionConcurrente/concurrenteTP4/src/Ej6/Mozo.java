/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tomi
 */
public class Mozo extends Thread {

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
            Thread.sleep(restauran.tomarOrden(nombre));
            this.restauran.entregarComida();

        } catch (InterruptedException ex) {
            Logger.getLogger(Mozo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
