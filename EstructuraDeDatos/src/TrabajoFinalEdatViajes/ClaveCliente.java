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
public class ClaveCliente {
    private String tipo;
    private int dni;

    public ClaveCliente(String tipo, int unDni){
    this.tipo = tipo;
    this.dni = unDni;
    }

        public String getTipo() {
        return tipo;
    }

    public int getDni() {
        return dni;
    }
}
