/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;

/**
 *
 * @author Walter
 */
public class Heap {

    private int tamanio = 10;
    private Comparable heap[] = new Comparable[tamanio];
    private int ultimo = 0;

    public Heap() {
    }

    public boolean insertar(Comparable elem) {
        boolean valor = false;
        //verifico que el arreglo no este completo
        if (this.ultimo + 1 < this.tamanio) {
            this.ultimo++;
            this.heap[ultimo] = elem;
            //Hago subir el elemento hasta la posicion que le corresponde
            hacerSubir(this.ultimo);
            valor = true;
        }
        return valor;
    }

    public Comparable recuperarCima() {
        //Devuelve el elemento de la cima del arbol
        return this.heap[1];
    }

    public boolean eliminarCima() {
        boolean exito;
        if (this.ultimo == 0) {
            //estructura vacia
            exito = false;
        } else {
            //saca la raiz y pone la ultima hoja en su lugar
            this.heap[1] = this.heap[ultimo];
            this.ultimo--;
            //reestablece la propiedad de heap minimo
            hacerBajar(1);
            exito = true;
        }
        return exito;
    }

    private void hacerSubir(int hijo) {
        boolean valor = true;
        Comparable aux = this.heap[hijo];
        int padre;

        while (valor) {
            padre = hijo / 2;
            if (padre >= 1) {
                //comparo si el valor del padre es menor que el de su hijo y lo hago subir
                if (this.heap[padre].compareTo(aux) > 0) {
                    this.heap[hijo] = this.heap[padre];
                    this.heap[padre] = aux;
                    hijo = padre;
                } //Sino termina el recorrido
                else {
                    valor = false;
                }
            } else {
                valor = false;
            }
        }

    }

    private void hacerBajar(int posPadre) {
        int posH;
        Comparable temp = this.heap[posPadre];
        boolean salir = false;
        while (!salir) {
            posH = posPadre * 2;
            if (posH <= this.ultimo) {
                // temp tiene al menos un hijo (izq) y lo considera menor
                if (posH < this.ultimo) {
                    // hijo menor tiene hermano derecho
                    // el hijo derecho es menor que los dos
                    if (this.heap[posH + 1].compareTo(this.heap[posH]) < 0) {
                        posH++;
                    }
                }
                // compara al hijo menor con el padre
                if (this.heap[posH].compareTo(temp) < 0) {
                    // el hijo es menor que el padre, los intercambia
                    this.heap[posPadre] = this.heap[posH];
                    this.heap[posH] = temp;
                    posPadre = posH;
                } else {
                    // el padre es menor que sus hijos, está bien ubicado
                    salir = true;
                }
            } else {
                salir = true;
            }
        }
    }

    public boolean esVacio() {
        boolean valor = true;
        //verifica que no exista ningun elemento insertado en el arreglo a travez del atributo ultimo
        if (ultimo != 0) {
            valor = false;
        }
        return valor;
    }

    public String toString() {
        String total = "";
        int izquierdo, derecho, i = 1;

        while (i <= this.ultimo) {
            System.out.print("Nodo: " + this.heap[i] + " ");
            izquierdo = i * 2;
            derecho = izquierdo + 1;
            if (izquierdo <= this.ultimo && this.heap[izquierdo] != null) {
                System.out.print("HijoIzq: " + this.heap[izquierdo]);
            } else {
                System.out.print("HijoIzq: -");
            }
            System.out.print("\t");
            if (derecho <= this.ultimo && this.heap[derecho] != null) {
                System.out.println("HijoDer: " + this.heap[derecho]);
            } else {
                System.out.println("HijoDer: -");
            }
            i = i + 1;
        }
        return total;
    }

    public Heap clone() {
        //Aprovecho que es un arreglo y utilizo los metodos del mismo
        Heap clon = new Heap();
        clon.heap = this.heap.clone();
        clon.ultimo = this.ultimo;
        return clon;
    }
}
