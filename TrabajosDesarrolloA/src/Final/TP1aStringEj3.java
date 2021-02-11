/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final;

import utiles.TecladoIn;

/**
 *
 * @author Walter
 */
public class TP1aStringEj3 {
    public static void main(String []arg){
    double a,b,c,x1,x2;
        System.out.println("Ingrese \"a\", \"b\" y \"c\" de ax^2+bx+c=0");
        a = TecladoIn.readDouble();
        b = TecladoIn.readDouble();
        c = TecladoIn.readDouble();
        
        x1 = (-b + Math.sqrt(b*b-4*a*c)/2*a);
        x2 = (-b - Math.sqrt(b*b-4*a*c)/2*a);
        
        System.out.println("Las raices son: x1="+x1+" x2="+x2);
    }
    
}
