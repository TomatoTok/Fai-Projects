/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perrosYgatos;

/**
 *
 * @author Tomi
 */
public class Doggy extends Thread{
    private Comedor comedor;

    public Doggy(Comedor c) {
        this.comedor = c;
    }

    public void run() {
        try {
            this.comedor.comerPerros();
            Thread.sleep(1000);
            this.comedor.terminoComerPerros();
        } catch (Exception e) {
        }
    }
}
