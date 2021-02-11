/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DDAUltimate;

import utiles.TecladoIn;

/**
 *
 * @author Walter
 */
public class TestInmobiliariaII {

    public static void main(String[] arg) {
        Propiedad arrProp[] = new Propiedad[100];
        int pos = 10;
        char opcion = ' ';
        cargaInicial(arrProp);
        while (opcion != 'x' && pos < arrProp.length) {
            menu();
            opcion = TecladoIn.readLineNonwhiteChar();
            pos = opcionElegida(opcion, pos, arrProp);
        }
        if (pos >= arrProp.length) {
            System.out.println("Supero el limite de carga");
        }
    }

    public static void cargaInicial(Propiedad[] arrProp) {
        arrProp[0] = new Propiedad(1325, 'x', "Buenos Aires", 4, 'v', 18, true, 5000);
        arrProp[1] = new Propiedad(48923, 'd', "Paraguay", 1, 'v', 30, false, 6000);
        arrProp[2] = new Propiedad(98312, 'c', "Bolivia", 5, 'a', 101, true, 13000);
        arrProp[3] = new Propiedad(4983, 'v', "Menguelle", 3, 't', 27, true, 24000);
        arrProp[4] = new Propiedad(92839, 'd', "Ecuador", 1, 'a', 34, false, 12000);
        arrProp[5] = new Propiedad(3241, 'c', "Manuel Estrada", 2, 'a', 117, true, 4000);
        arrProp[6] = new Propiedad(1523, 'x', "Los alerces", 2, 't', 20, true, 10000);
        arrProp[7] = new Propiedad(14523, 'c', "Talero", 4, 't', 14, true, 8500);
        arrProp[8] = new Propiedad(15543, 'd', "Primeros Pobladores", 8, 't', 70, false, 18000);
        arrProp[9] = new Propiedad(14432, 'x', "Jorge Newberry", 2, 'v', 15, true, 11000);
    }

    public static void cargaDatos(Propiedad[] arrProp, int pos) {
        int cod, cantAmb, sup, prec;
        char tip = ' ', oper = ' ', aux;
        String dir;
        boolean dis;
        System.out.println("Ingrese el codigo");
        cod = TecladoIn.readInt();
        while (tip != 'c' && tip != 'd' && tip != 'x') {
            System.out.println("Ingrese el tipo (c-casa, d-departamento o x-duplex)");
            tip = TecladoIn.readLineNonwhiteChar();
            if (tip != 'c' && tip != 'd' && tip != 'x') {
                System.out.println("Error, ingrese de nuevo el tipo");
            }
        }
        System.out.println("Ingrese la direccion");
        dir = TecladoIn.readLine();
        System.out.println("Ingrese la cantidad de ambientes");
        cantAmb = TecladoIn.readInt();
        while (oper != 'v' && oper != 'a' && oper != 't') {
            System.out.println("Ingrese la operacion(v-venta, a-alquiler o t-alquiler temporario)");
            oper = TecladoIn.readLineNonwhiteChar();
        }
        if (oper != 'v' && oper != 'a' && oper != 't') {
            System.out.println("No es valida la opcion");
        }
        System.out.println("Ingrese la superficie");
        sup = TecladoIn.readInt();
        System.out.println("Ingrese la disponibilidad (s/n)");
        aux = TecladoIn.readLineNonwhiteChar();
        if (aux == 's') {
            dis = true;
        } else {
            dis = false;
        }
        System.out.println("Ingrese el precio");
        prec = TecladoIn.readLineInt();
        Propiedad a = new Propiedad(cod, tip, dir, cantAmb, oper, sup, dis, prec);
        arrProp[pos] = a;
    }

    public static void listar(Propiedad[] arrProp, int pos) {
        for (int i = 0; i < pos; i++) {
            System.out.println(arrProp[i].toString());
        }
    }

    public static void verificarCasa(Propiedad[] arrProp, int pos) {
        for (int i = 0; i < pos; i++) {
            if (arrProp[i].getTipo() == 'c' && arrProp[i].getSuperficie() >= 100 && arrProp[i].getDisponibilidad() == true && arrProp[i].getOperacion() == 'v') {
                System.out.println(arrProp[i].toString());
            }
        }

    }

