/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej5;

/**
 *
 * @author tbascal
 */
public class elMain {

    public static void main(String[] args) {
        int cantAutos = 6;
        int cantSurtidores = 4;
        Surtidor surtidores[] = crearSurtidores(cantSurtidores);
        Auto autitos[] = crearHilosAuto(cantAutos,surtidores);
        arrancarAutitos(autitos);
    }

    public static Auto[] crearHilosAuto(int cantHilos, Surtidor surtidores[]) {//Metodo para crear autitos
        String colores[] = {"rojo", "verde", "azul", "blanco", "marron", "negro", "violeta"};
        Auto autitos[] = new Auto[cantHilos];
        for (int i = 0; i < cantHilos; i++) {
            autitos[i] = new Auto(surtidores, colores[i]);
        }
        return autitos;
    }

    public static Surtidor[] crearSurtidores(int cantSurtidores) {
        Surtidor surti[] = new Surtidor[cantSurtidores];
        for (int i = 0; i < cantSurtidores; i++) {
            surti[i] = new Surtidor(i + 1);
        }
        return surti;
    }

    public static void arrancarAutitos(Auto todosAutitos[]) { //Metodo para arrancar autitos
        for (int i = 0; i < todosAutitos.length; i++) {
            todosAutitos[i].start();
        }
    }
}
