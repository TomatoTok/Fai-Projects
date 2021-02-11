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
public class Aeropuertos {
    private String nomAeronautico;
    private String ciudad;
    private int telefono;

    public Aeropuertos(String nomAeronautico, String ciudad, int telefono) {
        this.nomAeronautico = nomAeronautico;
        this.ciudad = ciudad;
        this.telefono = telefono;
    }

    public String getNomAeronautico() {
        return nomAeronautico;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
}
