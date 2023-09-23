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
public class Administrativo extends Empleado{
    protected String categoria;
    protected int adicional;
    
    public Administrativo() {

    }

    public Administrativo(String nombre, int dni, String direccion, String fecNac, String funcion, int salario, int legajo, int antiguedad,String categoria, int adicional) {
        super(nombre, dni, direccion, fecNac,funcion,salario,legajo,antiguedad);
        this.categoria = categoria;
        this.adicional = adicional;
    }
}
