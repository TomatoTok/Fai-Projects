/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filosofos;

/**
 *
 * @author Tomi
 */
public class main {
    public static void main(String[] args) {
        crearMesa(5);
    }
    public static void crearMesa(int cantidadFilosofos){
        Tenedor tenedores[] = new Tenedor[cantidadFilosofos];
        for (int i = 0; i < cantidadFilosofos; i++) {
            tenedores[i] = new Tenedor("Tenedor-> "+i);
        }
        
        Filosofo filosofos[] = new Filosofo[cantidadFilosofos];
        for (int i = 0; i < cantidadFilosofos-1; i++) {
            filosofos[i] = new Filosofo(tenedores[i], tenedores[i+1], "Filosofo-> "+i ,i/2 == 0 ? 'I' : 'D');
        }
        filosofos[cantidadFilosofos-1] = new Filosofo(tenedores[cantidadFilosofos-1],tenedores[0],"Filosofo-> "+ (cantidadFilosofos-1) ,cantidadFilosofos/2 == 0 ? 'I' : 'D');
        for (int i = 0; i < cantidadFilosofos; i++) {
            filosofos[i].start();
        }
    }
}
