/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProdCons;

/**
 *
 * @author Tomi
 */
public class main {

    public static void main(String[] args) {

        Buffer b = new Buffer();
        Productor prod = new Productor(b);
        Consumidor cons = new Consumidor(b);
        prod.start();
        cons.start();
    }
}
