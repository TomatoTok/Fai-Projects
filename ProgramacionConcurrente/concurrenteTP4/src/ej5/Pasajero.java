/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej5;

/**
 *
 * @author Tomi
 */
public class Pasajero extends Thread{
private Taxi taxi;
private String nombre;
    public Pasajero(Taxi taxi, String nombre){
        this.taxi = taxi;
        this.nombre = nombre;
    }
    public void run(){
        this.taxi.subirTaxi(this.nombre);
        this.taxi.pagarViaje(this.nombre);
    }
}
