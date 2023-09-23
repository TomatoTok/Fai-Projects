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
public class Empleado extends Thread {

    private String nombre;
    private Restauran restauran;

    public Empleado(String nombre, Restauran pollosHermanos) {
        this.nombre = nombre;
        this.restauran = pollosHermanos;
    }

    public void run() {
        try {
            this.restauran.sentarse(nombre);
            this.restauran.comer(nombre);
            Thread.sleep(1000);
            this.restauran.terminoComer(nombre);
        } catch (InterruptedException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
