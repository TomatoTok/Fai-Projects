/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perrosYgatos;

/**
 *
 * @author Tomi
 */
public class Michi extends Thread{

    private Comedor comedor;

    public Michi(Comedor c) {
        this.comedor = c;
    }

    public void run() {
        try {
            this.comedor.comerGatos();
            Thread.sleep(1000);
            this.comedor.terminoComerGatos();
        } catch (Exception e) {
        }
    }
}
