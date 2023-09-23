/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package concurrentetp5;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tomi
 */
public class Restauran {

    private Semaphore silla = new Semaphore(2);
    private Semaphore estaBebiendo = new Semaphore(0);
    private Semaphore estaComiendo = new Semaphore(0);
    private Semaphore pedirComida = new Semaphore(0);
    private Semaphore comidaLista = new Semaphore(0);    
    private Semaphore pedirBebida = new Semaphore(0);
    private Semaphore bebidaLista = new Semaphore(0);


    public Restauran() {

    }

    //SILLA
    public void sentarse(String nombre) {//empleado
        try {
            this.silla.acquire();
            System.out.println("El empleado " + nombre + " ocupo la silla y solicita ser atendido");
        } catch (InterruptedException ex) {
            Logger.getLogger(Restauran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //COMER
    public void pedirComida(String nombre) {
        try {
            System.out.println("El empleado " + nombre + " solicita comida");
            this.pedirComida.release();//pide comida
            this.comidaLista.acquire();//empleado queda esperando la comida
            System.out.println("El empleado " + nombre + " recibio la comida");
        } catch (Exception e) {
        }
    }

    public void prepararComida() {
        try {
            this.pedirComida.acquire();//espera a que pidan comida
            System.out.println("Cocinero prepara la comida");
        } catch (InterruptedException ex) {
            Logger.getLogger(Restauran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void entregarComida() {
        System.out.println("Comida lista");
        this.comidaLista.release();//entrega la comida
    }

/*    public void comer(String nombre) {//empleado
        try {
            this.estaComiendo.acquire();
            System.out.println("El empleado " + nombre + " está comiendo");
        } catch (Exception e) {
        }
    }
*/
    public void terminoComer(String nombre) {//empleado
        System.out.println("El empleado " + nombre + " Termino de comer y agradecio al Cocinero");
        this.silla.release();
    }

    //BEBIDA
    public void pedirBebida(String nombre) {
        try {
            System.out.println("El empleado " + nombre + " solicita una bebida");
            this.pedirBebida.release();//libera pedido de bebida
            this.bebidaLista.acquire();
            System.out.println("El empleado " + nombre + " recibio la bebida");
        } catch (Exception e) {
        }
    }

    public void prepararBebida() {
        try {
            this.pedirBebida.acquire();
            System.out.println("Mozo prepara la bebida");
        } catch (InterruptedException ex) {
            Logger.getLogger(Restauran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void entregarBebida() {
        System.out.println("Bebida lista");
        this.bebidaLista.release();
    }

  /*  public void tomar(String nombre) {//empleado
        try {
            this.estaBebiendo.acquire();
            System.out.println("El empleado " + nombre + " está tomando");
        } catch (Exception e) {
        }
    }
*/
    public void terminoBeber(String nombre) {
        System.out.println("El empleado " + nombre + " Termino de beber y agradecio al Mozo");
        this.silla.release();
    }
}
