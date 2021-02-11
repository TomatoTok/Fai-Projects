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
public class Metodo_Euler {
    public static void main(String [] arg){
        ecuacion();

    }
    public static double f(double x ,double y){
        Scanner sc = new Scanner(System.in);
        float num1 =-2,num2 =5;
        float div = num1 / num2;
        double resultado = (div*(y))+2;
    return resultado;
    }
    
    public static void ecuacion(){
        double xmin,xmax,y,h;
        int iter=0;
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el valor minimo de x");
            xmin = sc.nextDouble();
            System.out.println("Ingrese el valor maximo de x");
            xmax = sc.nextDouble();
            System.out.println("Ingrese el valor inicial de y");
            y = sc.nextDouble();
            System.out.println("Ingrese el valor h");
            h = sc.nextDouble();
            System.out.println("Iteracion\t x\t y");
            for (double i = xmin; i <= xmax; i=i+h) {
                System.out.println("\t"+iter+"\t" + i + "\t" + y);
                iter++;
                y = y + h*(f(i,y));
        }
            
    }
}
