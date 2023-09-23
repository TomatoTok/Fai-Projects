/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package concurrentetp5;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tomi
 */
public class Cocinero extends Thread{//se encarga de la comida

    private String nombre;
    private Restauran resto;
    private int cantidad;

    public Cocinero(String name, Restauran res, int cantidadClientes) {
        this.nombre = name;
        this.resto = res;
        this.cantidad = cantidadClientes;
    }

    public void run() {
        try {
            int n = 0;
            while(n <= this.cantidad){
                
            resto.prepararComida();
            Thread.sleep(1000);
            this.resto.entregarComida();
            n++;
}
        } catch (InterruptedException ex) {
            Logger.getLogger(Mozo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
