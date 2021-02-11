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
public class Newton_Raphson {
    public static void main (String [] arg){
    Scanner sc= new Scanner(System.in);
    double x1,x0,E,fun,der;
        System.out.println("Ingrese x0: ");
        x0 = sc.nextDouble();
        x1=x0;
        System.out.println("Ingrese el valor del error E:");
        E= sc.nextDouble();
        while(Math.abs(f(x1))>E){
            System.out.println("x0: "+x0);
            System.out.println("f(x0): "+ f(x0));
            System.out.println("df(x0):"+df(x0));
            x1= x0 - (f(x0)/df(x0));
            System.out.println("x1:"+x1);
            x0=x1;
        }
        System.out.println("Raiz aproximada: "+x1);
    }
    public static double f(double x){
    double resultado = 1*(x*x*x)-2*x-1;  // <----- INSERTAR FUNCION
    return resultado;
    }
    public static double df(double x){
    double resultado =3*(x*x)-2; // <---- INSERTAR DERIVADA
    return resultado;
    }
}
