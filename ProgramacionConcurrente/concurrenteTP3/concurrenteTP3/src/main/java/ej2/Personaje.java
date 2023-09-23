/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej2;

/**
 *
 * @author Tomi
 */
public class Personaje extends Thread{
    private int ataque = 10;
    private int defensa = 10;
    private int vida = 100;
    public Personaje() {
        
    }
    
    public Personaje(int ataque, int defensa, int vida ) {
        this.ataque = ataque;
        this.defensa = defensa;
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public synchronized int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    
}
