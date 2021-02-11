/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final;

/**
 *
 * @author Walter
 */
public class Avion {
        private String modelo;
        private int kmrecorrido;
        private int cantidadAsientos;
        private int velocidadPromedio;
        
        public Avion(String mod, int km,int cantA, int velProm){
        modelo=mod;
        kmrecorrido=km;
        cantidadAsientos=cantA;
        velocidadPromedio=velProm;
        }
        public String getModelo(){
        return modelo;
        }
        public int getkmrecorrido(){
        return kmrecorrido;
        }
        public int getcantA(){
        return cantidadAsientos;
        }
        public int getVelProm(){
        return velocidadPromedio;
        } 
        public String toString(){
        String aux;
        aux="Modelo: "+modelo+" Km Recorridos: "+kmrecorrido+ " Cantidad de asientos: "+cantidadAsientos+" Velocidad Promedio: "+velocidadPromedio;
        return aux;
        }
        public boolean equals(Avion o){
        boolean aux=false;
            if (modelo.equalsIgnoreCase(o.getModelo())) {
                aux=true;
            }
            return aux;
        }
}
