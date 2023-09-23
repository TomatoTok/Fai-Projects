/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buque;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erick.carus
 */
public class Auto extends Thread {

    private Recurso recurso;
    private String name;

    public Auto(Recurso recurso, String name) {
        this.recurso = recurso;
        this.name = name;
    }

    

    public void run() {
        this.recurso.subirBuque(name);
        this.recurso.bajarse(name);

    }

}
