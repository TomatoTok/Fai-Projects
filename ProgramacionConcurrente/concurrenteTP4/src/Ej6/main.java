/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej6;

/**
 *
 * @author Tomi
 */
public class main {

    public static void main(String[] args) {
        Restauran pollosHermanos = new Restauran();
        Empleado emp = new Empleado("Martin", pollosHermanos);
        Empleado emp1 = new Empleado("Tomas", pollosHermanos);
        Mozo mozo = new Mozo("mozo 1", pollosHermanos,2);

        emp.start();
        emp1.start();
        mozo.start();
    }
}
