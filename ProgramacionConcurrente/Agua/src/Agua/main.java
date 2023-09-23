/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Agua;

/**
 *
 * @author Tomi
 */
public class main {

    public static void main(String[] args) {
        int topeRec = 2;
        int aguaEnvasar = 4;
        Recurso recurso = new Recurso(topeRec, aguaEnvasar);//topeRecipiente, aguaEnvasar
        System.out.println("Tope de recipiente:"+topeRec+" Cantidad de Agua a envasar:"+aguaEnvasar);
        Generador generador = new Generador(recurso);
        generador.start();
    }
}
