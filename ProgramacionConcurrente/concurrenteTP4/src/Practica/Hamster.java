/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tomi
 */
public class Hamster extends Thread {

    boolean rueda = false;
    boolean hamaca = false;
    boolean plato = false;
    String nombre;
    private Jaula jaula;

    public Hamster(String name, Jaula j) {
        this.nombre = name;
        this.jaula = j;
    }

    public void run() {
        hacerACtividades();
    }

    private void hacerACtividades() {
        boolean hiceTodo = false;
        while (!hiceTodo) {
            if (!rueda && this.jaula.usarRueda(nombre)) {
                try {
                    this.rueda = true;
                    Thread.sleep(1000);
                    this.jaula.soltarRueda(nombre);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Hamster.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (!hamaca && this.jaula.usarHamaca(nombre)) {
                try {
                    this.hamaca = true;
                    Thread.sleep(1000);
                    this.jaula.soltarHamaca(nombre);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Hamster.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (!plato && this.jaula.usarPlato(nombre)) {
                try {
                    this.plato = true;
                    Thread.sleep(1000);
                    this.jaula.soltarPlato(nombre);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Hamster.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (this.rueda && this.hamaca && this.plato) {
                hiceTodo = true;
                System.out.println(nombre + "-> Hizo todo");
            }
        }
    }
}
