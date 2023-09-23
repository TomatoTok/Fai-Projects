/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Agua;

/**
 *
 * @author Tomi
 */
public class Hidrogeno extends Thread {

    private Recurso recurso;

    public Hidrogeno(Recurso recurso) {
        this.recurso = recurso;
    }

    public void run() {
        if (recurso.Hlisto()) {
            System.out.println("Hidrogeno -> llama a hacer agua");
            recurso.hacerAgua();
        }
    }
}
