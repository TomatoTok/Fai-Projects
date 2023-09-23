/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buque;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erick.carus
 */
public class Buque extends Thread {

    private Recurso recurso;

    public Buque(Recurso recurso) {
        this.recurso = recurso;
    }

    @Override
    public void run() {

        boolean viajeTerminado = false;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Buque.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Empieza a trabajar el buque");
        try {
            while (!viajeTerminado) {
                Thread.sleep(1000);
                this.recurso.ir();
                Thread.sleep(2000);
                this.recurso.Volver();
                Thread.sleep(2000);
                viajeTerminado = this.recurso.llegoPuerto();
            }
            System.out.println("No hay mas autos esperando y se terminan los viajes.");

        } catch (InterruptedException ex) {
            Logger.getLogger(Buque.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
