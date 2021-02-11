/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculos;

import java.util.Scanner;

/**
 *
 * @author Walter
 */
public class Sumas_Riemann {
    public static void main(String[]arg){
    
        Scanner sc = new Scanner(System.in);
        int n,m;
        Double a;
        System.out.println("Ingrese los valores de n y m");
        n = sc.nextInt();
        m = sc.nextInt();
        System.out.println("Ingrese el valor del area");
        a = sc.nextDouble();
        System.out.println("La suma total es: "+ sumaTotal(n,m,a));
    }
    public static double sumaTotal(int n, int m,double a){
    double suma = 0;
        for (double i = 1.0; i <= n; i=i+0.5) {
            for (double j = 1.0; j <= m; j=j+0.5) {
                suma = suma + f(i,j,a);
                System.out.println(suma);
            }
        }
    return suma;
    }
    
    public static double f(double n,double m,double a){
    double resultado;
    resultado = 16-(n*n)-2*(m*m);                 //ACA VA LA FUNCION
    resultado= resultado * a;
    return resultado;    
    }
}
