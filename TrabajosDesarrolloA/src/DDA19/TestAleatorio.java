/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DDA19;

import utiles.TecladoIn;

/**
 *
 * @author Walter
 */
public class TestAleatorio {
    public static void main (String [] arg ){
    char opcion='1';
    Aleatorio arrAle[] = new Aleatorio [10],arrAle2[],arrAle3[];
    cargar(arrAle);
    while(opcion != 'x'){
    menu();
    opcion = TecladoIn.readLineNonwhiteChar();
    switch(opcion){
    
        case 'a' :  arrAle2 = clonarArr(arrAle);break;
        case 'b' :  if (ordenado(arrAle)) {System.out.println("Esta ordenado de manera decreciente");}
                    else{System.out.println("No esta ordenado de manera decreciente");};break;

        case 'c' :  mostrar(arrAle);break;
        case 'd' : igual(arrAle);break;
        case 'e' : seleccion(arrAle);break;
        case 'f' : burbujaMejorado(arrAle);break;
        case 'g' : insercion(arrAle);break;
        case 'x' : System.out.print("     :)    ");break;
        default : System.out.println("ERROR opcion no valida");break;
      }}
      
    //system.nanotime
    
    }
    public static void cargar(Aleatorio arr[]){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Aleatorio();
        }
    }
    
    public static Aleatorio[] clonarArr(Aleatorio arrAle[]){
        Aleatorio arrAle2[] = new Aleatorio [arrAle.length];
        cargar(arrAle2);
      
        for (int i = 0; i < arrAle.length; i++) {
            arrAle[i].clonar(arrAle2[i]);
        }
        System.out.println("Arreglo original");
          for (int i = 0; i <arrAle.length; i++) {
            System.out.print(arrAle[i].toStringAle());
            System.out.println(" ");
        } 
          System.out.println();
          System.out.println("Arreglo clonado");       
         for (int i = 0; i <arrAle.length; i++) {
            System.out.print(arrAle2[i].toStringAle());
            System.out.println(" ");
        }
        return arrAle2;
    }
    
    public static boolean ordenado(Aleatorio arrAle[]){
    boolean val = true;
    int pos=0;
    while (pos < arrAle.length-1 && val ){
        if (arrAle[pos].compararCon(arrAle[pos+1]) <= 0) {
            val=false;
          }
        else{ pos++;}       
    }
    return val;
    }
    
    public static boolean igual(Aleatorio arrAle[]){
    Aleatorio arrAle2[] = new Aleatorio [arrAle.length];
    cargar(arrAle2);
    boolean corte=true;
    int i=0;
        while(corte && i<arrAle.length){
        corte = arrAle[i].equals(arrAle2[i]);
        i++;
        }
        if (corte) {
            System.out.println("Los arreglos son iguales");
        }
        else{System.out.println("Los arreglos no son iguales");}
    return corte;
    }
    
    public static void mostrar(Aleatorio arrAle[]){
        for (int i = 0; i < arrAle.length; i++) {
            System.out.println(arrAle[i].toStringAle());
        }
        
    }
    
    public static void seleccion (Aleatorio arrAle[]){
        double tiempoIn,tiempoFin;
        tiempoIn = System.nanoTime();
        int min;    
        Aleatorio aux;
        
        for (int i = 0; i < arrAle.length-1; i++) {
            min = i;
            for (int j = i+1; j < arrAle.length; j++) {
                if (arrAle[j].getNum() > arrAle[min].getNum()) {
                    min = j;
                    aux = arrAle[i];
                    arrAle[i] = arrAle[min];
                    arrAle[min] = aux;
                }
            }            
        }
        tiempoFin = System.nanoTime();
    mostrar(arrAle);
    System.out.println("su tiempo: "+ (tiempoFin - tiempoIn) +"Nanosegundos");
    }
    
    public static void burbujaMejorado(Aleatorio arrAle[]){
    double tiempoIn,tiempoFin;
    tiempoIn = System.nanoTime();
    int i=0;    
    Aleatorio aux;
    boolean ordenado = false;
    while(i< arrAle.length && !ordenado){
    ordenado = true;
        for (int j = 0; j < arrAle.length-1-i; j++) {
            if (arrAle[j].getNum() < arrAle[j+1].getNum()) {
                ordenado = false;
                aux = arrAle[j];
		arrAle[j]=arrAle[j+1];
		arrAle[j+1]= aux;}
            }
        i=i+1;
    }
    tiempoFin = System.nanoTime();
    mostrar(arrAle);
    System.out.println("su tiempo: "+ (tiempoFin - tiempoIn) +"Nanosegundos");    }
    
    public static void insercion(Aleatorio arrAle[]){
    double tiempoIn,tiempoFin;
    tiempoIn = System.nanoTime();
    Aleatorio temp;
    int j;
    
        for (int i  = 0; i < arrAle.length; i++) {
        temp= arrAle[i];
            j = i;
            while(j>0 && temp.getNum() > arrAle[j-1].getNum()){
            arrAle[j]= arrAle[j-1];
                    j=j-1;
            }
            arrAle[j]=temp;
        }
        tiempoFin = System.nanoTime();
    mostrar(arrAle);
    System.out.println("su tiempo: "+ (tiempoFin - tiempoIn) +"Nanosegundos");
    }
    public static void menu(){
        System.out.println("----------------------------------------");
        System.out.println("Elije una opcion (letra x para salir)");
        System.out.println();
        System.out.println("a)Clonar al arreglo y mostrarlo");
        System.out.println("b)Verifica si un arreglo esta ordenado de manera decreciente");
        System.out.println("c)Muestra el arreglo");
        System.out.println("d)Verifica que dos arreglos sean iguales");
        System.out.println();
        System.out.println("Muestra de los metodos de ordenamiento y el tiempo:");
        System.out.println("e)Selección");
        System.out.println("f)Burbuja Mejorado");
        System.out.println("g)Insercion");
        System.out.println("---------------------------------------");
    
    }
}
