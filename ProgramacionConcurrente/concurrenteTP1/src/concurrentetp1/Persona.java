/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrentetp1;

/**
 *
 * @author tomasbascal
 */
abstract class Persona {
    protected String nombre;
    protected int dni;
    protected String direccion;
    protected String fechaNacimiento;
    
    public Persona(){
        
    }
    public Persona(String nombre, int dni, String direccion, String fecNac){
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.fechaNacimiento = fecNac;
    }
    
    public String toString() {
        String result = "";
        result += "Nombre: "+this.nombre+"\n";
        result += "DNI: "+this.dni+"\n";
        result += "Direccion: "+this.direccion+"\n";
        result += "Fecha nacimiento: "+this.fechaNacimiento+"\n";
        return result;
    }
    
    
    
}
