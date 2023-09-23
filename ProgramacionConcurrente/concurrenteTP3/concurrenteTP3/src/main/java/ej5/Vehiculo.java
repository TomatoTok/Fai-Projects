/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej5;

/**
 *
 * @author tbascal
 */
public class Vehiculo extends Thread {
    private String patente;
    private String modelo;
    private String marca;
    private int km;

    public Vehiculo(String patente, String modelo, String marca, int km) {
        this.patente = patente;
        this.modelo = modelo;
        this.marca = marca;
        this.km = km;
    }
    public Vehiculo(){
        
    }

    public String getPatente() {
        return patente;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public int getKm() {
        return km;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setKm(int km) {
        this.km = km;
    }
    
}

