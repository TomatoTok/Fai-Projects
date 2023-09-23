/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3_hamster;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tomi
 */
public class Hamster extends Thread {

    private Rueda rueda;
    private Hamaca hamaca;
    private Plato plato;
    private String nombre;
    private boolean usoRueda = false, usoHamaca = false, usoPlato = false;

    public Hamster(Rueda rueda, Hamaca hamaca, Plato plato, String nombre) {
        this.rueda = rueda;
        this.hamaca = hamaca;
        this.plato = plato;
        this.nombre = nombre;
    }

    public void run() {
        while (!usoRueda || !usoHamaca || !usoPlato) {
            if (!usoRueda && this.rueda.usarRueda()) {

                System.out.println(this.nombre + " esta usando la rueda.");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Hamster.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.rueda.dejarRueda();
                System.out.println(this.nombre + " dejo de usar la rueda.");
                this.usoRueda = true;
            }
            if (!usoHamaca && this.hamaca.usarHamaca()) {
                System.out.println(this.nombre + " esta usando la hamaca.");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Hamster.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(this.nombre + " dejo de usar la hamaca.");
                this.hamaca.dejarHamaca();
                this.usoHamaca = true;
            }
            if (!usoPlato && this.plato.usarPlato()) {

                System.out.println(this.nombre + " esta usando el plato.");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Hamster.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.plato.dejarPlato();
                System.out.println(this.nombre + " dejo de usar el plato.");
                this.usoPlato = true;
            }

        }
        System.out.println(nombre + " uso todas las cosas");

    }

}
