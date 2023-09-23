/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filosofos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tomi
 */
public class Filosofo extends Thread {

    private Tenedor izquierdo;
    private Tenedor derecho;
    private String nombre;
    private char tenedorInicial;
    private int seSirve = 2;

    public Filosofo(Tenedor izquierdo, Tenedor derecho, String nombre, char tenedorInicial) {
        this.izquierdo = izquierdo;
        this.derecho = derecho;
        this.nombre = nombre;
        this.tenedorInicial = tenedorInicial;
    }

    public void run() {
        if (tenedorInicial == 'I') {
            tomarIzquierdo();
        } else {
            tomarDerecho();
        }
    }

    public void tomarIzquierdo() {
        int servir = 0;
        while (servir <= seSirve) {
            try {
                this.izquierdo.agarrar(nombre);
                this.derecho.agarrar(nombre);
                System.out.println("El filosofo " + nombre + " Esta comiendo");
                Thread.sleep(1000);
                System.out.println("El filosofo " + nombre + " Termino de comer");
                System.out.println("El filosofo " + nombre + " Esta pensando");
                servir = servir + 1;
                this.izquierdo.soltar(nombre);
                this.derecho.soltar(nombre);
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void tomarDerecho() {
        int servir = 0;
        while (servir <= seSirve) {
            try {
                this.derecho.agarrar(nombre);
                this.izquierdo.agarrar(nombre);
                System.out.println("El filosofo " + nombre + " Esta comiendo");
                Thread.sleep(1000);
                System.out.println("El filosofo " + nombre + " Termino de comer");
                System.out.println("El filosofo " + nombre + " Esta pensando");
                servir = servir + 1;
                this.derecho.soltar(nombre);
                this.izquierdo.soltar(nombre);
                Thread.sleep(2000);

            } catch (InterruptedException ex) {
                Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