    public static void verificarDepto(Propiedad[] arrProp, int pos) {
        for (int i = 0; i < pos; i++) {
            if (arrProp[i].getTipo() == 'd' && arrProp[i].getCantAmbiente() == 1 && arrProp[i].getPrecio() < 20000) {
                System.out.println(arrProp[i].toString());
            }
        }

    }

    public static int opcionElegida(char op, int pos, Propiedad arr[]) {
        switch (op) {
            case 'a':
                cargaDatos(arr, pos);
                pos++;
                break;
            case 'b':
                listar(arr, pos);
                break;
            case 'c':
                verificarCasa(arr, pos);
                break;
            case 'd':
                verificarDepto(arr, pos);
                break;
            case 'e':
                burbujaM(arr, pos);
                break;
            case 'f':
                seleccion(arr, pos);
                break;
            case 'g':
                insercion(arr, pos);
                break;
            case 'h':
                ambientes(arr, pos);
                break;
            case 'j':
                superficie(arr, pos);
                break;
            case 'l':
                busqueda(arr, pos);
                break;
            case 'm':
                sort(arr, 0, pos - 1);
                break;
            case 'x':
                System.out.println("Fin del programa");
                break;
            default:
                System.out.println("ERROR");
                break;

        }
        return pos;
    }

    public static void menu() {
        System.out.println("---------------------");
        System.out.println("Elija una opcion:");
        System.out.println("a) Cargar un dato");
        System.out.println("b) Listar las propiedades");
        System.out.println("c) Verificar las casas");
        System.out.println("d) Verificar los departamentos");
        System.out.println("e) Ordenar con metodo Burbuja Mejorado");
        System.out.println("f) Ordenar con metodo Seleccion");
        System.out.println("g) Ordenar con metodo Inserccion");
        System.out.println("h) Busqueda de cantidad de ambientes");
        System.out.println("j) Busqueda de la propiedad de mayor superficie");
        System.out.println("l) Busqueda de propiedad por precio");
        System.out.println("m) Ordenar con metodo avanzado MergeSort");
        System.out.println("x) Salir del pograma");
    }

    //OPERACIONES DEL TRABAJO PRACTICO OBLIGATORIO III
    public static void burbujaM(Propiedad[] arr, int pos) {
        boolean ordenado = false;
        int i = 0;
        while (i < pos && !ordenado) {
            ordenado = true;
            for (int j = 0; j <= pos - i - 2; j++) {
                if (arr[j].getPrecio() > arr[j + 1].getPrecio()) {
                    ordenado = false;
                    intercambiar(arr, j);
                }
            }
            i++;
        }
    }

    public static void intercambiar(Propiedad[] arr, int j) {
        Propiedad o;
        o = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = o;
    }

    public static void seleccion(Propiedad arr[], int pos) {
        int min;
        Propiedad aux;
        for (int i = 0; i < pos; i++) {
            min = i;
            for (int j = i + 1; j < pos; j++) {
                if (arr[j].getPrecio() < arr[min].getPrecio()) {
                    min = j;
                }
            }
            aux = arr[i];
            arr[i] = arr[min];
            arr[min] = aux;
        }
    }

    public static void insercion(Propiedad arr[], int pos) {
        int j;
        Propiedad aux;
        for (int i = 1; i < pos; i++) {
            aux = arr[i];
            j = i;
            while (j > 0 && aux.getPrecio() < arr[j - 1].getPrecio()) {
                arr[j] = arr[j - 1];
                j = j - 1;
            }
            arr[j] = aux;
        }
    }

    public static int cantAmbientes(Propiedad arr[], int pos, int num) {
        int total = 0;
        if (pos < 0) {

        } else {
            if (arr[pos].getCantAmbiente() == num) {
                total = 1 + cantAmbientes(arr, pos - 1, num);
            } else {
                total = cantAmbientes(arr, pos - 1, num);
            }
        }
        return total;
    }

