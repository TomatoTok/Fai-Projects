/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package punto7;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tomi
 */
public class Cocinero extends Thread {

    private Olla olla;

    public Cocinero(Olla olla) {
        this.olla = olla;
    }

    public void run() {
        while (true) {
            this.olla.cocinar();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cocinero.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.olla.terminoCocinar();
        }
    }

}
