/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej5;

/**
 *
 * @author tbascal
 */
public class Surtidor{
    private int cantCombustible = 50;
    private boolean estaEnUso =  false;
    private int numero;
    public Surtidor(int numero) {//Constructor
        this.numero = numero;
    }
    
    public synchronized int cargarCombustible(int aConsumir){ //Recurso compartido
        this.estaEnUso = false;
        int combustible = 0;
        if(this.cantCombustible - aConsumir >= 0){
            this.cantCombustible -= aConsumir;
            combustible = 10;
            imprimir();
        }else{
            System.out.println("(Surtidor #"+this.numero+")No es posible hacer la recarga, no hay combustible");
        }
        return combustible;
    }
    public synchronized void imprimir(){
         System.out.println("(Surtidor #"+this.numero+") Aun le queda: " + getCombustible());
    }
    public synchronized int getCombustible(){
        //System.out.println("El hilo "+Thread.currentThread().getName()+" Esta consultando el combustible.");
        return this.cantCombustible;
    }
    public synchronized boolean getUso(){//falso semaforo :'v
        boolean estoyUsando = false;
        if(!this.estaEnUso){
            this.estaEnUso = true;
            estoyUsando = true;
        }
        return estoyUsando;
    }
}
