/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buque;

/**
 *
 * @author erick.carus
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Recurso recurso=new Recurso();
        int cantHilos=30;
        Auto[] autos=crearHilos(cantHilos,recurso);
        Buque buque=new Buque(recurso);
        
        
        for (int i = 0; i < cantHilos; i++) {
            autos[i].start();
            
        }
        buque.start();
        
        
    }
    public static Auto[] crearHilos(int canHilos, Recurso recurso) {
        Auto[] arr = new Auto[canHilos];
        for (int i = 0; i < canHilos; i++) {
            int j = i + 1;
            arr[i] = new Auto(recurso,"A"+i);
        }
        return arr;
    }
    
}
