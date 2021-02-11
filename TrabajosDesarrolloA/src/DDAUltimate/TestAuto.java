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
public class TestAuto {
    public static void main (String []arg){
    Auto [] arr =new Auto[20];
    int pos=0;
    char opcion=' ';
    while (opcion != 'x'){
        menu();
        opcion=TecladoIn.readLineNonwhiteChar();
    switch (opcion){
        case 'a' : cargarAuto(arr,pos);pos++;break;
        case 'b' : consultar(arr,pos);break;
        case 'c' : alquiler (arr,pos);break;
        case 'd' : devolucion (arr,pos);break;
        case 'e' : mostrarDatos(arr,pos);break;
        case 'f' : mostrarDisp(arr,pos);break;
        case 'x' : System.out.println();break;
        default : System.out.println("Ingrese una opcion valida");break;
    }}
    }
    public static void cargarAuto(Auto arr[],int pos){
    int km;
    String pat,mod;
    boolean disp;
    char aux;
        System.out.println("Ingrese la patente");
        pat = TecladoIn.readLine();
        System.out.println("Ingrese la cantidad de kilometros");
        km = TecladoIn.readInt();
        System.out.println("Ingrese el modelo");
        mod = TecladoIn.readLine();
        System.out.println("Ingrese la Disponibilidad (s,n)");
        aux = TecladoIn.readLineNonwhiteChar();
        if (aux =='s') {
            disp=true;
        }
        else{disp=false;}
        
        arr[pos]= new Auto(pat,km,mod,disp);
    }
    public static void consultar(Auto arr[],int pos){
    String aux="";
    int i=0;
    boolean band=false;
        System.out.println("Ingrese la patente del auto a consultar");
    aux=TecladoIn.readLine();
    
    while(band && i<pos){
        if (arr[i].getPatente().equalsIgnoreCase(aux)) {
            band=true;
        }i++;}
        if (band) {
          System.out.println(arr[i].toString());  
        }
        else{System.out.println("La patente no coincide con ninguna de las almacenadas");}
    }
    public static void alquiler(Auto arr[],int pos){
    String mod;
    int i=0;
    boolean band=false;
        System.out.println("Ingrese el modelo del auto a alquilar");
        mod =TecladoIn.readLine();
        while(band && i<pos){
          if (arr[i].getModelo().equalsIgnoreCase(mod) && arr[i].getDisponible() == true){
          band=true;}
          i++;
        }
        if (band) {
            arr[i].setDisponible(false);
            System.out.println("usted registro un modelo satisfactoriamente");
        }
        else{System.out.println("No contamos con autos disponibles de ese modelo");}
            
        
    }
    public static void devolucion(Auto arr[],int pos){
    String pat;
    int km,i=0;
    boolean band=false;
        System.out.println("Ingrese la patente");
        pat = TecladoIn.readLine();
        while(band && i<pos){
            if (arr[i].getPatente().equalsIgnoreCase(pat)) {
                band=true;
            }
            i++;
}
        if (band) {
            arr[i].setDisponible(true);
                System.out.println("Ingrese la cantidad de km total");
                km = TecladoIn.readInt();
                arr[i].setCuentaKm(km);
        }
        else{System.out.println("La patente ingresada no se encuentra");}
    }
    public static void mostrarDatos(Auto arr[],int pos){
        for (int i = 0; i < pos; i++) {
            System.out.println(arr[i].toString());
            System.out.println();
        }
}
    public static void mostrarDisp(Auto arr[],int pos){
        for (int i = 0; i < pos; i++) {
            if (arr[i].getDisponible()) {
                System.out.println(arr[i].toString());
            }
        }
}
    public static void menu(){
        System.out.println("---------------------------");
        System.out.println("Ingrese la opcion deseada (x para salir)");
        System.out.println("a) Cargar un auto");
        System.out.println("b) Consultar un auto");
        System.out.println("c) Alquilar un auto");
        System.out.println("d) Devolver un auto");
        System.out.println("e) Mostrar todos los autos registrados");
        System.out.println("f) Mostrar todos los autos disponibles");}
    
    
}
