/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Agua;

/**
 *
 * @author Tomi
 */
public class Oxigeno extends Thread {

    private Recurso recurso;

    public Oxigeno(Recurso recurso) {
        this.recurso = recurso;
    }

    public void run() {
        if (recurso.Olisto()) {
            System.out.println("Oxigeno -> llama a hacer agua");
            recurso.hacerAgua();
        }
    }
}
