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
abstract class Empleado extends Persona{
    protected String funcion;
    protected int salario;
    protected int legajo;
    protected int antiguedad;
    
    public Empleado() {

    }

    public Empleado(String nombre, int dni, String direccion, String fecNac, String funcion, int salario, int legajo, int antiguedad) {
        super(nombre, dni, direccion, fecNac);
        this.funcion = funcion;
        this.salario = salario;
        this.legajo = legajo;
        this.antiguedad = antiguedad;
    }
    
    public int getAntiguedad(){
        return this.antiguedad;
    }

    public String getFuncion() {
        return funcion;
    }

    public int getSalario() {
        return salario;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    
    public String toString() {
        String result = super.toString();
        result += "Funcion: "+this.funcion+"\n";
        result += "Salario: "+this.salario+"\n";
        result += "Antiguedad: "+this.antiguedad+"\n";
        return result;
    }
}