    public static void ambientes(Propiedad arr[], int pos) {
        int num;
        System.out.println("¿Cuantos ambientes busca?");
        num = TecladoIn.readInt();
        System.out.println("La cantidad de propiedades con " + num + " de ambientes son:" + cantAmbientes(arr, pos - 1, num));
    }

    public static int mayorSup(Propiedad arr[], int pos) {
        //busca la mayor superficie
        int max = 0;
        if (pos <= 0) {

        } else {
            max = mayorSup(arr, pos - 1);
            if ((arr[pos].getSuperficie()) > arr[max].getSuperficie() && arr[pos].getTipo() == 'c' && arr[pos].getDisponibilidad() && arr[pos].getOperacion() == 'a') {
                max = pos;
            }
        }
        return max;
    }

    public static int verificaCD(Propiedad arr[], int pos) {
        //Verifica que existan casas disponibles, si no existen retorna -1
        boolean aux = false;
        int i = 0;
        while (i <= pos && !aux) {
            if (arr[i].getTipo() == 'c' && arr[i].getDisponibilidad() && arr[i].getOperacion() == 'a') {
                aux = true;
            }
            i++;
        }

        if (aux) {
            return mayorSup(arr, pos);
        } else {
            return -1;
        }
    }

    public static void superficie(Propiedad arr[], int pos) {
        //guardo este pedacito de codigo en un modulo para que su llamado en el switch sea mas corto
        int aux;
        aux = verificaCD(arr, pos - 1);
        if (aux == -1) {
            System.out.println("No existen propiedades que cumplan esas caracteristicas.");
        } else {
            System.out.println(arr[aux].toString());
        }

    }

    public static int busquedaBinaria(Propiedad arr[], int pos, int num) {
        int ini = 0, fin = pos, res = -1, med;
        while (ini <= fin) {
            med = (ini + fin) / 2;
            if (num == arr[med].getPrecio()) {
                res = med;
                ini = fin + 1;
            } else {
                if (arr[med].getPrecio() > num) {
                    fin = med - 1;
                } else {
                    ini = med + 1;
                }
            }
        }
        return res;
    }

    public static void busqueda(Propiedad arr[], int pos) {
        int num,aux;
        System.out.println("Ingrese el precio que desea buscar");
        num = TecladoIn.readInt();
        burbujaM(arr, pos);
        aux = busquedaBinaria(arr, pos, num);
        if (aux == -1) {
            System.out.println("No existe una propiedad con el precio indicado");
        }
        else{System.out.println(arr[aux].toString());
            }
        
    }

    public static void sort(Propiedad arr[], int izq, int der) {

        if (izq < der) {
            //Encuentra el punto medio del vector.
            int medio = (izq + der) / 2;

            //Divide la primera y segunda mitad (llamada recursiva).
            sort(arr, izq, medio);
            sort(arr, medio + 1, der);

            //Une las mitades.
            mezcla(arr, izq, medio, der);
        }
    }

    public static void mezcla(Propiedad arr[], int izq, int medio, int der) {
        int n1 = medio - izq + 1;
        int n2 = der - medio;

        //arreglos temporales.
        Propiedad izqArr[] = new Propiedad[n1];
        Propiedad derArr[] = new Propiedad[n2];

        //Copia los datos a los arreglos temporales.
        for (int i = 0; i < n1; i++) {
            izqArr[i] = arr[izq + i];
        }
        for (int j = 0; j < n2; j++) {
            derArr[j] = arr[medio + j + 1];
        }
        // Une los arreglos temporales

        int i = 0, j = 0;

        int k = izq;

        //Ordenamiento.
        while (i < n1 && j < n2) {
            if (izqArr[i].getSuperficie() <= derArr[j].getSuperficie()) {
                arr[k] = izqArr[i];
                i++;
            } else {
                arr[k] = derArr[j];
                j++;
            }
            k++;
        }

        /* Si quedan elementos por ordenar */
        //Copiar los elementos restantes de izqArr[].
        while (i < n1) {
            arr[k] = izqArr[i];
            i++;
            k++;
        }
        //Copiar los elementos restantes de derArr[].
        while (j < n2) {
            arr[k] = derArr[j];
            j++;
            k++;
        }
    }

}
