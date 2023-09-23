/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package punto7;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tomi
 */
public class Olla {//Recurso compartido

    private int porcionesPorVez;
    private int porcionesEnOlla;
    private int quierenComer = 0;
    private boolean seAvisoAlCocinero = false;
    private int totalAcomer = 0;
    private Lock lock1 = new ReentrantLock(true);
    private Lock mutex = new ReentrantLock();
    private Condition esperaComida = lock1.newCondition();
    private Condition prepararComida = lock1.newCondition();

    public Olla(int porciones) {
        this.porcionesPorVez = porciones;
        this.porcionesEnOlla = porciones;

    }

    public void comer(String nombre) {
        lock1.lock();
        this.quierenComer++;
        while (this.porcionesEnOlla == 0) {
            try {
                if (!this.seAvisoAlCocinero) {
                    System.out.println("No hay comida");
                    System.out.println("El canibal " + nombre + " le avisa al cocinero");
                    this.seAvisoAlCocinero = true;//se le aviso.
                    prepararComida.signal();
                }
                this.esperaComida.await();
            } catch (InterruptedException ex) {
                Logger.getLogger(Olla.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.porcionesEnOlla--;
        System.out.println("El canibal " + nombre + " Se sirve comida y se retira, quedan:" + this.porcionesEnOlla + " porciones en la olla");
        this.esperaComida.signal();
        lock1.unlock();
    }

    public void terminoComer(String nombre) {
        lock1.lock();
        System.out.println("El canibal " + nombre + " termino su porcion.");
        lock1.unlock();
    }

    public void cocinar() {
        lock1.lock();
        while (this.porcionesEnOlla != 0) {
            try {
                System.out.println("Aun hay comida en la olla, no cocino");
                this.prepararComida.await();
            } catch (InterruptedException ex) {
                Logger.getLogger(Olla.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("El cocinero se dispone a preparar la comida.");
        lock1.unlock();
    }

    public void terminoCocinar() {
        lock1.lock();
        this.porcionesEnOlla = this.porcionesPorVez;
        this.seAvisoAlCocinero = false;
        System.out.println("El cocinero termino de cocinar");
        this.esperaComida.signal();
        lock1.unlock();
    }

}
