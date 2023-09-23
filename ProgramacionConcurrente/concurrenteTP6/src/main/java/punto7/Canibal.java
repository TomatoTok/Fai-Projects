/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package punto7;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tomi
 */
public class Canibal extends Thread{

    private Olla ollaPopular;
    private String nombre;
     public Canibal(Olla olla, String nombre){
         this.ollaPopular = olla;
         this.nombre = nombre;
     }
     
     public void run(){
         this.ollaPopular.comer(this.nombre);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Canibal.class.getName()).log(Level.SEVERE, null, ex);
        }
         this.ollaPopular.terminoComer(nombre);
     }
   
}
