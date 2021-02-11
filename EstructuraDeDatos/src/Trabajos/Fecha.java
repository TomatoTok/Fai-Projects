/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabajos;

/**
 *
 * @author Walter
 */
public class Fecha {
    //Atributos
    private int dia;
    private int mes;
    private int anio;
    private String fechaEntera;
    //constructores
    public Fecha(int dia, int mes, int anio){
    this.dia=dia;
    this.mes=mes;
    this.anio=anio;
    }
    public Fecha(String fecha){
        String dia="", mes="", anio="";
        for (int i = 0; i < fecha.length(); i++) {
            if (i<4) {
                dia=dia+fecha.charAt(i);
            }
            if (i>3) {
                mes=mes+fecha.charAt(i);
            }
            if (i>5) {
                anio=anio+fecha.charAt(i);
                
            }
            this.dia=Integer.parseInt(dia);
            this.mes=Integer.parseInt(mes);
            this.anio=Integer.parseInt(anio);
        }
    }
    //Propis del tipo
    private boolean validarFecha(String fecha){
        boolean valor=false;
        if (fecha.length()==8) {
            valor=true;
        }
        return valor;
    }
    public String toString(){
        return dia+"/"+mes+"/"+anio;
    }
    
}
