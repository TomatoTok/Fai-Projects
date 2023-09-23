/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej4;

/**
 *
 * @author Tomi
 */
public class mainImpresora {

    public static void main(String[] args) {
        Impresora impA1 = new Impresora('A');
        Impresora impA2 = new Impresora('A');
        Impresora impA3 = new Impresora('A');
        Impresora impB1 = new Impresora('B');
        Impresora impB2 = new Impresora('B');
        Impresora impresoras[] = {impA1, impA2, impA3,impB2, impB1};
        Trabajos trabA1 = new Trabajos('A',impresoras);
        Trabajos trabA2 = new Trabajos('A',impresoras);
        Trabajos trabA3 = new Trabajos('A',impresoras);
        Trabajos trabX1 = new Trabajos('X',impresoras);
        Trabajos trabB1 = new Trabajos('B',impresoras);
        Trabajos trabB2 = new Trabajos('B',impresoras);
        Trabajos trabX2 = new Trabajos('X',impresoras);
        Trabajos todos[] = {trabA1, trabA2, trabA3, trabB1, trabB2, trabX1, trabX2};
        realizarImpresiones(todos);
    }

    public static void realizarImpresiones(Trabajos trabajos[]) {
        for (int i = 0; i < trabajos.length; i++) {
            trabajos[i].start();
        }
    }


}
