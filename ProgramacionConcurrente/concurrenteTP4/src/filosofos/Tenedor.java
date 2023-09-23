/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filosofos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tomi
 */
public class Tenedor {
    private Semaphore tenedor = new Semaphore(1);
    private String nombre;
    public Tenedor(String nombre){
        this.nombre = nombre;
    }
    
    public void agarrar(String nombre){
        try {
            this.tenedor.acquire();
            System.out.println("El filosofo "+nombre+" Tomo el tenedor "+this.nombre);
        } catch (InterruptedException ex) {
            Logger.getLogger(Tenedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void soltar(String nombre){
        System.out.println("El filosofo "+nombre+" Soltó el tenedor "+this.nombre);
        this.tenedor.release();
    }
}
