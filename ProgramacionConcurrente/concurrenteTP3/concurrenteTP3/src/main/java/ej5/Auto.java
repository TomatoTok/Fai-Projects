/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej5;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tbascal
 */
public class Auto extends Vehiculo {

    private boolean reserva = true;
    private Surtidor surtidor[];
    private String color;
    private int tanque = 0;

    public Auto(String patente, String modelo, String marca, int km) {
        super(patente, modelo, marca, km);
    }

    public Auto(Surtidor sur[], String color) {
        this.surtidor = sur;
        this.color = color;
    }

    private void utilizarSurtidor(int numSurtidor) {

        if (this.surtidor[numSurtidor].getCombustible() < 0) {
            System.out.println("El Surtidor está vacio");
        } else {
            boolean puedoEntrar;
            do {
                puedoEntrar = surtidor[numSurtidor].getUso();
                if (puedoEntrar) {//Si es true significa que yo lo estoy ocupando
                    System.out.println("El auto: " + this.color + " empieza carga");
                    this.tanque += this.surtidor[numSurtidor].cargarCombustible(10);
                    System.out.println("El auto: " + this.color + " finaliza carga");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    Logger.getLogger(Auto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } while (!puedoEntrar);
        }
    }

    public void run() {
      int numSurtidor=quedaCombustible();
        while(numSurtidor != -1){
          utilizarSurtidor(numSurtidor);
          numSurtidor = quedaCombustible();
        }
        System.out.println("(Auto "+this.color+") cantidad de combustible final:"+this.tanque);
    }
    
    public int quedaCombustible(){
        int queda = -1;
        for (int i = 0; i < this.surtidor.length; i++) {
            if(this.surtidor[i].getCombustible() > 0){
                queda = i;
                i = this.surtidor.length-1;
            }
        }
        return queda;
    }
}


/* Modelo para 1 solo surtidor

    private boolean reserva = true;
    private Surtidor surtidor[];
    private String color;

    public Auto(String patente, String modelo, String marca, int km) {
        super(patente, modelo, marca, km);
    }

    public Auto(Surtidor sur[], String color) {
        this.surtidor = sur;
        this.color = color;
    }

    private void utilizarSurtidor() {

        if (this.surtidor.getCombustible() < 0) {
            System.out.println("El Surtidor está vacio");
        } else {
            boolean puedoEntrar;
            do{
                puedoEntrar = surtidor.getUso();
            if(puedoEntrar){//Si es true significa que yo lo estoy ocupando
                System.out.println("El auto: " + this.color + " empieza carga");
            this.surtidor.cargarCombustible(10);
                System.out.println("El auto: " + this.color + " finaliza carga");
            //this.surtidor.imprimir();
            }            
            }while(!puedoEntrar);
        }
    }

    public void run() {
        utilizarSurtidor();
    }
 */
