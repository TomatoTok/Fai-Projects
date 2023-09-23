/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tomi
 */
public class Jaula {

    private Semaphore plato = new Semaphore(1);
    private Semaphore rueda = new Semaphore(1);
    private Semaphore hamaca = new Semaphore(1);

    public Jaula() {

    }

    public boolean usarPlato(String nombre) {
        boolean loUse = false;
        if (this.plato.tryAcquire()) {
            System.out.println(nombre + "-> Uso el plato");
            loUse = true;
        }
        return loUse;
    }

    public boolean usarRueda(String nombre) {
        boolean loUse = false;
        if (this.rueda.tryAcquire()) {
            System.out.println(nombre + "-> Uso la Rueda");
            loUse = true;
        }
        return loUse;
    }

    public boolean usarHamaca(String nombre) {
        boolean loUse = false;
        if (this.hamaca.tryAcquire()) {
            System.out.println(nombre + "-> Uso la Hamaca");
            loUse = true;
        }
        return loUse;
    }

    public void soltarHamaca(String nombre) {
        System.out.println(nombre + "-> solto la Hamaca");
        this.hamaca.release();
    }

    public void soltarPlato(String nombre) {
        System.out.println(nombre + "-> solto el plato");
        this.plato.release();
    }

    public void soltarRueda(String nombre) {
        System.out.println(nombre + "-> solto la rueda");
        this.rueda.release();

    }
}
