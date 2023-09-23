/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej2;

/**
 *
 * @author Tomi
 */
public class Orco extends Personaje {

    private Protagonista protagonista;

    public Orco(Protagonista prota) {
        super();
        this.protagonista = prota;
    }

    public void atacar() {
        boolean vivo = true;
        do {
            System.out.println("Hilo: " + Thread.currentThread().getName() + " Comienza ataque");
            vivo = protagonista.alterarVida(-15);
            System.out.println("Hilo: " + Thread.currentThread().getName() + " Finaliza ataque");
        } while (vivo);
    }

    public void run() {
        atacar();
    }

}
