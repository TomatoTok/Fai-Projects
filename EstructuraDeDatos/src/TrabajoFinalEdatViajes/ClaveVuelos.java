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
public class ClaveVuelos {
    private String compania;
    private int numeroVuelo;
    
    public ClaveVuelos(String clave){
    this.compania = obtenerCompania(clave);
    this.numeroVuelo = obtenerNumVuelo(clave);
    }
    private String obtenerCompania(String clave){
        //Metodo privado que obtiene la nomenclatura de la compania
    String comp= clave.substring(0,1);   
    return comp;
    }
    
    private int obtenerNumVuelo(String clave){
        //Metodo privado que obtiene los numeros del vuelo
    String aux = clave.substring(2, 6);
    int num = Integer.parseInt(aux);
    return num;
    }
}
