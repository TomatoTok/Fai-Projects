/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProdCons;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tomi
 */
public class Buffer {
    private Semaphore extrae = new Semaphore(0);
    
    public Buffer(){
        
    }
    
    public void consumir(){
        try {
            System.out.println("Quiero Extraer");
            this.extrae.acquire();
            System.out.println("Pude Extraer");
        } catch (InterruptedException ex) {
            Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void producir(){
        System.out.println("Produzco algo");
        this.extrae.release();
    }
}
