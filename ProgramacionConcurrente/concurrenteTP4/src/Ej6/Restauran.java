/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej6;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tomi
 */
public class Restauran {

    private Semaphore silla = new Semaphore(1);
    private Semaphore llamarMozo = new Semaphore(0);
    private Semaphore estaComiendo = new Semaphore(0);
    private Semaphore entregarComida = new Semaphore(0);

    public Restauran() {

    }

    public void sentarse(String nombre) {//empleado
        try {
            this.silla.acquire();
            System.out.println("El empleado " + nombre + " ocupo la silla y llama al mozo");
            this.llamarMozo.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Restauran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int tomarOrden(String nombre) {//mozo
        try {
            this.llamarMozo.acquire();
            System.out.println("El Mozo " + nombre + " Atiende orden");
            this.entregarComida.release();
        } catch (Exception e) {
        }
        return 1000;
    }

    public void entregarComida() {//mozo

        try {
            this.entregarComida.acquire();
            System.out.println("Se entrega la comida");
            this.estaComiendo.release();
            this.llamarMozo.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Restauran.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void comer(String nombre) {//empleado
        try {
            this.estaComiendo.acquire();
            System.out.println("El empleado " + nombre + " está comiendo");
        } catch (Exception e) {
        }
    }

    public void terminoComer(String nombre) {//empleado
        System.out.println("El empleado " + nombre + " Termino de comer y agradecio al Mozo");
        this.silla.release();
    }

}
