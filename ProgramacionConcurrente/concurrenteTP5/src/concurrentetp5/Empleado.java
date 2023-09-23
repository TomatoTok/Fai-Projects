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
public class Empleado extends Thread {

    private String nombre;
    private Restauran restauran;

    public Empleado(String nombre, Restauran pollosHermanos) {
        this.nombre = nombre;
        this.restauran = pollosHermanos;
    }

    public void run() {
        this.restauran.sentarse(nombre);
        queHacer();
    }

    public void queHacer() {
        int eleccion;
        eleccion = (int) Math.floor(Math.random() * 3 + 1);
        switch (eleccion) {
            case 1://solo come
                this.restauran.pedirComida(nombre);
                estoyComiendo(1);
                this.restauran.terminoComer(nombre);
                break;
            case 2://solo bebe
                this.restauran.pedirBebida(nombre);
                estoyComiendo(2);
                this.restauran.terminoBeber(nombre);
                break;
            case 3://come y bebe
                this.restauran.pedirComida(nombre);
                estoyComiendo(3);
                this.restauran.terminoComer(nombre);
                this.restauran.pedirBebida(nombre);
                estoyComiendo(3);
                this.restauran.terminoBeber(nombre);
                break;
            default:
                throw new AssertionError();
        }
    }

    public void estoyComiendo(int tipo) {
        try {
            Thread.sleep(1000);
            if (tipo == 1) {
                System.out.println(nombre + " está comiendo");
            } else {
                if (tipo == 2) {
                    System.out.println(nombre + " está bebiendo");
                } else {
                    System.out.println(nombre + " está comiendo y bebiendo");
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
