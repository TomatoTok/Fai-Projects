/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perrosYgatos;

/**
 *
 * @author Tomato
 */
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Comedor {

    private Semaphore comenPerros = new Semaphore(0);
    private Semaphore comenGatos = new Semaphore(0);
    private Semaphore cuentas = new Semaphore(1);
    private int gatosEnEspera = 0;
    private int perrosEnEspera = 0;
    private int topeComedor = 0;
    private int enComedor = 0;
    private int terminoComer = 0;

    public Comedor(int cantidadMaxima) {
        this.topeComedor = cantidadMaxima;
        aDespertar();
    }

    //En comer y terminar de comer deberia ser mutex de principio de la funcion hasta que termine, 
    //sino se mezclan las cuentas
    //Metodo para iniciar a comer imparcial :v
    private void aDespertar() {
        int wakeUp = (int) Math.floor(Math.random() * 2 + 1);
        if (wakeUp == 1) {
            System.out.println("Primero comen gatos");
            this.comenGatos.release(this.topeComedor);
        } else {
            System.out.println("Primero comen perros");
            this.comenPerros.release(this.topeComedor);
        }
    }

    public void comerPerros() {
        try {
            cuentas("perrosEnEsperaAdd");//todas las sumas y restas con mutex
            System.out.println("perrito en espera");
            this.comenPerros.acquire();
            System.out.println("Come 1 perro");
            cuentas("enComedorAdd");
            cuentas("perrosEnEsperaSub");
        } catch (InterruptedException ex) {
            Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void terminoComerPerros() {
        System.out.println("termino de comer 1 perro");
        cuentas("terminoComerAdd");
        try {
            this.cuentas.acquire();
            if (this.terminoComer == this.enComedor) { //comparar("terminoComer==enComedor")
                this.terminoComer = 0;
                this.enComedor = 0;
                if (this.gatosEnEspera != 0) {
                    System.out.println("Switch se van los perritos y vienen los gatitos");
                    this.comenGatos.release(3);
                } else {
                    if (this.perrosEnEspera != 0) {
                        System.out.println("No hay mas gatos, entran mas perritos");
                    } else {
                        System.out.println("No hay mas animales que alimentar");
                    }
                    this.comenPerros.release(3);
                }
            }
            this.cuentas.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

//GATOS
    public void comerGatos() {
        try {
            cuentas("gatosEnEsperaAdd");//todas las sumas y restas con mutex
            System.out.println("gatito en espera");
            this.comenGatos.acquire();
            System.out.println("Come 1 gato");
            cuentas("enComedorAdd");
            cuentas("gatosEnEsperaSub");
        } catch (InterruptedException ex) {
            Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void terminoComerGatos() {
        System.out.println("termino de comer 1 gato");
        cuentas("terminoComerAdd");
        try {
            this.cuentas.acquire();
            if (this.terminoComer == this.enComedor) { //comparar("terminoComer==enComedor")
                this.terminoComer = 0;
                this.enComedor = 0;
                if (this.perrosEnEspera != 0) {
                    System.out.println("Switch se van los gatitos vienen los perritos");
                    this.comenPerros.release(3);
                } else {
                    if (this.gatosEnEspera != 0) {
                        System.out.println("No hay mas perros, entran mas gatitos");
                    } else {
                        System.out.println("No hay mas animales que alimentar");
                    }
                    this.comenGatos.release(3);
                }
            }
            this.cuentas.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //CUENTAS OK
    private void cuentas(String tipo) { //Este switch permite exclusion mutua para que no
        try {                           //existan inconsistencias
            switch (tipo) {
                case "terminoComerAdd":
                    this.cuentas.acquire();
                    this.terminoComer++;
                    this.cuentas.release();
                    break;
                case "enComedorAdd":
                    this.cuentas.acquire();
                    this.enComedor++;
                    this.cuentas.release();
                    break;
                case "perrosEnEsperaAdd":
                    this.cuentas.acquire();
                    this.perrosEnEspera++;
                    this.cuentas.release();
                    break;
                case "perrosEnEsperaSub":
                    this.cuentas.acquire();
                    this.perrosEnEspera--;
                    this.cuentas.release();
                    break;
                case "gatosEnEsperaAdd":
                    this.cuentas.acquire();
                    this.gatosEnEspera++;
                    this.cuentas.release();
                    break;
                case "gatosEnEsperaSub":
                    this.cuentas.acquire();
                    this.gatosEnEspera--;
                    this.cuentas.release();
                    break;
                default:
                    throw new AssertionError("ahre");
            }
        } catch (InterruptedException ex) {
        }
    }
}
