
import utiles.TecladoIn;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Walter
 */
public class TP1aStringEj1 {
    public static void main (String[]arg){
    int cont=0,num,prom,suma=0;
    char val='s';
     while(val =='s'){
         System.out.println("Ingrese un numero");
         num = TecladoIn.readInt();
         cont=cont+1;
         suma=suma+num;
         System.out.println("Desea ingresar otro numero?(s/n)");
         val = TecladoIn.readChar();
     }
     prom=suma/cont;
        System.out.println("la cantidad de numeros que ingreso: "+cont+" su promedio es de: "+prom);
    }
    
}
