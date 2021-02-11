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
public class Biseccion {
    public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
       double r;
       System.out.println("Ingrese el valor de a");
       double a=sc.nextDouble();
       System.out.println("Ingrese el valor de b");
       double b=sc.nextDouble();
       System.out.println("Ingrese el valor del Error E");
       double E=sc.nextDouble();
       if((f(a)*f(b)<0)){
          do{
              r=(a+b)/2;
              System.out.println("r: "+r);
              if((f(a)*f(r))<0){
                  b=r;
              }
              else{
                          a=r;
              }
            }
            while(!((Math.abs(a-b))<=E));
                  System.out.println("Raiz aproximada: "+r);

        }

       else{
           System.out.println("No se cumple la condicion inicial f(a)*f(b)<0");
       }
    }

    public static double f(double x){
        double resultado = (x*x*x)-2*x-1;
        return resultado;
    }

}

