/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DDA19;

/**
 *
 * @author Walter
 */
public class PuntosPorCliente {

    private int nroCliente, puntos;

    public PuntosPorCliente(int nroc) {                      //*****
        nroCliente = nroc;
        puntos = 0;
    }

    //Observadoras
    public int getNroCliente() {
        return nroCliente;
    }

    public int getPuntos() {
        return puntos;
    }

    public void MuestraDatos() {

        System.out.println("numero Cliente: " + nroCliente);
        System.out.println("Puntos: " + puntos);
    }

    public boolean equals(PuntosPorCliente ppc) {
        return PuntosPorCliente.this.equals(ppc);            
    }

    //MODIFICADORAS
    public void setPuntos(int p) {
        puntos = p;
    }

    //PROPIAS DEL TIPO
    public void sumarPuntos(int p) {
        puntos= puntos + p;                                   
    }

    public boolean canjearPuntos(int canj) {
        int resta;
        boolean aux;
        resta = puntos - canj;                 
        if (resta >= 0) {
            puntos = resta;
            aux = true;
        } else {
            aux = false;
        }
        return aux;
    }
}
