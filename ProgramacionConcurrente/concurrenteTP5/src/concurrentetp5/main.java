/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package concurrentetp5;

import concurrentetp5.Empleado;
import concurrentetp5.Mozo;
import concurrentetp5.Restauran;

/**
 *
 * @author Tomi
 */
public class main {

    public static void main(String[] args) {
        Restauran pollosHermanos = new Restauran();
        Empleado emp = new Empleado("Martin", pollosHermanos);
        Empleado emp1 = new Empleado("Tomas", pollosHermanos);
        Empleado emp2 = new Empleado("Santi", pollosHermanos);

        Mozo mozo = new Mozo("mozo 1", pollosHermanos,3);
        Cocinero coc = new Cocinero("cocinero", pollosHermanos,3);

        coc.start();
        mozo.start();
        emp.start();
        emp1.start();
        emp2.start();
    }
    //FUNCIONA PERO NO TERMINA NUNCA LA EJECUCION, NOSE COMO DARLE FIN PQ NOSE CUANTOS
    //VAN A COMER CUANTOS A TOMAR Y NO QUIERO QUE QUEDEN CICLANDO EN ESPERA ACTIVA.
}
