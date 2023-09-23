/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej2;

/**
 *
 * @author Tomi
 */
public class elMain {

    public static void main(String[] args) {
        Protagonista prota = new Protagonista();
        Curandero cura = new Curandero(prota);
        Orco orco = new Orco(prota);
        cura.start();
        orco.start();

    }
}
