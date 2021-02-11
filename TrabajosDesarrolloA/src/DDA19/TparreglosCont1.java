/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DDA19;

import static DDA19.TpArreglosContexto1.ejercicioA;
import utiles.TecladoIn;

/**
 *
 * @author Walter
 */
public class TparreglosCont1 {

    public static void main(String[] args) {
        //DECLARO VARIABLES
        int[] cn = new int[4];
        int[] nuevoCn = new int[cn.length * 2];
        char opcion;
        //Empiezo algoritmo
        System.out.println(" ingrese uno a uno los digitos");
        for (int i = 0; i < cn.length; i++) {
            cn[i] = TecladoIn.readLineInt();
        }
        //verifico que el codigo sea correcto
        if (VerificarCn(cn) == true) {
            System.out.println("Elija la opcion deseada:");
            System.out.println("a) Calcula y muestra el nuevo codigo numerico");
            System.out.println("b) Muestra la cantidad de digitos primos");
            System.out.println("c) Muestra la cantidad de digitos equivalentes a tres cifras");
            System.out.println("d) Muestra la cantidad de digitos equivalentes a una cifra");
            System.out.println("e) Muestra la cantidad de digitos equivalentes entre 20 y 40");

            opcion = TecladoIn.readLineNonwhiteChar();

            switch (opcion) {
                case 'a':
                    CalculaNcn(cn, nuevoCn);
                    break;
                case 'b':
                    System.out.println("La cantidad de digitos primos es " + ContPrimo(cn));
                    break;
                case 'c':
                    System.out.println(" La cantidad de digitos que generaron valores equivalentes de tres cifras son:" + tresC(cn, nuevoCn));
                    break;
                case 'd':
                    System.out.println(" La cantidad de digitos que generaron valores equivalentes de una cifra son:" + unaC(cn, nuevoCn));
                    break;
                case 'e':
                    System.out.println(" La cantidad de digitos que generaron valores equivalentes entre 20 y 40 son:" + entreVyc(cn, nuevoCn));
                    break;
                default:
                    System.out.println("Error");
            }
        } else {
            System.out.println("el codigo numerico que ingreso no tiene la cantidad suficiente de numeros primos(2)");
        }
    }

    public static boolean VerificarCn(int cn[]) {
        boolean valido;
        int cont = 0, i = 0;

        while (cont <= 2 && i < cn.length) {
            if (cn[i] == 1 || cn[i] == 2 || cn[i] == 3 || cn[i] == 5 || cn[i] == 7) {
                cont = cont + 1;

            }
            i = i + 1;
        }
        if (cont >= 2) {
            valido = true;

        } else {
            valido = false;
        }

        return valido;
    }

    public static void CalculaNcn(int cn[], int nuevoCn[]) {
        int aux = 0;
        for (int i = 1; i < nuevoCn.length; i = i + 2) {
            nuevoCn[i - 1] = cn[aux];
            nuevoCn[i] = (cn[aux] + 5) * 3;
            aux = aux + 1;
        }

        System.out.print("El nuevo codigo numerico es: ");
        for (int i = 0; i < nuevoCn.length; i++) {
            System.out.print(nuevoCn[i]);
            System.out.print(" ");

        }

    }

    public static int ContPrimo(int cn[]) {

        int cont = 0;
        for (int i = 0; i < cn.length; i++) {
            if (cn[i] == 1 || cn[i] == 2 || cn[i] == 3 || cn[i] == 5 || cn[i] == 7) {
                cont = cont + 1;
            }
        }

        return cont;
    }

    public static int tresC(int cn[], int nuevoCn[]) {
        int aux = 0;
        for (int i = 1; i < nuevoCn.length; i = i + 2) {
            nuevoCn[i - 1] = cn[aux];
            nuevoCn[i] = (cn[aux] + 5) * 3;
            aux = aux + 1;
        }
        int cont = 0;
        for (int i = 1; i < nuevoCn.length; i = i + 2) {

            if (nuevoCn[i] >= 100 || nuevoCn[i] <= -100) {
                cont = cont + 1;
            }
        }
        return cont;
    }

    public static int unaC(int cn[], int nuevoCn[]) {
        int aux = 0;
        int cont = 0;

        for (int i = 1; i < nuevoCn.length; i = i + 2) {
            nuevoCn[i - 1] = cn[aux];
            nuevoCn[i] = (cn[aux] + 5) * 3;
            aux = aux + 1;
        }

        for (int i = 1; i < nuevoCn.length; i = i + 2) {
            if (nuevoCn[i] < 10 && nuevoCn[i] > -10) {
                cont = cont + 1;
            }
        }
        return cont;
    }

    public static int entreVyc(int cn[], int nuevoCn[]) {
        int cont = 0, aux = 0;

        for (int i = 1; i < nuevoCn.length; i = i + 2) {
            nuevoCn[i - 1] = cn[aux];
            nuevoCn[i] = (cn[aux] + 5) * 3;
            aux = aux + 1;
        }
        for (int i = 1; i < nuevoCn.length; i = i + 2) {
            if (nuevoCn[i] >= 20 && nuevoCn[i] <= 40) {
                cont = cont + 1;
            }

        }

        return cont;
    }

}
