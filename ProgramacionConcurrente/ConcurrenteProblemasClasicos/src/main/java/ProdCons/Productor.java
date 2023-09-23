/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProdCons;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tomi
 */
public class Productor extends Thread{

    private Buffer buffer;

    public Productor(Buffer b) {
        this.buffer = b;
    }

    public void run() {
        while (true) {
            this.buffer.producir();
            System.out.println("Salgo de producir");
             try {
                Thread.sleep((int)Math.floor(Math.random()*(4000-1000)+1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
