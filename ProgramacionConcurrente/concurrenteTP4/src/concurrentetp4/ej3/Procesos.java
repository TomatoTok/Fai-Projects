/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package concurrentetp4.ej3;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tomi
 */
public class Procesos {

    public static void main(String[] args) {
        recorrer();
    }

    public static void recorrer() {
        Semaphore p1 = new Semaphore(0);
        Semaphore p2 = new Semaphore(0);
        Semaphore p3 = new Semaphore(1);
        int recorrido = 0;
        for (int i = 0; i < 3; i++) {
            try {
                mostrar("p1 a p3");
                p3.acquire();
                p2.release();
                mostrar("p3 a p2");
                p2.acquire();
                p1.release();
                mostrar("p2 a p1");
                p1.acquire();
                p3.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(Procesos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void mostrar(String nombre) {
        System.out.println("Proceso: " + nombre);
    }

}
