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
public class Tecnico extends Empleado {
        protected String titulo;
        protected int adicional;
        
        public Tecnico(){
            
        }
        public Tecnico(String nombre, int dni, String direccion, String fecNac, String funcion, int salario, int legajo, int antiguedad,String titulo, int adicional){
            super(nombre, dni, direccion, fecNac,funcion,salario,legajo,antiguedad);
            this.titulo=titulo;
            this.adicional=adicional;
        }

    public String getTitulo() {
        return titulo;
    }

    public int getAdicional() {
        return adicional;
    }
        
}
