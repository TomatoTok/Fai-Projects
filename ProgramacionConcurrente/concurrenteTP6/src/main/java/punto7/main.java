/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package punto7;

/**
 *
 * @author Tomi
 */
public class main {
    public static void main(String[] args) {
        Olla ollapolla = new Olla(10);
        Cocinero cocinero = new Cocinero(ollapolla);
        cocinero.start();
        for (int i = 0; i < 50; i++) {
            Canibal cani = new Canibal(ollapolla, i+"");
            cani.start();
        }
    }
}
