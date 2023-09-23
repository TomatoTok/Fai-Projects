/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej2;

/**
 *
 * @author Tomi
 */
public class Curandero extends Personaje {

    private Protagonista prota;

    public Curandero(Protagonista protagonista) {
        super();
        this.prota = protagonista;
    }

    public void curar() {
        boolean vivo = true;
        do {
            System.out.println("Hilo: " + Thread.currentThread().getName() + " Comienza Cura");
            vivo = prota.alterarVida(5);
            System.out.println("Hilo: " + Thread.currentThread().getName() + " Finaliza Cura");
        } while (vivo);
    }

public void run() {
        curar();
    }

}
