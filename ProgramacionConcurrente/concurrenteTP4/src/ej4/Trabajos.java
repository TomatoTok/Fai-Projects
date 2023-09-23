/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej4;

/**
 *
 * @author Tomi
 */
public class Trabajos extends Thread {

    private char tipo;
    private Impresora impresoras[];

    public Trabajos(char tipo, Impresora impresora[]) {
        this.tipo = tipo;
        this.impresoras = impresora;
    }

    public char getTipo() {
        return tipo;
    }

    public void run() {
        realizarImpresion();
    }

    public void realizarImpresion() {
        boolean seImprimio = false;
        int i = 0;
        while (!seImprimio) {
            if (((this.impresoras[i].getTipo() == this.tipo) || 'X' == this.tipo )&& !this.impresoras[i].seEstaUsando()) {
                impresoras[i].usar();
                seImprimio = true;
            } else {
                i = i + 1;
                if (i == impresoras.length) {
                    i = 0;
                }
            }
        }
        System.out.println("Termino impresion "+ Thread.currentThread().getName());
    }

}
