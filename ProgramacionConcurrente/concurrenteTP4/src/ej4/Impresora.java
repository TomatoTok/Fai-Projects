/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej4;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tomi
 */
public class Impresora {

    private Semaphore usando = new Semaphore(1);
    private char tipo;
    boolean ocupado = false;

    public Impresora(char tipo) {
        this.tipo = tipo;
    }

    public synchronized Semaphore getUsando() {
        return usando;
    }

    public char getTipo() {
        return tipo;
    }

    public void usar() {
        try {
            usando.acquire();
            imprimirUso();
            Thread.sleep(1000);
            imprimirDeshuso();
            usando.release();
            this.ocupado = false;
        } catch (InterruptedException ex) {
            Logger.getLogger(Impresora.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void imprimirUso() {
        System.out.println("Se empezo a usar la maquina " + tipo);
    }

    private void imprimirDeshuso() {
        System.out.println("Hilo-> "+Thread.currentThread().getName()+" libero la maquina " + tipo);
    }

    public synchronized boolean seEstaUsando() {
        boolean enUso = false;
        if (!this.ocupado) {
            this.ocupado = true;
            enUso = true;
        }
        return enUso;
    }
}
