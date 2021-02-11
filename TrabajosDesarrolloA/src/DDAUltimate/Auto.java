/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DDAUltimate;

/**
 *
 * @author Walter
 */
public class Auto {
    
    private String patente;
    private int cuentKm;
    private String modelo;
    private boolean disponible;
    
    public Auto(String pat){
    patente = pat;
    }
    public Auto(String pat, int km, String mod, boolean dispo){
    patente=pat;
    cuentKm=km;
    modelo=mod;
    disponible=dispo;
    }
    public void setCuentaKm(int km){
    cuentKm=km;
    }
    public void setModelo(String mod){
    modelo=mod;
    }
    public void setDisponible(boolean disp){
    disponible=disp;
    }
    public String getPatente(){
    return patente;}
    public int cuentaKm(){
    return cuentKm;}
    public String getModelo(){
    return modelo;}
    public boolean getDisponible(){
    return disponible;}
    public String toString(){
        String aux="";
        if (disponible) {
            aux= " Si";}
        else{aux=" No";}
        return "Numero de patente:"+this.patente+" Cantidad de KM:"+this.cuentKm+" Modelo:"+this.modelo+" Disponible:"+aux;
    }
    
}
