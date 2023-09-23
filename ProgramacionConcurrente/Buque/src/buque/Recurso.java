/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buque;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erick.carus
 */
public class Recurso {

    int listaEspera = 0, autosArriba = 0, cantEspacio = 9;
    private Semaphore puedenBajar = new Semaphore(0), cantAutosArriba = new Semaphore(0), puedenSubir = new Semaphore(this.cantEspacio), mutex = new Semaphore(1);

    public Recurso() {
    }

    //metodos de auto
    public void subirBuque(String name) {
        try {
            this.mutex.acquire();
            this.listaEspera++;
            this.mutex.release();

            this.puedenSubir.acquire();
            System.out.print(name + " sube,");

            this.mutex.acquire();
            System.out.print(name + " espera arriba,");
            this.autosArriba++;
            System.out.println("autos arriba = " + this.autosArriba);
            this.mutex.release();

            this.cantAutosArriba.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(Recurso.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void bajarse(String name) {
        try {
            this.puedenBajar.acquire();
            System.out.print(name + " baja,");
        } catch (InterruptedException ex) {
            Logger.getLogger(Recurso.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
//metodos de transbordador

    public void ir() {
        try {
            if (this.autosArriba > 0 && this.listaEspera == this.autosArriba) {
                this.listaEspera = 0;
                System.out.println("");
                System.out.println("Lista de espera = " + this.listaEspera);
                this.cantAutosArriba.acquire(autosArriba);
                System.out.println("El buque sube " + autosArriba + " autos e inicia viaje.");
            } else {
                this.cantAutosArriba.acquire(this.cantEspacio);
                System.out.println("");
                System.out.println("El buque sube " + this.cantEspacio + " autos e inicia el cruce.");
                this.listaEspera = this.listaEspera - this.cantEspacio;
                System.out.println("Lista de espera = " + this.listaEspera);
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Recurso.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Volver() {
        this.puedenBajar.release(this.autosArriba);
        System.out.println(" ");
        System.out.println("Buque baja los autos y vuelve");

    }

    public boolean llegoPuerto() {
        boolean viajeTerminado = false;
        System.out.println("");
        System.out.println("Buque llega al puerto y pueden subir autos.");
        try {
            this.mutex.acquire();
            this.autosArriba = 0;
            this.mutex.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Recurso.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (this.listaEspera == 0) {
            viajeTerminado = true;
        } else {
            if (this.listaEspera < this.cantEspacio) {
                System.out.println("Se liberan " + this.listaEspera + " permisos");
                this.puedenSubir.release(this.listaEspera);
            } else {
                System.out.println("Se liberan " + this.cantEspacio + " permisos");
                this.puedenSubir.release(this.cantEspacio);

            }

        }

        return viajeTerminado;
    }

}
