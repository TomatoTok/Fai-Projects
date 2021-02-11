/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoFinalEdatViajes;

/**
 *
 * @author Walter
 */
public class Cliente {
    
    private ClaveCliente clave;
    private String nomYape;
    private int fecNacimiento;
    private String domicilio;
    private int telefono;
    
    public Cliente(String tipo,int numDni,String nombre,int nac,String dom, int tel){
    this.clave = new ClaveCliente(tipo,numDni);
    this.nomYape = nombre;
    this.fecNacimiento = nac;
    this.domicilio = dom;
    this.telefono = tel;
    }

    public void setFecNacimiento(int fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public ClaveCliente getClave() {
        return clave;
    }

    public String getNomYape() {
        return nomYape;
    }

    public int getFecNacimiento() {
        return fecNacimiento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public int getTelefono() {
        return telefono;
    }
    
}
