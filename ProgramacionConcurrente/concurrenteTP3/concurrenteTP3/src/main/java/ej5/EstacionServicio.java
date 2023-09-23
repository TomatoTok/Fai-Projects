/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej5;

/**
 *
 * @author tbascal
 */
public class EstacionServicio {
    
    private Surtidor surtidor;
    
    public EstacionServicio(Surtidor sur){
        this.surtidor = sur;
    }
    
    public synchronized boolean usarSurtidor(int litros){
        boolean quedaCombustible = true;
        if (this.surtidor.getCombustible() < 0) {
            System.out.println("El Surtidor está vacio");
            quedaCombustible = false;
        } else {
            boolean puedoEntrar;
            do{
                puedoEntrar = surtidor.getUso();
            if(puedoEntrar){//Si es true significa que yo lo estoy ocupando
                System.out.println("El hilo: " + Thread.currentThread().getName() + " empieza carga");
            this.surtidor.cargarCombustible(10);
                System.out.println("El hilo: " + Thread.currentThread().getName() + " finaliza carga");
            this.surtidor.imprimir();
            }            
            }while(!puedoEntrar);
        }
         return quedaCombustible;
    }
    
    
    
/* 
 private void utilizarSurtidor(){
     surt1.cargarCombustible(10);
     System.out.println("El hilo: "+Thread.currentThread().getName()+" realizo carga");
     System.out.println("El surtidor aun le queda"+ surt1.getCombustible());
     if(surt1.getCombustible() < 0){
         System.out.println("El Surtidor está vacio");
     }
 }
 
 public void run(){
     utilizarSurtidor();
 }*/
 
}
