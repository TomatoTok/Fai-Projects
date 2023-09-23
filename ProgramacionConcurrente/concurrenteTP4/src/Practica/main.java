/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica;

/**
 *
 * @author Tomi
 */
public class main {

    public static void main(String[] args) {
        Jaula jaula = new Jaula();
        Hamster h1 = new Hamster("h1", jaula);
        Hamster h2 = new Hamster("h2", jaula);
        Hamster h3 = new Hamster("h3", jaula);
        h1.start();
        h2.start();
        h3.start();

    }
}
