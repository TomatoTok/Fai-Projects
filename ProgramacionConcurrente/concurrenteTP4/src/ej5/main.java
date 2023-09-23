/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej5;

/**
 *
 * @author Tomi
 */
public class main {
    public static void main(String[] args) {
        Taxi taxi = new Taxi();
        Taxista taxista = new Taxista(taxi,5);
        taxista.start();
        crearPasajeros(taxi);
        
    }
    
    public static void crearPasajeros(Taxi taxi){
       Pasajero pas[] = new Pasajero[5]; 
        for (int i = 0; i < 5; i++) {
            pas[i] = new Pasajero(taxi,""+i);
        }
        for (int i = 0; i < 5; i++) {
            pas[i].start();
        }
    }
}
