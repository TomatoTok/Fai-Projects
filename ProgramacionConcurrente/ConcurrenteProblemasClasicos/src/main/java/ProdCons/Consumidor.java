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
public class Consumidor extends Thread{
    private Buffer buffer;
    public Consumidor(Buffer b){
        this.buffer = b;
    }
    public void run(){
        while(true){
            buffer.consumir();
            System.out.println("Salgo de consumir");
            try {
                Thread.sleep((int)Math.floor(Math.random()*(4000-1000)+1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
