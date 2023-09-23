/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Agua;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tomi
 */
public class Generador extends Thread {

    private Recurso recurso;

    public Generador(Recurso rec) {
        this.recurso = rec;
    }

    public void generarAtomos() {
// Tambien funcionaria con un generador de atomos aleatorio ya que pregunta por
// cantidad de atomos disponibles, pero no supimos como detener a los hilos que
// nunca van a ser utilizados una vez se complete el total de envasados.
        System.out.println("==Creador de atomos en accion==");
        Hidrogeno h1 = new Hidrogeno(this.recurso);
        Oxigeno o1 = new Oxigeno(this.recurso);
        Hidrogeno h2 = new Hidrogeno(this.recurso);
        h1.start();
        o1.start();
        h2.start();
    }

    public void run() {
        boolean bucle = false; //mientras no se envase el total de agua creo atomos
        while (!bucle) {
            try {//duerme cuando genera atomos
                generarAtomos();
                Thread.sleep(2000);
                bucle = this.recurso.verificarAguaEnvasada();
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Generador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
