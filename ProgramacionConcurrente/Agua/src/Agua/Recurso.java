/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Agua;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tomi
 */
public class Recurso {

    private int topeRecipiente;
    private int aguaActual = 0;
    private int aguaEnvasada = 0;
    private int totalAguaEnvasar;
    private Semaphore cuentas = new Semaphore(1);
    private Semaphore Olisto = new Semaphore(0);//indican que se pueden usar
    private Semaphore Hlisto = new Semaphore(0);//indican que se pueden usar
    private int Oesperando = 0;//mantiene al hilo hasta que se usa
    private int Hesperando = 0;//mantiene al hilo hasta que se usa

    public Recurso(int tope, int total) {
        this.topeRecipiente = tope;
        this.totalAguaEnvasar = total;
    }

    public boolean Olisto() {
        boolean listo = false;
        try {
            this.cuentas.acquire();
            this.Oesperando++;
            this.cuentas.release();
            listo = puedoHacerAgua();
            System.out.println("Oxigeno -> Se creo y espera");
            this.Olisto.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Recurso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listo;
    }

    public boolean Hlisto() {
        boolean listo = false;
        try {
            this.cuentas.acquire();
            this.Hesperando++;
            this.cuentas.release();
            listo = puedoHacerAgua();
            System.out.println("Hidrogeno -> se creo y espera");
            this.Hlisto.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Recurso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listo;
    }

    public boolean puedoHacerAgua() {
        boolean listoElAgua = false;
        try {
            this.cuentas.acquire();
            if (this.Oesperando >= 1 && this.Hesperando >= 2) {
                System.out.println("es posible la fusion de atomos");
                listoElAgua = true;
                this.Oesperando--;//ya no esperan
                this.Hesperando--;
                this.Hesperando--;
                this.Hlisto.release(2);
                this.Olisto.release();
            }
            this.cuentas.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Recurso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listoElAgua;
    }

    public void hacerAgua() {
        try {
            this.cuentas.acquire();
            System.out.println("Se fusionan los atomos y se hace agua");
            this.aguaActual++;
            if (this.topeRecipiente == this.aguaActual) {
                System.out.println("Se completo un recipiente, se envasa y se vacia el recipiente");
                this.aguaEnvasada++;
                this.aguaActual = 0;
            }
            this.cuentas.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Recurso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean verificarAguaEnvasada() {//Si se completo la cantidad de agua envasada entonce se detiene
        boolean termino = false;
        try {
            this.cuentas.acquire();
            if (this.totalAguaEnvasar == this.aguaEnvasada) {
                System.out.println("Se completo el envasado total");
                termino = true;
            }
            this.cuentas.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Recurso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return termino;
    }
}
