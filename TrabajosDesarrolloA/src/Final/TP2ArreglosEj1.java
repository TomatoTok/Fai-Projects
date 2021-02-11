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
public class TP2ArreglosEj1 {
    public static void main(String []arg){
    int arr [] = new int [4],num,opcion;
    int cn [] = new int [8];
    
    
        System.out.println("Ingrese el codigo");
        num = TecladoIn.readInt();
        arr=cargarCod(num);
        cn = generaCn(arr);
        System.out.println("Elija la opcion: 1)muestra los digitos calculados");
        System.out.println("2)Muestra si cumple con la regla de los numeros primos");
        System.out.println("3)digitos generados de 3 cifras");
        opcion = TecladoIn.readInt();
        switch(opcion){
                case 1: muestraImpar(cn);break;
                case 2:numPrimos(cn);break;
                case 3: tresCifras(cn);break;
            }
        
    }
    public static int[] cargarCod(int num){
    int cod[]=new int [4];
        cod[0]=(num/1000);
        cod[1]=((num/100)%10);
        cod[2]=((num/10)%10);
        cod[3]=(num%10);
       
        return cod;
    }
    public static int[] generaCn(int arr[]){
        int cn [] = new int [8],aux=0;
        for (int i = 0; i < cn.length ; i=i+2) {
            cn[i]=arr[aux];
            cn[i+1]=(arr[aux]+5)*3;  
            aux=aux+1;
        }
        return cn;
    }
    public static void muestraImpar(int cn[]){
        System.out.println("Numeros en posiciones impar:");
        System.out.println("");
        for (int i = 1; i <cn.length; i=i+2) {
            System.out.print(cn[i]);
            
        }
    
    }
    public static void numPrimos(int cn[]){
        int cont=0;
        for (int i = 0; i < cn.length; i=i+2) {
            if (cn[i] == 1 ||cn[i] == 2 ||cn[i] == 3 ||cn[i] == 5 ||cn[i] == 7 ) {
                cont=cont+1;
            }}
            if (cont>=2) {
                System.out.println("Cumple la regla");
            }
            else{
                System.out.println("no cumple la regla");}
            
        
    }
    public static void tresCifras(int cn[]){
    int cont=0;
        for (int i = 1; i < cn.length; i=i+2) {
            if ((cn[i]/100)>0) {
                cont=cont+1;
            }
        }
        System.out.println("La cantidad de digitos equivalentes a 3 cifras es de:"+cont);
    }
}
