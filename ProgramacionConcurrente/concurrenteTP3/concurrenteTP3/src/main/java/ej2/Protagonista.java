/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej2;

/**
 *
 * @author Tomi
 */
public class Protagonista{
    private int vida = 100;
    private boolean estaVivo = true;
    public Protagonista() {
        super();
    }
    
    public synchronized boolean alterarVida(int valor) {
         
        if(!estaVivo){
            System.out.println("No es posible alterar la vida de este personaje");
        }else{
            System.out.println("Se altera la vida en un "+ valor);    
            this.vida += valor;
            System.out.println("La vida es: "+vida);
            if(vida <=0){
                estaVivo=false;
            }
        }
        return estaVivo;
    }
    
    //Este metodo funciona como un falso semaforo que nos indica si es posible 
    //utilizar el metodo de alterar vida y no quedar pegado en el synchronized
    
    public synchronized int getVida(){
        return vida;
    }
}
