/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3_hamster;

/**
 *
 * @author Tomi
 */
public class main {

    public static void main(String[] args) {
        Rueda rueda = new Rueda();
        Plato plato = new Plato();
        Hamaca hamaca = new Hamaca();
        int cantHilos = 2;

        Hamster[] arr = crearHilos(cantHilos, rueda, plato, hamaca);

        for (int i = 0; i < cantHilos; i++) {
            arr[i].start();

        }
        for (int i = 0; i < cantHilos; i++) {
            try {
                arr[i].join();
            } catch (InterruptedException ex) {
            }

        }

    }

    public static Hamster[] crearHilos(int canHilos, Rueda rueda, Plato plato, Hamaca hamaca) {
        Hamster[] arr = new Hamster[canHilos];
        for (int i = 0; i < canHilos; i++) {
            int j = i + 1;
            arr[i] = new Hamster(rueda, hamaca, plato, "hilo " + j);
        }
        return arr;
    }
}

