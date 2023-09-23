/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perrosYgatos;

/**
 *
 * @author Tomi
 */
public class main {

    public static void main(String[] args) {
        Comedor comedor = new Comedor(3);
        prenderM(10, comedor);
        prenderP(10, comedor);
    }

    public static void prenderM(int cant, Comedor com) {
        Michi gatitos[] = new Michi[cant];
        for (int i = 0; i < cant; i++) {
            gatitos[i] = new Michi(com);
            gatitos[i].start();
        }
    }

    public static void prenderP(int cant,Comedor com) {
        Doggy perritos[] = new Doggy[cant];
        for (int i = 0; i < cant; i++) {
            perritos[i] = new Doggy(com);
            perritos[i].start();
        }
    }
}
